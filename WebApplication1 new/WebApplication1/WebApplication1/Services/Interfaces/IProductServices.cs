using WebApplication1.Models;

namespace WebApplication1.Services.Interfaces
{
    public interface IProductServices
    {
        Task<IEnumerable<Product>> GetAllProductsAsync();
        Task<Product> GetProductByIdAsync(long productId);
        Task<Product> AddProductAsync(Product product);
        Task<Product> UpdateProductAsync(Product product);
        Task<bool> DeleteProductAsync(long productId);
    }
}
