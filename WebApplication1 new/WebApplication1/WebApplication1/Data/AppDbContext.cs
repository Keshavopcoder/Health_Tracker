using Microsoft.EntityFrameworkCore;
using TrainerAPI.Models;
using WebApplication1.Models;

namespace WebApplication1.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

        // DbSets for Entities
        public DbSet<Trainer> Trainers { get; set; }
        public DbSet<Admin> Admins { get; set; }
        public DbSet<User> Users { get; set; }
        public DbSet<Goal> Goals { get; set; }
        public DbSet<Exercise> Exercises { get; set; }
        public DbSet<Order> Orders { get; set; }
        public DbSet<Product> Products { get; set; }
        public DbSet<OrderProduct> OrderProducts { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // ✅ One-to-Many: Admin → Users
            modelBuilder.Entity<User>()
                .HasOne(u => u.Admin)
                .WithMany(a => a.Users)
                .HasForeignKey(u => u.AdminId)
                .OnDelete(DeleteBehavior.Cascade);

            // ✅ One-to-Many: User → Goals
            modelBuilder.Entity<Goal>()
                .HasOne(g => g.User)
                .WithMany(u => u.Goals)
                .HasForeignKey(g => g.UserId)
                .OnDelete(DeleteBehavior.Cascade);

            // ✅ One-to-Many: User → Exercises
            modelBuilder.Entity<Exercise>()
                .HasOne(e => e.User)
                .WithMany(u => u.Exercises)
                .HasForeignKey(e => e.UserId)
                .OnDelete(DeleteBehavior.Cascade);

            // ✅ One-to-Many: User → Orders
            modelBuilder.Entity<Order>()
                .HasOne(o => o.User)
                .WithMany(u => u.Orders)
                .HasForeignKey(o => o.UserId)
                .OnDelete(DeleteBehavior.Cascade);

            // ✅ Many-to-Many: Orders ↔ Products
            modelBuilder.Entity<OrderProduct>()
                .HasKey(op => new { op.OrderId, op.ProductId });

            modelBuilder.Entity<OrderProduct>()
                .HasOne(op => op.Order)
                .WithMany(o => o.OrderProducts)
                .HasForeignKey(op => op.OrderId)
                .OnDelete(DeleteBehavior.Cascade);

            modelBuilder.Entity<OrderProduct>()
                .HasOne(op => op.Product)
                .WithMany(p => p.OrderProducts)
                .HasForeignKey(op => op.ProductId)
                .OnDelete(DeleteBehavior.Cascade);

            // ✅ Ensure Products auto-increment
            modelBuilder.Entity<Product>()
                .Property(p => p.ProductId)
                .ValueGeneratedOnAdd();
        }
    }
}
