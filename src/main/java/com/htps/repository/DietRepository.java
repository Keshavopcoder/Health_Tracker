package com.htps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htps.entities.Diet;

public interface DietRepository extends JpaRepository<Diet, Long>  {
	 List<Diet> findByUserIdIn(List<Long> userIds);
}
