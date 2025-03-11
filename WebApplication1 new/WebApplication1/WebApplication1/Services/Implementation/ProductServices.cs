using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;
using WebApplication1.Services.Interfaces;

namespace WebApplication1.Services.Implementation
{
    public class ProductServices : IProductServices
    {
        private readonly IProductRepository _productRepository;

        public ProductServices(IProductRepository productRepository)
        {
            _productRepository = productRepository;
        }

        public async Task<IEnumerable<Product>> GetAllProductsAsync()
        {
            return await _productRepository.GetAllProductsAsync();
        }

        public async Task<Product> GetProductByIdAsync(long productId)
        {
            return await _productRepository.GetProductByIdAsync(productId);
        }

        public async Task<bool> DeleteProductAsync(long productId)
        {
            return await _productRepository.DeleteProductAsync(productId);
        }

        public async Task<Product> AddProductAsync(Product product)
        {
            if (product == null)
            {
                throw new ArgumentNullException(nameof(product));
            }

            return await _productRepository.AddProductAsync(product);
        }

        public async Task<Product> UpdateProductAsync(Product product)
        {
            if (product == null)
            {
                throw new ArgumentNullException(nameof(product));
            }

            return await _productRepository.UpdateProductAsync(product);
        }
    }
}
