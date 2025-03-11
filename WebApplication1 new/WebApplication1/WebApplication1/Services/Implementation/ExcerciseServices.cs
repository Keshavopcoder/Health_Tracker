using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;
using WebApplication1.Services.Interfaces;

namespace WebApplication1.Services
{
    public class GoalServices : IGoalServices
    {
        private readonly IGoalRepository _goalRepository;

        public GoalServices(IGoalRepository goalRepository)
        {
            _goalRepository = goalRepository; // Single reference to _goalRepository
        }

        public async Task<IEnumerable<Goal>> GetAllGoalsAsync()
        {
            return await _goalRepository.GetAllGoalsAsync();
        }

        public async Task<Goal> GetGoalByIdAsync(long goalId)
        {
            return await _goalRepository.GetGoalByIdAsync(goalId);
        }

        public async Task<bool> DeleteGoalAsync(long goalId)
        {
            return await _goalRepository.DeleteGoalAsync(goalId);
        }
    }
}
