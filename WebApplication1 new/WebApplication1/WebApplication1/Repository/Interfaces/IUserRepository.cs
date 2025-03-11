using WebApplication1.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace WebApplication1.Repository.Interfaces
{
    public interface IUserRepository
    {
        Task<IEnumerable<User>> GetAllUsers();
        Task<User> GetUserById(long userId);
        Task<User> GetUserByEmail(string email);
        Task AddUser(User user);
        Task<bool> UpdateUser(User user); 
        Task<bool> DeleteUser(long userId); 
    }
}
