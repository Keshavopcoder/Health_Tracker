//
//package com.htps.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.htps.entities.Diet;
//import com.htps.entities.Exercise;
//import com.htps.entities.User;
//import com.htps.service.TrainerService;
//
//@CrossOrigin(origins = "*") // Allow frontend domain
//@RestController
//@RequestMapping("/trainer")
//public class TrainerController {
//
//    @Autowired
//    private TrainerService trainerService;
//
//    // Existing endpoints...
//    @GetMapping("/{trainerId}/users")
//    public List<User> getUsersAssignedToTrainer(@PathVariable Long trainerId) {
//        return trainerService.getUsersAssignedToTrainer(trainerId);
//    }
//
//    @PostMapping("/diet")
//    public Diet createDiet(@RequestBody Diet diet) {
//        return trainerService.createDiet(diet);
//    }
//
//    @PutMapping("/diet/{dietId}")
//    public Diet updateDiet(@PathVariable Long dietId, @RequestBody Diet diet) {
//        return trainerService.updateDiet(dietId, diet);
//    }
//
//    @DeleteMapping("/diet/{dietId}")
//    public void deleteDiet(@PathVariable Long dietId) {
//        trainerService.deleteDiet(dietId);
//    }
//
//    @GetMapping("/diet/{dietId}")
//    public Diet getDietById(@PathVariable Long dietId) {
//        return trainerService.getDietById(dietId);
//    }
//
//    @PostMapping("/exercise")
//    public Exercise createExercise(@RequestBody Exercise exercise) {
//        return trainerService.createExercise(exercise);
//    }
//
//    @PutMapping("/exercise/{exerciseId}")
//    public Exercise updateExercise(@PathVariable Long exerciseId, @RequestBody Exercise exercise) {
//        return trainerService.updateExercise(exerciseId, exercise);
//    }
//
//    @DeleteMapping("/exercise/{exerciseId}")
//    public void deleteExercise(@PathVariable Long exerciseId) {
//        trainerService.deleteExercise(exerciseId);
//    }
//
//    @GetMapping("/exercise/{exerciseId}")
//    public Exercise getExerciseById(@PathVariable Long exerciseId) {
//        return trainerService.getExerciseById(exerciseId);
//    }
//
//    // NEW Endpoints:
//
//    // Get all diets added by the trainer (via the users that belong to that trainer)
//    @GetMapping("/{trainerId}/diets")
//    public List<Diet> getDietsByTrainerId(@PathVariable Long trainerId) {
//        return trainerService.getDietsByTrainerId(trainerId);
//    }
//
//    // Get all exercises added by the trainer (directly stored in Exercise.trainerId)
//    @GetMapping("/{trainerId}/exercises")
//    public List<Exercise> getExercisesByTrainerId(@PathVariable Long trainerId) {
//        return trainerService.getExercisesByTrainerId(trainerId);
//    }
//}
//



package com.htps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htps.entities.Diet;
import com.htps.entities.Exercise;
import com.htps.entities.User;
import com.htps.service.TrainerService;

@CrossOrigin(origins = "http://localhost:5173") // For development; use explicit origin when credentials are enabled
@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    // Fetch users assigned to a trainer
    @GetMapping("/{trainerId}/users")
    public List<User> getUsersAssignedToTrainer(@PathVariable Long trainerId) {
        return trainerService.getUsersAssignedToTrainer(trainerId);
    }

    // Create a new diet record
    @PostMapping("/diet")
    public Diet createDiet(@RequestBody Diet diet) {
        return trainerService.createDiet(diet);
    }

    // Update an existing diet record
    @PutMapping("/diet/{dietId}")
    public Diet updateDiet(@PathVariable Long dietId, @RequestBody Diet diet) {
        return trainerService.updateDiet(dietId, diet);
    }

    // Delete a diet record
    @DeleteMapping("/diet/{dietId}")
    public void deleteDiet(@PathVariable Long dietId) {
        trainerService.deleteDiet(dietId);
    }

    // Get a diet record by its ID
    @GetMapping("/diet/{dietId}")
    public Diet getDietById(@PathVariable Long dietId) {
        return trainerService.getDietById(dietId);
    }

    // Create a new exercise record
    @PostMapping("/exercise")
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return trainerService.createExercise(exercise);
    }

    // Update an existing exercise record
    @PutMapping("/exercise/{exerciseId}")
    public Exercise updateExercise(@PathVariable Long exerciseId, @RequestBody Exercise exercise) {
        return trainerService.updateExercise(exerciseId, exercise);
    }

    // Delete an exercise record
    @DeleteMapping("/exercise/{exerciseId}")
    public void deleteExercise(@PathVariable Long exerciseId) {
        trainerService.deleteExercise(exerciseId);
    }

    // Get an exercise record by its ID
    @GetMapping("/exercise/{exerciseId}")
    public Exercise getExerciseById(@PathVariable Long exerciseId) {
        return trainerService.getExerciseById(exerciseId);
    }
    @GetMapping("/allexercises")
    public List<Exercise> getAllExercises() {
        return trainerService.getAllExercises();
    }

    // Get all diets for a trainer (e.g., via relationships from users or direct assignment)
    @GetMapping("/{trainerId}/diets")
    public List<Diet> getDietsByTrainerId(@PathVariable Long trainerId) {
        return trainerService.getDietsByTrainerId(trainerId);
    }

    // Get all exercises associated with a trainer (directly stored by trainerId)
    @GetMapping("/{trainerId}/exercises")
    public List<Exercise> getExercisesByTrainerId(@PathVariable Long trainerId) {
        return trainerService.getExercisesByTrainerId(trainerId);
    }
}
