using WebApplication1.Models;

namespace WebApplication1.Services.Interfaces
{
    public interface IOrderServices
    {
        Task<IEnumerable<Order>> GetAllOrdersAsync();
        Task<Order> GetOrderByIdAsync(long orderId);
        Task<bool> DeleteOrderAsync(long orderId);
    }
}
