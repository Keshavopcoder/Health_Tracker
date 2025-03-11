using WebApplication1.Models;

namespace WebApplication1.Repository.Interfaces
{
    public interface IExerciseRepository
    {
        Task<IEnumerable<Exercise>> GetAllExercisesAsync();
        Task<Exercise> GetExerciseByIdAsync(long exerciseId);
        Task<bool> DeleteExerciseAsync(long exerciseId);
    }

}
