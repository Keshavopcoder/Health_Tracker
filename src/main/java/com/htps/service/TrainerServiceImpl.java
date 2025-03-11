//package com.htps.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.htps.entities.Diet;
//import com.htps.entities.Exercise;
//import com.htps.entities.User;
//import com.htps.repository.DietRepository;
//import com.htps.repository.TrainerRepository;
//
//@Service
//public class TrainerServiceImpl implements TrainerService {
//
//    @Autowired
//    private TrainerRepository trainerRepository;
//
//    @Autowired
//    private DietRepository dietRepository;
//
//    @Autowired
//    private ExerciseRepository exerciseRepository;
//
//    @Override
//    public List<User> getUsersAssignedToTrainer(Long trainerId) {
//        return trainerRepository.findUsersByTrainerId(trainerId);
//    }
//
//    // CRUD for Diet
//    @Override
//    public Diet createDiet(Diet diet) {
//        return dietRepository.save(diet);
//    }
//
//    @Override
//    public Diet updateDiet(Long dietId, Diet diet) {
//        Optional<Diet> existingDiet = dietRepository.findById(dietId);
//        if (existingDiet.isPresent()) {
//            Diet updatedDiet = existingDiet.get();
//            updatedDiet.setMeal(diet.getMeal());
//            updatedDiet.setCalories(diet.getCalories());
//            updatedDiet.setUpdatedOn(diet.getUpdatedOn());
//            return dietRepository.save(updatedDiet);
//        }
//        return null; // Handle exception properly in real projects
//    }
//
//    @Override
//    public void deleteDiet(Long dietId) {
//        dietRepository.deleteById(dietId);
//    }
//
//    @Override
//    public Diet getDietById(Long dietId) {
//        return dietRepository.findById(dietId).orElse(null);
//    }
//
//    // CRUD for Exercise
//    @Override
//    public Exercise createExercise(Exercise exercise) {
//        return ExerciseRepository.save(exercise);
//    }
//
//    @Override
//    public Exercise updateExercise(Long exerciseId, Exercise exercise) {
//        Optional<Exercise> existingExercise = ExerciseRepository.findById(exerciseId);
//        if (existingExercise.isPresent()) {
//            Exercise updatedExercise = existingExercise.get();
//            updatedExercise.setExerciseName(exercise.getExerciseName());
//            updatedExercise.setDuration(exercise.getDuration());
//            updatedExercise.setCaloriesBurnt(exercise.getCaloriesBurnt());
//            return ExerciseRepository.save(updatedExercise);
//        }
//        return null; // Handle exception properly in real projects
//    }
//
//    @Override
//    public void deleteExercise(Long exerciseId) {
//        ExerciseRepository.deleteById(exerciseId);
//    }
//
//    @Override
//    public Exercise getExerciseById(Long exerciseId) {
//        return ExerciseRepository.findById(exerciseId).orElse(null);
//    }
//    
//    
//    @Override
//    public List<User> getUsersAssignedToTrainer(Long trainerId) {
//        return trainerRepository.findByTrainerTrainerId(trainerId);
//    }
//
//
//}

