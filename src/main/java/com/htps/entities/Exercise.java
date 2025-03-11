//package com.htps.entities;
//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Table(name = "exercise") // Table name in the database
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//public class Exercise {
//
//    @Id
//    @Column(name = "exerciseId", nullable = false, unique = true) // Primary Key
//    private Long exerciseId;
//
//    @Column(name = "userId", nullable = false) // Foreign key to user
//    private Long userId;
//
//    @Column(name = "exerciseName", length = 100, nullable = false) // varchar(100)
//    private String exerciseName;
//
//    @Column(name = "duration", nullable = false) // Duration as a datetime
//    private LocalDateTime duration;
//
//    @Column(name = "caloriesBurnt", nullable = false) // Float column
//    private Float caloriesBurnt;
//
//    @Column(name = "trainerId", nullable = true) // Foreign key (optional)
//    private Long trainerId;
//}


package com.htps.entities;



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
@Table(name = "exercise")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exerciseId", nullable = false, unique = true)
    private Long exerciseId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "exerciseName", length = 100, nullable = false)
    private String exerciseName;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "caloriesBurnt", nullable = false)
    private Float caloriesBurnt;

    @Column(name = "trainerId", nullable = true)
    private Long trainerId;
}

