package com.htps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthStatsDTO {


	
    private Long userId;
    private double weight;
    private double caloriesBurned;
    private double caloriesConsumed;

    
}
