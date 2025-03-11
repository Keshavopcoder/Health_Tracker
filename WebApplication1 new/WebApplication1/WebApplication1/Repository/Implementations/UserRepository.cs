using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using WebApplication1.Data;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Repositories
{
    public class UserRepository : IUserRepository
    {
        private readonly AppDbContext _context;

        public UserRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<User>> GetAllUsers()
        {
            return await _context.Users.Include(u => u.Trainer).Include(u => u.Orders).ToListAsync();
        }

        public async Task<User> GetUserById(long userId)
        {
            return await _context.Users.Include(u => u.Trainer).Include(u => u.Orders)
                .FirstOrDefaultAsync(u => u.UserId == userId);
        }

        public async Task<User> GetUserByEmail(string email)
        {
            return await _context.Users.FirstOrDefaultAsync(u => u.Email == email);
        }

        public async Task AddUser(User user)
        {
            await _context.Users.AddAsync(user);
            await _context.SaveChangesAsync();
        }

        public async Task<bool> UpdateUser(User user)
        {
            _context.Users.Update(user);
            return await _context.SaveChangesAsync() > 0; // Returns true if the update was successful
        }

        public async Task<bool> DeleteUser(long userId)
        {
            var user = await _context.Users.FindAsync(userId);
            if (user == null) return false;

            _context.Users.Remove(user);
            return await _context.SaveChangesAsync() > 0; // Returns true if deletion was successful
        }
    }
}
