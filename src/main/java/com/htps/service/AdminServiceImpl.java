package com.htps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htps.custom_exceptions.ResourceNotFoundException;
import com.htps.entities.Diet;
import com.htps.entities.Exercise;
import com.htps.entities.Payment;
import com.htps.entities.Products;
import com.htps.entities.Trainer;
import com.htps.entities.User;
import com.htps.repository.DietRepository;
import com.htps.repository.ExerciseRepository;
import com.htps.repository.PaymentRepository;
import com.htps.repository.ProductsRepository;
import com.htps.repository.TrainerRepository;
import com.htps.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private ExerciseRepository ExcerciseRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainerById(Long trainerId) {
        return trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found with ID: " + trainerId));
    }

    @Override
    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        if (!trainerRepository.existsById(trainer.getTrainerId())) {
            throw new ResourceNotFoundException("Trainer not found with ID: " + trainer.getTrainerName());
        }
        trainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        Trainer trainer = getTrainerById(trainerId);
        trainerRepository.delete(trainer);
    }

    @Override
    public List<Diet> getAllDiets() {
        return dietRepository.findAll();
    }

    @Override
    public Diet getDietById(Long dietId) {
        return dietRepository.findById(dietId)
                .orElseThrow(() -> new ResourceNotFoundException("Diet not found with ID: " + dietId));
    }

    @Override
    public void addDiet(Diet diet) {
        dietRepository.save(diet);
    }

    @Override
    public void updateDiet(Diet diet) {
        if (!dietRepository.existsById(diet.getDietId())) {
            throw new ResourceNotFoundException("Diet not found with ID: " + diet.getDietId());
        }
        dietRepository.save(diet);
    }

    @Override
    public void deleteDiet(Long dietId) {
        Diet diet = getDietById(dietId);
        dietRepository.delete(diet);
    }

    @Override
    public List<Exercise> getAllExercises() {
        return ExcerciseRepository.findAll();
    }

    @Override
    public Exercise getExerciseById(Long exerciseId) {
        return ExcerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found with ID: " + exerciseId));
    }

    @Override
    public void addExercise(Exercise exercise) {
        ExcerciseRepository.save(exercise);
    }

    @Override
    public void updateExercise(Exercise exercise) {
        if (!ExcerciseRepository.existsById(exercise.getExerciseId())) {
            throw new ResourceNotFoundException("Exercise not found with ID: " + exercise.getExerciseId());
        }
        ExcerciseRepository.save(exercise);
    }

    @Override
    public void deleteExercise(Long exerciseId) {
        Exercise exercise = getExerciseById(exerciseId);
        ExcerciseRepository.delete(exercise);
    }

//    @Override
//    public List<Products> getAllProducts() {
//        return ProductsRepository.findAll();
//    }
//
//    @Override
//    public Products getProductById(Long productId) {
//        return ProductsRepository.findById(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + productId));
//    }
//
//    @Override
//    public void addProduct(Products product) {
//        ProductsRepository.save(product);
//    }
//
//    @Override
//    public void updateProduct(Products product) {
//        if (!ProductsRepository.existsById(product.getProductId())) {
//            throw new ResourceNotFoundException("Product not found with ID: " + product.getProductId());
//        }
//        ProductsRepository.save(product);
//    }
//
//    @Override
//    public void deleteProduct(Long productId) {
//        Products product = getProductById(productId);
//        ProductsRepository.delete(product);
//    }
    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products getProductById(Long productId) {
        return productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

    @Override
    public void addProduct(Products product) {
        productsRepository.save(product);
    }

    @Override
    public void updateProduct(Products product) {
        if (!productsRepository.existsById(product.getProductId())) {
            throw new RuntimeException("Product not found with ID: " + product.getProductId());
        }
        productsRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        if (!productsRepository.existsById(productId)) {
            throw new RuntimeException("Product not found with ID: " + productId);
        }
        productsRepository.deleteById(productId);
    }


    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with ID: " + paymentId));
    }

    @Override
    public void processPayment(Payment payment) {
        paymentRepository.save(payment);
    }
}