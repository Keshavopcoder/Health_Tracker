using System.Collections.Generic;
using System.Threading.Tasks;
using TrainerAPI.Models;

namespace WebApplication1.Services.Interfaces
{
    public interface ITrainerService
    {
        Task<IEnumerable<Trainer>> GetAllTrainersAsync();    // Get all trainers
        Task<Trainer> GetTrainerByIdAsync(int trainerId);    // Get trainer by ID
        Task<Trainer> CreateTrainerAsync(Trainer trainer);   // Create a new trainer
        Task<Trainer> UpdateTrainerAsync(int trainerId, Trainer trainer); // Update an existing trainer
        Task<bool> DeleteTrainerAsync(int trainerId);        // Delete a trainer
        Task UpdateTrainerAsync(Trainer trainer);
    }
}
