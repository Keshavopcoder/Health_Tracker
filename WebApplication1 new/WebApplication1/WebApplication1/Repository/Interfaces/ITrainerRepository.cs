using TrainerAPI.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace WebApplication1.Repository.Interfaces
{

    public interface ITrainerRepository
            {
        Task<IEnumerable<Trainer>> GetAllTrainersAsync();
        Task<Trainer> GetTrainerByIdAsync(int trainerId); // Use int
        Task<Trainer> CreateTrainerAsync(Trainer trainer);
        Task<Trainer> UpdateTrainerAsync(int trainerId, Trainer trainer);
        Task<bool> DeleteTrainerAsync(int trainerId); // Use int
    }

    
    }
