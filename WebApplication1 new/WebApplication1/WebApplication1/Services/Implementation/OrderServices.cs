using WebApplication1.Models;

using WebApplication1.Repository.Interfaces;
using WebApplication1.Services.Interfaces;

namespace WebApplication1.Services.Implementation
{
    public class OrderServices : IOrderServices
    {
        private readonly IOrderRepository _orderRepository;

        public OrderServices(IOrderRepository orderRepository)
        {
            _orderRepository = orderRepository;
        }

        public async Task<IEnumerable<Order>> GetAllOrdersAsync()
        {
            return await _orderRepository.GetAllOrdersAsync();
        }

        public async Task<Order> GetOrderByIdAsync(long orderId)
        {
            return await _orderRepository.GetOrderByIdAsync(orderId);
        }

        public async Task<bool> DeleteOrderAsync(long orderId)
        {
            return await _orderRepository.DeleteOrderAsync(orderId);
        }
    }
}
