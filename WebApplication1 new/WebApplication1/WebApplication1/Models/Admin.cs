namespace WebApplication1.Models
{
    public class Admin
    {
        public long AdminId { get; set; } // Primary Key
        public string AdminName { get; set; }
        public string AdminEmail { get; set; }
        public string AdminPassword { get; set; }

        // Navigation property for related users
        public ICollection<User> Users { get; set; }
    }
}
