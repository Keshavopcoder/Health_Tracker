//package com.htps.service;
//import com.htps.dto.HealthStatsDTO;
//
//public interface HealthStatsService {
//
//    HealthStatsDTO getStatsByUserId(Long userId);
//
//    void updateHealthStats(Long userId, HealthStatsDTO healthStatsDTO);
//}


//

package com.htps.service;

import com.htps.dto.HealthStatsDTO;

public interface HealthStatsService {
    HealthStatsDTO getStatsByUserId(Long userId);
    void updateHealthStats(Long userId, HealthStatsDTO healthStatsDTO);
}
