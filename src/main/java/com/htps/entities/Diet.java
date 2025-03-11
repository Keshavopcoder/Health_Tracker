package com.htps.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "diet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Diet {

//    @Id
//    @Column(name = "dietId", nullable = false, unique = true)
//    private Long dietId;
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generation strategy (adjust if needed)
	    @Column(name = "diet_id")  // ensure this matches the column name in your DB
	    private Long dietId;
    @Column(name = "meal", length = 100, nullable = false)
    private String meal;

    @Column(name = "created", nullable = false)
    private LocalDate created;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "calories", nullable = false)
    private Double calories;

    @Column(name = "updatedOn", nullable = true)
    private LocalDate updatedOn;
}

