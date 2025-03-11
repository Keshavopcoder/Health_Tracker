using Microsoft.EntityFrameworkCore;
using WebApplication1.Data;
using WebApplication1.Models;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Services
{
    public class ExerciseRepository : IExerciseRepository
    {
        private readonly AppDbContext _context;

        public ExerciseRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<Exercise>> GetAllExercisesAsync()
        {
            return await _context.Exercises.ToListAsync();
        }

        public async Task<Exercise> GetExerciseByIdAsync(long exerciseId)
        {
            return await _context.Exercises.FindAsync(exerciseId);
        }

        public async Task<bool> DeleteExerciseAsync(long exerciseId)
        {
            var exercise = await _context.Exercises.FindAsync(exerciseId);
            if (exercise == null) return false;

            _context.Exercises.Remove(exercise);
            await _context.SaveChangesAsync();
            return true;
        }
    }


}
