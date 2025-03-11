using WebApplication1.Models;
using WebApplication1.Services.Interfaces;

namespace WebApplication1.Services.Services
{
    public class GoalServices : IGoalServices
    {
        public Task<bool> DeleteGoalAsync(long goalId)
        {
            throw new NotImplementedException();
        }

        public Task<IEnumerable<Goal>> GetAllGoalsAsync()
        {
            throw new NotImplementedException();
        }

        public Task<Goal> GetGoalByIdAsync(long goalId)
        {
            throw new NotImplementedException();
        }
    }
}