//
//
//package com.htps.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.htps.entities.Diet;
//import com.htps.entities.Exercise;
//import com.htps.entities.User;
//import com.htps.repository.DietRepository;
//import com.htps.repository.ExerciseRepository;
//import com.htps.repository.UserRepository;
//
//@Service
//public class TrainerServiceImpl implements TrainerService {
//
//    // Use UserRepository for fetching users by trainer
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private DietRepository dietRepository;
//
//    @Autowired
//    private ExerciseRepository exerciseRepository;
//
//    @Override
//    public List<User> getUsersAssignedToTrainer(Long trainerId) {
//        return userRepository.findByTrainerTrainerId(trainerId);
//    }
//
//    // CRUD for Diet
//    @Override
//    public Diet createDiet(Diet diet) {
//        return dietRepository.save(diet);
//    }
//
//    @Override
//    public Diet updateDiet(Long dietId, Diet diet) {
//        Optional<Diet> existingDiet = dietRepository.findById(dietId);
//        if (existingDiet.isPresent()) {
//            Diet updatedDiet = existingDiet.get();
//            updatedDiet.setMeal(diet.getMeal());
//            updatedDiet.setCalories(diet.getCalories());
//            updatedDiet.setUpdatedOn(diet.getUpdatedOn());
//            return dietRepository.save(updatedDiet);
//        }
//        return null; // Optionally throw an exception here
//    }
//
//    @Override
//    public void deleteDiet(Long dietId) {
//        dietRepository.deleteById(dietId);
//    }
//
//    @Override
//    public Diet getDietById(Long dietId) {
//        return dietRepository.findById(dietId).orElse(null);
//    }
//
//    // CRUD for Exercise
//    @Override
//    public Exercise createExercise(Exercise exercise) {
//        return exerciseRepository.save(exercise);
//    }
//
//    @Override
//    public Exercise updateExercise(Long exerciseId, Exercise exercise) {
//        Optional<Exercise> existingExercise = exerciseRepository.findById(exerciseId);
//        if (existingExercise.isPresent()) {
//            Exercise updatedExercise = existingExercise.get();
//            updatedExercise.setExerciseName(exercise.getExerciseName());
//            updatedExercise.setDuration(exercise.getDuration());
//            updatedExercise.setCaloriesBurnt(exercise.getCaloriesBurnt());
//            return exerciseRepository.save(updatedExercise);
//        }
//        return null; // Optionally throw an exception here
//    }
//
//    @Override
//    public void deleteExercise(Long exerciseId) {
//        exerciseRepository.deleteById(exerciseId);
//    }
//
//    @Override
//    public Exercise getExerciseById(Long exerciseId) {
//        return exerciseRepository.findById(exerciseId).orElse(null);
//    }
//}



package com.htps.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htps.entities.Diet;
import com.htps.entities.Exercise;
import com.htps.entities.User;
import com.htps.repository.DietRepository;
import com.htps.repository.ExerciseRepository;
import com.htps.repository.UserRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

    // For fetching users by trainer id
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<User> getUsersAssignedToTrainer(Long trainerId) {
        return userRepository.findByTrainerTrainerId(trainerId);
    }

    // CRUD for Diet
    @Override
    public Diet createDiet(Diet diet) {
        return dietRepository.save(diet);
    }

    @Override
    public Diet updateDiet(Long dietId, Diet diet) {
        Optional<Diet> existingDiet = dietRepository.findById(dietId);
        if (existingDiet.isPresent()) {
            Diet updatedDiet = existingDiet.get();
            updatedDiet.setMeal(diet.getMeal());
            updatedDiet.setCalories(diet.getCalories());
            updatedDiet.setUpdatedOn(diet.getUpdatedOn());
            return dietRepository.save(updatedDiet);
        }
        return null;
    }

    @Override
    public void deleteDiet(Long dietId) {
        dietRepository.deleteById(dietId);
    }

    @Override
    public Diet getDietById(Long dietId) {
        return dietRepository.findById(dietId).orElse(null);
    }

    // CRUD for Exercise
    @Override
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Exercise updateExercise(Long exerciseId, Exercise exercise) {
        Optional<Exercise> existingExercise = exerciseRepository.findById(exerciseId);
        if (existingExercise.isPresent()) {
            Exercise updatedExercise = existingExercise.get();
            updatedExercise.setExerciseName(exercise.getExerciseName());
            updatedExercise.setDuration(exercise.getDuration());
            updatedExercise.setCaloriesBurnt(exercise.getCaloriesBurnt());
            return exerciseRepository.save(updatedExercise);
        }
        return null;
    }

    @Override
    public void deleteExercise(Long exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }

    @Override
    public Exercise getExerciseById(Long exerciseId) {
        return exerciseRepository.findById(exerciseId).orElse(null);
    }

    // New method: Get all diets for a trainer
    @Override
    public List<Diet> getDietsByTrainerId(Long trainerId) {
        // First, get all users for the trainer.
        List<User> users = userRepository.findByTrainerTrainerId(trainerId);
        // Extract their user IDs.
        List<Long> userIds = users.stream().map(User::getUserId).collect(Collectors.toList());
        // Now, return all diets that belong to those user IDs.
        return dietRepository.findByUserIdIn(userIds);
    }

    // New method: Get all exercises for a trainer
    @Override
    public List<Exercise> getExercisesByTrainerId(Long trainerId) {
        return exerciseRepository.findByTrainerId(trainerId);
    }
    @Override
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }
}
