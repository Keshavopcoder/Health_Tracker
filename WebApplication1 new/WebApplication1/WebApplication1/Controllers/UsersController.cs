//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Threading.Tasks;
//using Microsoft.AspNetCore.Http;
//using Microsoft.AspNetCore.Mvc;
//using Microsoft.EntityFrameworkCore;
//using WebApplication1.Data;
//using WebApplication1.Models;

//namespace WebApplication1.Controllers
//{
//    [Route("api/[controller]")]
//    [ApiController]
//    public class UsersController : ControllerBase
//    {
//        private readonly AppDbContext _context;
//        public UsersController(AppDbContext context)
//        {
//            _context = context;
//        }

//        // GET: api/Users
//        [HttpGet]
//        public async Task<ActionResult<IEnumerable<User>>> GetUsers()
//        {
//            return await _context.Users.ToListAsync();
//        }

//        // GET: api/Users/5
//        [HttpGet("{id}")]
//        public async Task<ActionResult<User>> GetUser(long id)
//        {
//            var user = await _context.Users.FindAsync(id);

//            if (user == null)
//            {
//                return NotFound();
//            }

//            return user;
//        }

//        // PUT: api/Users/5
//        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
//        [HttpPut("{id}")]
//        public async Task<IActionResult> PutUser(long id, User user)
//        {
//            if (id != user.UserId)
//            {
//                return BadRequest();
//            }

//            _context.Entry(user).State = EntityState.Modified;

//            try
//            {
//                await _context.SaveChangesAsync();
//            }
//            catch (DbUpdateConcurrencyException)
//            {
//                if (!UserExists(id))
//                {
//                    return NotFound();
//                }
//                else
//                {
//                    throw;
//                }
//            }

//            return NoContent();
//        }

//        // POST: api/Users
//        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
//        [HttpPost]
//        public async Task<ActionResult<User>> PostUser(User user)
//        {
//            _context.Users.Add(user);
//            await _context.SaveChangesAsync();

//            return CreatedAtAction("GetUser", new { id = user.UserId }, user);
//        }

//        // DELETE: api/Users/5
//        [HttpDelete("{id}")]
//        public async Task<IActionResult> DeleteUser(long id)
//        {
//            var user = await _context.Users.FindAsync(id);
//            if (user == null)
//            {
//                return NotFound();
//            }

//            _context.Users.Remove(user);
//            await _context.SaveChangesAsync();

//            return NoContent();
//        }

//        private bool UserExists(long id)
//        {
//            return _context.Users.Any(e => e.UserId == id);
//        }
//    }
//}


using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.IdentityModel.Tokens;
using WebApplication1.Models;
using WebApplication1.Services;
using WebApplication1.Services.Interfaces;

namespace WebApplication1.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        private readonly IUserServices _userService;
        private readonly IConfiguration _configuration;

        public UsersController(IUserServices userService, IConfiguration configuration)
        {
            _userService = userService;
            _configuration = configuration;
        }

        // REGISTER A NEW USER
        [HttpPost("register")]
        public async Task<IActionResult> Register(User user)
        {
            var newUser = await _userService.RegisterUser(user);
            return CreatedAtAction(nameof(Register), new { id = newUser.UserId }, newUser);
        }

        // USER LOGIN (JWT AUTHENTICATION)
        [HttpPost("login")]
        public async Task<IActionResult> Login([FromBody] User user)
        {
            var authenticatedUser = await _userService.AuthenticateUser(user.Email, user.Password);
            if (authenticatedUser == null)
                return Unauthorized("Invalid credentials");

            var token = GenerateJwtToken(authenticatedUser);
            return Ok(new { Token = token, User = authenticatedUser });
        }

        // GET ALL USERS (Protected Route)
        [HttpGet]
        [Authorize]
        public async Task<ActionResult<IEnumerable<User>>> GetUsers()
        {
            return Ok(await _userService.GetAllUsers());
        }

        // GET USER BY ID (Protected Route)
        [HttpGet("{id}")]
        [Authorize]
        public async Task<ActionResult<User>> GetUser(long id)
        {
            var user = await _userService.GetUserById(id);
            if (user == null)
                return NotFound();
            return user;
        }

        // UPDATE USER (Protected Route)
        [HttpPut("{id}")]
        [Authorize]
        public async Task<IActionResult> PutUser(long id, User user)
        {
            if (id != user.UserId)
                return BadRequest();

            try
            {
                await _userService.UpdateUser(user);
            }
            catch (Exception)
            {
                return NotFound();
            }

            return NoContent();
        }

        // DELETE USER (Protected Route)
        [HttpDelete("{id}")]
        [Authorize]
        public async Task<IActionResult> DeleteUser(long id)
        {
            var user = await _userService.GetUserById(id);
            if (user == null)
                return NotFound();

            await _userService.DeleteUser(id);
            return NoContent();
        }

        // GENERATE JWT TOKEN
        private string GenerateJwtToken(User user)
        {
            var claims = new[]
            {
                new Claim(JwtRegisteredClaimNames.Sub, user.Email),
                new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
                new Claim(ClaimTypes.NameIdentifier, user.UserId.ToString()),
                new Claim(ClaimTypes.Role, user.Role.ToString())
            };

            var key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_configuration["Jwt:Key"]));
            var creds = new SigningCredentials(key, SecurityAlgorithms.HmacSha256);

            var token = new JwtSecurityToken(
                _configuration["Jwt:Issuer"],
                _configuration["Jwt:Issuer"],
                claims,
                expires: DateTime.UtcNow.AddHours(1),
                signingCredentials: creds
            );

            return new JwtSecurityTokenHandler().WriteToken(token);
        }
    }
}
