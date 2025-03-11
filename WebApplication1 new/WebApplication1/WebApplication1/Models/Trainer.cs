using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using WebApplication1.Models;

namespace TrainerAPI.Models
{
    [Table("Trainers")]
    public class Trainer
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long TrainerId { get; set; }

        [Required]
        public required string TrainerName { get; set; }  

        
        public ICollection<User> Users { get; set; }
        public ICollection<Exercise> Exercises { get; set; }
        public ICollection<Diet> Diets { get; set; }

       
        public Trainer()
        {
            Users = new HashSet<User>();
            Exercises = new HashSet<Exercise>();
            Diets = new HashSet<Diet>();
        }
    }
}
