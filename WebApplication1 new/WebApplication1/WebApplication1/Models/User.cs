using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using TrainerAPI.Models;

namespace WebApplication1.Models
{
    public class User
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long UserId { get; set; }

        [Required]
        [StringLength(20)]
        public string FirstName { get; set; }

        [Required]
        [StringLength(20)]
        public string LastName { get; set; }

        [Required]
        [EmailAddress]
        [StringLength(25)]
        public string Email { get; set; }

        [Required]
        [StringLength(500)]
        public string Password { get; set; }  // Will be hashed

        [Required]
        public double RegAmount { get; set; }

        [Required]
        [EnumDataType(typeof(UserRole))]
        public UserRole Role { get; set; }

        // ✅ Many-to-One Relationship with Admin (Newly Added Foreign Key)
        public long? AdminId { get; set; } // Foreign key for Admin
        public virtual Admin? Admin { get; set; } // Navigation property

        // ✅ One-to-Many Relationship with Orders
        public virtual ICollection<Order> Orders { get; set; } = new List<Order>();

        // ✅ Many-to-One Relationship with Trainer
        public long TrainerId { get; set; }
        public virtual Trainer Trainer { get; set; }

        // ✅ One-to-Many Relationship with Goals
        public List<Goal> Goals { get; set; } = new();

        // ✅ One-to-Many Relationship with Exercises
        public List<Exercise> Exercises { get; set; } = new();

        // ✅ Computed Property (Not mapped to DB)
        [NotMapped]
        public string FullName => $"{FirstName} {LastName}";
    }

    // ✅ Define UserRole Enum
    public enum UserRole
    {
        ROLE_ADMIN,
        ROLE_TRAINER,
        ROLE_USER
    }
}
