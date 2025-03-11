//package com.htps.service;
//
//import com.htps.dto.HealthStatsDTO;
//import com.htps.entities.HealthStats;
//import com.htps.repository.HealthStatsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class HealthStatsServiceImpl implements HealthStatsService {
//
//    @Autowired
//    private HealthStatsRepository healthStatsRepository;
//
//    @Override
//    public HealthStatsDTO getStatsByUserId(Long userId) {
//        HealthStats stats = healthStatsRepository.findByUserId(userId);
//        return new HealthStatsDTO(stats.getUserId(), stats.getWeight(), stats.getCaloriesBurned(), stats.getCaloriesConsumed());
//    }
//
//    @Override
//    public void updateHealthStats(Long userId, HealthStatsDTO healthStatsDTO) {
//        HealthStats stats = new HealthStats();
//        stats.setUserId(userId);
//        stats.setWeight(healthStatsDTO.getWeight());
//        stats.setCaloriesBurned(healthStatsDTO.getCaloriesBurned());
//        stats.setCaloriesConsumed(healthStatsDTO.getCaloriesConsumed());
//        healthStatsRepository.save(stats);
//    }
//}




package com.htps.service;

import com.htps.dto.HealthStatsDTO;
import com.htps.entities.HealthStats;
import com.htps.repository.HealthStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class HealthStatsServiceImpl implements HealthStatsService {

    @Autowired
    private HealthStatsRepository healthStatsRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;  // WebSocket messaging

    @Override
    public HealthStatsDTO getStatsByUserId(Long userId) {
        HealthStats stats = healthStatsRepository.findByUserId(userId);
        return new HealthStatsDTO(stats.getUserId(), stats.getWeight(), stats.getCaloriesBurned(), stats.getCaloriesConsumed());
    }

    @Override
    public void updateHealthStats(Long userId, HealthStatsDTO healthStatsDTO) {
        HealthStats stats = healthStatsRepository.findByUserId(userId);

        if (stats == null) {
            stats = new HealthStats();
            stats.setUserId(userId);
        }

        stats.setWeight(healthStatsDTO.getWeight());
        stats.setCaloriesBurned(healthStatsDTO.getCaloriesBurned());
        stats.setCaloriesConsumed(healthStatsDTO.getCaloriesConsumed());
        
        healthStatsRepository.save(stats);

        
        messagingTemplate.convertAndSend("/topic/healthStats/" + userId, new HealthStatsDTO(
                stats.getUserId(),
                stats.getWeight(),
                stats.getCaloriesBurned(),
                stats.getCaloriesConsumed()
        ));
    }
}
