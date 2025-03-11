package com.htps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ProgressDTO {

    private Long userId;
    private Double weight;
    private Double bodyFatPercentage;
    private String status;

    // Constructors
    public ProgressDTO(Long userId, Double weight, Double bodyFatPercentage, String status) {
        this.userId = userId;
        this.weight = weight;
        this.bodyFatPercentage = bodyFatPercentage;
        this.status = status;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(Double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}