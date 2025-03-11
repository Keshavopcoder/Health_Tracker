using WebApplication1.Models;

namespace WebApplication1.Repository.Interfaces
{
    public interface IProductRepository
    {
        Task<IEnumerable<Product>> GetAllProductsAsync();
        Task<Product> GetProductByIdAsync(long productId);
        Task<Product> AddProductAsync(Product product);
        Task<Product> UpdateProductAsync(Product product);
        Task<bool> DeleteProductAsync(long productId);
    }

}
