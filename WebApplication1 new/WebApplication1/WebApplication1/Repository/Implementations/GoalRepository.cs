using Microsoft.EntityFrameworkCore;
using WebApplication1.Data;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Services
{
    public class GoalRepository : IGoalRepository
    {
        private readonly AppDbContext _context;

        public GoalRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<Goal>> GetAllGoalsAsync()
        {
            return await _context.Goals.ToListAsync();
        }

        public async Task<Goal> GetGoalByIdAsync(long goalId)
        {
            return await _context.Goals.FindAsync(goalId);
        }

        public async Task<bool> DeleteGoalAsync(long goalId)
        {
            var goal = await _context.Goals.FindAsync(goalId);
            if (goal == null) return false;

            _context.Goals.Remove(goal);
            await _context.SaveChangesAsync();
            return true;
        }
    }

}