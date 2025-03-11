package com.htps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htps.entities.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long>{

}
