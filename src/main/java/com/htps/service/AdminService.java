package com.htps.service;

import java.util.List;

import com.htps.entities.Diet;
import com.htps.entities.Exercise;
import com.htps.entities.Payment;
import com.htps.entities.Products;
import com.htps.entities.Trainer;
import com.htps.entities.User;

public interface AdminService {
    
    // User Management
    List<User> getAllUsers();
    User getUserById(Long userId);
//    void addUser(User user);
//    void updateUser(User user);
    void deleteUser(Long userId);
    
    // Trainer Management
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(Long trainerId);
    void addTrainer(Trainer trainer);
    void updateTrainer(Trainer trainer);
    void deleteTrainer(Long trainerId);
    
    // Diet Management
    List<Diet> getAllDiets();
    Diet getDietById(Long dietId);
    void addDiet(Diet diet);
    void updateDiet(Diet diet);
    void deleteDiet(Long dietId);
    
    // Exercise Management
    List<Exercise> getAllExercises();
    Exercise getExerciseById(Long exerciseId);
    void addExercise(Exercise exercise);
    void updateExercise(Exercise exercise);
    void deleteExercise(Long exerciseId);
    
    // Product Management
    List<Products> getAllProducts();
    Products getProductById(Long productId);
    void addProduct(Products product);
    void updateProduct(Products product);
    void deleteProduct(Long productId);
    
    // Payment Management
    List<Payment> getAllPayments();
    Payment getPaymentById(Long paymentId);
    void processPayment(Payment payment);
}
