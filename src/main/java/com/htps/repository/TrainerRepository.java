package com.htps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htps.entities.Trainer;
import com.htps.entities.User;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
//	  List<User> findByTrainerTrainerId(Long trainerId);

}
