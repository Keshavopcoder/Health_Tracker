using WebApplication1.Models;

namespace WebApplication1.Services.Interfaces
{
    public interface IGoalServices
    {
        Task<IEnumerable<Goal>> GetAllGoalsAsync();
        Task<Goal> GetGoalByIdAsync(long goalId);
        Task<bool> DeleteGoalAsync(long goalId);
    }
}

