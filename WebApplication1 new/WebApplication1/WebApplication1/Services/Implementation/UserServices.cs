//using WebApplication1.Models;
//using WebApplication1.Repository.Interfaces;
//using WebApplication1.Services.Interfaces;

//namespace WebApplication1.Services.Implementation
//{
//    public class UserServices : IUserServices
//    {
//        private readonly IUserRepository _userRepository;

//        public UserServices(IUserRepository userRepository)
//        {
//            _userRepository = userRepository;
//        }

//        public async Task<IEnumerable<User>> GetAllUsersAsync()
//        {
//            return await _userRepository.GetAllUsersAsync();
//        }

//        public async Task<User> GetUserByIdAsync(long userId)
//        {
//            return await _userRepository.GetUserByIdAsync(userId);
//        }

//        public async Task<bool> DeleteUserAsync(long userId)
//        {
//            return await _userRepository.DeleteUserAsync(userId);
//        }
//    }
//}






using System.Collections.Generic;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using WebApplication1.Models;
using WebApplication1.Repositories;
using WebApplication1.Repository.Interfaces;
using WebApplication1.Services.Interfaces;

namespace WebApplication1.Services
{
    public class UserService : IUserServices
    {
        private readonly IUserRepository _userRepository;

        public UserService(IUserRepository userRepository)
        {
            _userRepository = userRepository;
        }

        public async Task<IEnumerable<User>> GetAllUsers() => await _userRepository.GetAllUsers();
        public async Task<User> GetUserById(long userId) => await _userRepository.GetUserById(userId);
        public async Task<User> RegisterUser(User user)
        {
            user.Password = HashPassword(user.Password);
            await _userRepository.AddUser(user);
            return user;
        }
        public async Task<User> AuthenticateUser(string email, string password)
        {
            var user = await _userRepository.GetUserByEmail(email);
            return user != null && VerifyPassword(password, user.Password) ? user : null;
        }

        public async Task<bool> UpdateUser(User user) // Implementing UpdateUser
        {
            return await _userRepository.UpdateUser(user);
        }

        public async Task<bool> DeleteUser(long userId) // Implementing DeleteUser
        {
            return await _userRepository.DeleteUser(userId);
        }

        private string HashPassword(string password)
        {
            using (SHA256 sha256 = SHA256.Create())
            {
                byte[] bytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(password));
                StringBuilder builder = new StringBuilder();
                foreach (byte b in bytes) builder.Append(b.ToString("x2"));
                return builder.ToString();
            }
        }

        private bool VerifyPassword(string enteredPassword, string storedPassword)
        {
            return HashPassword(enteredPassword) == storedPassword;
        }
    }
}
