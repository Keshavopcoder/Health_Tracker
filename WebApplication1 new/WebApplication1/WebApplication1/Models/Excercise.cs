namespace WebApplication1.Models
{
    public class Exercise
    {
        public long ExerciseId { get; set; } // Primary Key
        public long UserId { get; set; } // Foreign Key
        public string ExerciseName { get; set; }
        public TimeSpan Duration { get; set; }
        public float CaloriesBurnt { get; set; }
        public DateTime StartDate { get; set; }

        // Navigation property for User
        public User User { get; set; }
    }
}
