package com.htps.entities;
//package com.example.gymapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "health_stats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HealthStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private double weight;
    private double caloriesBurned;
    private double caloriesConsumed;

    // Getters and Setters
}

