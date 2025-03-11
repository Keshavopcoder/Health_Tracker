using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebApplication1.Data;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class GoalsController : ControllerBase
    {
        private readonly AppDbContext _context;

        public GoalsController(AppDbContext context)
        {
            _context = context;
        }

        // GET: api/Goals
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Goal>>> GetGoals()
        {
            return await _context.Goals.ToListAsync();
        }

        // GET: api/Goals/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Goal>> GetGoal(long id)
        {
            var goal = await _context.Goals.FindAsync(id);

            if (goal == null)
            {
                return NotFound();
            }

            return goal;
        }

        // PUT: api/Goals/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutGoal(long id, Goal goal)
        {
            if (id != goal.GoalId)
            {
                return BadRequest();
            }

            _context.Entry(goal).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!GoalExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Goals
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Goal>> PostGoal(Goal goal)
        {
            _context.Goals.Add(goal);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetGoal", new { id = goal.GoalId }, goal);
        }

        // DELETE: api/Goals/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteGoal(long id)
        {
            var goal = await _context.Goals.FindAsync(id);
            if (goal == null)
            {
                return NotFound();
            }

            _context.Goals.Remove(goal);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool GoalExists(long id)
        {
            return _context.Goals.Any(e => e.GoalId == id);
        }
    }
}
