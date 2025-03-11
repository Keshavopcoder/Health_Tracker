using System.Collections.Generic;
using System.Threading.Tasks;
using WebApplication1.Models;

namespace WebApplication1.Services.Interfaces
{
    public interface IUserServices
    {
        Task<IEnumerable<User>> GetAllUsers();
        Task<User> GetUserById(long userId);
        Task<User> RegisterUser(User user);
        Task<User> AuthenticateUser(string email, string password);
        Task<bool> UpdateUser(User user); // Add this
        Task<bool> DeleteUser(long userId); // Add this
    }
}
