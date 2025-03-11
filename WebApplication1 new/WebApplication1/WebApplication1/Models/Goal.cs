namespace WebApplication1.Models
{
    public class Goal
    {
        public long GoalId { get; set; } // Primary Key
        public long UserId { get; set; } // Foreign Key
        public string GoalType { get; set; }
        public float TargetWeight { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime TargetDate { get; set; }

        // Navigation property for User
        public required User User { get; set; }
    }
}
