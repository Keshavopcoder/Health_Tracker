package com.htps.service;

import java.util.List;

import com.htps.entities.Diet;
import com.htps.entities.Exercise;
import com.htps.entities.User;

public interface TrainerService {
	 List<User> getUsersAssignedToTrainer(Long trainerId);

	    // CRUD for Diet
	    Diet createDiet(Diet diet);
	    Diet updateDiet(Long dietId, Diet diet);
	    void deleteDiet(Long dietId);
	    Diet getDietById(Long dietId);

	    // CRUD for Exercise
	    Exercise createExercise(Exercise exercise);
	    Exercise updateExercise(Long exerciseId, Exercise exercise);
	    void deleteExercise(Long exerciseId);
	    Exercise getExerciseById(Long exerciseId);
	    
	    List<Exercise> getAllExercises();
	    
	    // New endpoints to get all diets and exercises by trainer ID
	    List<Diet> getDietsByTrainerId(Long trainerId);
	    List<Exercise> getExercisesByTrainerId(Long trainerId);
}

