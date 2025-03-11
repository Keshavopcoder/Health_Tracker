using WebApplication1.Models;

namespace WebApplication1.Repository.Interfaces
{
    public interface IGoalRepository
    {
        Task<IEnumerable<Goal>> GetAllGoalsAsync();
        Task<Goal> GetGoalByIdAsync(long goalId);
        Task<bool> DeleteGoalAsync(long goalId);
    }

}
