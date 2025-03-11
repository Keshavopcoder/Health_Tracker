using Microsoft.EntityFrameworkCore;
using WebApplication1.Data;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Services
{
    public class OrderRepository : IOrderRepository
    {
        private readonly AppDbContext _context;

        public OrderRepository(AppDbContext context)
        {
            _context = context;
        }

        // Get all orders
        public async Task<IEnumerable<Order>> GetAllOrdersAsync()
        {
            return await _context.Orders.ToListAsync();
        }

        // Get a single order by OrderId
        public async Task<Order> GetOrderByIdAsync(long orderId)
        {
            return await _context.Orders.FirstOrDefaultAsync(o => o.OrderId == orderId); // Corrected to use OrderId
        }

        // Delete an order by OrderId
        public async Task<bool> DeleteOrderAsync(long orderId)
        {
            var order = await _context.Orders.FirstOrDefaultAsync(o => o.OrderId == orderId); // Corrected to use OrderId
            if (order == null) return false;

            _context.Orders.Remove(order);
            await _context.SaveChangesAsync();
            return true;
        }
    }


}
