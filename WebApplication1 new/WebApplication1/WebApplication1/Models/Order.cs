namespace WebApplication1.Models
{
    public class Order
    {
        public long OrderId { get; set; } // Primary Key
        public long UserId { get; set; } // Foreign Key
        public string PaymentStatus { get; set; }
        public string ShippingStatus { get; set; }
        public double TotalAmount { get; set; }

        // Navigation property for User
        public User User { get; set; }

        // Navigation property for related products
        public virtual ICollection<OrderProduct> OrderProducts { get; set; } = new List<OrderProduct>();

    }
}
