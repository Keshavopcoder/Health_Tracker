package com.htps.controller;
import com.htps.dto.HealthStatsDTO;
import com.htps.service.HealthStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private HealthStatsService healthStatsService;

    @GetMapping("/{userId}")
    public HealthStatsDTO getStats(@PathVariable Long userId) {
        return healthStatsService.getStatsByUserId(userId);
    }

    @PostMapping("/{userId}")
    public void updateHealthStats(@PathVariable Long userId, @RequestBody HealthStatsDTO healthStatsDTO) {
        healthStatsService.updateHealthStats(userId, healthStatsDTO);
    }
}

