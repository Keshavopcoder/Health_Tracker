using Microsoft.EntityFrameworkCore;
using TrainerAPI.Models;
using WebApplication1.Data;
using WebApplication1.Repository.Interfaces;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace TrainerAPI.Repositories
{
    public class TrainerRepository : ITrainerRepository
    {
        private readonly AppDbContext _context;

        public TrainerRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<Trainer>> GetAllTrainersAsync()
        {
            return await _context.Trainers
                                 .Include(t => t.Users)
                                 .Include(t => t.Exercises)
                                 .Include(t => t.Diets)
                                 .ToListAsync();
        }

        public async Task<Trainer> GetTrainerByIdAsync(int trainerId)  // Changed long to int
        {
            return await _context.Trainers
                                 .Include(t => t.Users)
                                 .Include(t => t.Exercises)
                                 .Include(t => t.Diets)
                                 .FirstOrDefaultAsync(t => t.TrainerId == trainerId);
        }

        public async Task<Trainer> CreateTrainerAsync(Trainer trainer)
        {
            await _context.Trainers.AddAsync(trainer);
            await _context.SaveChangesAsync();
            return trainer;
        }

        public async Task<Trainer> UpdateTrainerAsync(Trainer trainer)
        {
            _context.Entry(trainer).State = EntityState.Modified;
            await _context.SaveChangesAsync();
            return trainer;
        }

        public async Task<bool> DeleteTrainerAsync(int trainerId)  // Changed long to int
        {
            var trainer = await _context.Trainers.FindAsync(trainerId);
            if (trainer == null) return false;

            _context.Trainers.Remove(trainer);
            await _context.SaveChangesAsync();
            return true;
        }

        public Task<Trainer> UpdateTrainerAsync(int trainerId, Trainer trainer)
        {
            throw new NotImplementedException();
        }
    }
}
