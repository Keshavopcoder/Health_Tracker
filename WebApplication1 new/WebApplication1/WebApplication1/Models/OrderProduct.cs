namespace WebApplication1.Models
{
    public class OrderProduct
    {
        public long OrderId { get; set; } // Composite Key
        public long ProductId { get; set; } // Composite Key

        // Navigation properties
        public Order Order { get; set; }
        public Product Product { get; set; }
    }
}
