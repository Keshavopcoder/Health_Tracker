using WebApplication1.Models;

namespace WebApplication1.Services.Interfaces
{
    public interface IExcerciseServices
    {
        Task<IEnumerable<Exercise>> GetAllExercisesAsync();
        Task<Exercise> GetExerciseByIdAsync(long exerciseId);
        Task<bool> DeleteExerciseAsync(long exerciseId);
    }
}
