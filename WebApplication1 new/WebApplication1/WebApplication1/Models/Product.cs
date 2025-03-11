namespace WebApplication1.Models
{
    public class Product
    {


        public long ProductId { get; set; } // Primary Key
        public string ProductName { get; set; }
        public string Description { get; set; }
        public float Price { get; set; }
        public virtual ICollection<OrderProduct> OrderProducts { get; set; } = new List<OrderProduct>();
    }

}
