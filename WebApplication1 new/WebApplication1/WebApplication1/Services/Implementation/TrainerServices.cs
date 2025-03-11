using System.Collections.Generic;
using System.Threading.Tasks;
using TrainerAPI.Models;
using WebApplication1.Services.Interfaces;
using WebApplication1.Repository.Interfaces;

namespace WebApplication1.Services.Implementations
{
    public class TrainerService : ITrainerService
    {
        private readonly ITrainerRepository _trainerRepository;

        public TrainerService(ITrainerRepository trainerRepository)
        {
            _trainerRepository = trainerRepository;
        }

        // Get all trainers
        public async Task<IEnumerable<Trainer>> GetAllTrainersAsync()
        {
            return await _trainerRepository.GetAllTrainersAsync();
        }

        // Get a trainer by ID
        public async Task<Trainer> GetTrainerByIdAsync(int trainerId)
        {
            return await _trainerRepository.GetTrainerByIdAsync(trainerId);
        }

        // Create a new trainer
        public async Task<Trainer> CreateTrainerAsync(Trainer trainer)
        {
            if (trainer == null)
                throw new ArgumentNullException(nameof(trainer), "Trainer data cannot be null.");

            return await _trainerRepository.CreateTrainerAsync(trainer);
        }

        // Update an existing trainer
        public async Task<Trainer> UpdateTrainerAsync(int trainerId, Trainer trainer)
        {
            if (trainer == null)
                throw new ArgumentNullException(nameof(trainer), "Trainer data cannot be null.");

            // Validate if the trainer exists before attempting to update
            var existingTrainer = await _trainerRepository.GetTrainerByIdAsync(trainerId);
            if (existingTrainer == null)
                return null;  // Trainer to update not found, return null

            return await _trainerRepository.UpdateTrainerAsync(trainerId, trainer);
        }

        // Delete a trainer
        public async Task<bool> DeleteTrainerAsync(int trainerId)
        {
            var trainer = await _trainerRepository.GetTrainerByIdAsync(trainerId);
            if (trainer == null)
                return false;  // Trainer to delete not found

            return await _trainerRepository.DeleteTrainerAsync(trainerId);
        }

        public Task UpdateTrainerAsync(Trainer trainer)
        {
            throw new NotImplementedException();
        }
    }
}
