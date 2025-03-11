using WebApplication1.Models;

namespace WebApplication1.Repository.Interfaces
{
    public interface IOrderRepository
    {
        Task<IEnumerable<Order>> GetAllOrdersAsync();
        Task<Order> GetOrderByIdAsync(long orderId);
        Task<bool> DeleteOrderAsync(long orderId);
    }

}
