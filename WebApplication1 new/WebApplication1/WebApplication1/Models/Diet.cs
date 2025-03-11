using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using TrainerAPI.Models;

namespace WebApplication1.Models
{
    [Table("Diets")]
    public class Diet
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long DietId { get; set; }

        [Required]
        public string DietName { get; set; }

        public string Description { get; set; }

        [Required]
        public DateTime CreatedAt { get; set; } = DateTime.UtcNow;

        // Foreign key reference to Trainer
        [ForeignKey("Trainer")]
        public long TrainerId { get; set; }
        public Trainer Trainer { get; set; }
    }
}
