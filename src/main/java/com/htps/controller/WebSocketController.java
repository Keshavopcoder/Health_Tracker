package com.htps.controller;



import com.htps.entities.HealthStats;
import com.htps.entities.Progress;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/ws")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Simulate sending updated health stats
    @PostMapping("/update-stats")
    public void updateHealthStats(@RequestBody HealthStats stats) {
        messagingTemplate.convertAndSend("/topic/stats", stats);
    }

    // Simulate sending updated progress data
    @PostMapping("/update-progress")
    public void updateProgress(@RequestBody Progress progress) {
        messagingTemplate.convertAndSend("/topic/progress", progress);
    }
}

