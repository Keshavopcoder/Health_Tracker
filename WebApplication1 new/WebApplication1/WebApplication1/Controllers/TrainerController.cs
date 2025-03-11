using Microsoft.AspNetCore.Mvc;
using WebApplication1.Services.Interfaces;
using TrainerAPI.Models;

namespace WebApplication1.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TrainerController : ControllerBase
    {
        private readonly ITrainerService _trainerService;

        public TrainerController(ITrainerService trainerService)
        {
            _trainerService = trainerService;
        }

        // Get all trainers
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Trainer>>> GetAllTrainers()
        {
            try
            {
                var trainers = await _trainerService.GetAllTrainersAsync();
                if (trainers == null )
                    return NotFound("No trainers found.");

                return Ok(trainers);
            }
            catch (System.Exception ex)
            {
                // Log exception here for debugging
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // Get trainer by ID
        [HttpGet("{id}")]
        public async Task<ActionResult<Trainer>> GetTrainerById(int id)
        {
            try
            {
                var trainer = await _trainerService.GetTrainerByIdAsync(id);
                if (trainer == null)
                    return NotFound($"Trainer with ID {id} not found.");

                return Ok(trainer);
            }
            catch (System.Exception ex)
            {
                // Log exception here for debugging
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // Create a new trainer
        [HttpPost]
        public async Task<ActionResult<Trainer>> CreateTrainer(Trainer trainer)
        {
            if (trainer == null)
                return BadRequest("Trainer data is null.");

            try
            {
                var createdTrainer = await _trainerService.CreateTrainerAsync(trainer);
                return CreatedAtAction(nameof(GetTrainerById), new { id = createdTrainer.TrainerId }, createdTrainer);
            }
            catch (System.Exception ex)
            {
                // Log exception here for debugging
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // Update an existing trainer
        [HttpPut("{id}")]
        public async Task<ActionResult> UpdateTrainer(int id, Trainer trainer)
        {
            if (id != trainer.TrainerId)
                return BadRequest("Trainer ID mismatch.");

            try
            {
                var trainerToUpdate = await _trainerService.GetTrainerByIdAsync(id);
                if (trainerToUpdate == null)
                    return NotFound($"Trainer with ID {id} not found.");

                await _trainerService.UpdateTrainerAsync(trainer);
                return NoContent();
            }
            catch (System.Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // Delete a trainer
        [HttpDelete("{id}")]
        public async Task<ActionResult> DeleteTrainer(int id)
        {
            try
            {
                var result = await _trainerService.DeleteTrainerAsync(id);
                if (!result)
                    return NotFound($"Trainer with ID {id} not found.");

                return NoContent();
            }
            catch (System.Exception ex)
            {
              
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }
    }
}
