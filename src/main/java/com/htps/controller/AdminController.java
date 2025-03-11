package com.htps.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htps.dto.ApiResponse;
import com.htps.entities.Diet;
import com.htps.entities.Exercise;
import com.htps.entities.Payment;
import com.htps.entities.Products;
import com.htps.entities.Trainer;
import com.htps.entities.User;
import com.htps.service.AdminService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/htps/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // User Endpoints
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(adminService.getUserById(userId));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        adminService.deleteUser(userId);
        return ResponseEntity.ok(new ApiResponse("User deleted successfully"));
    }

    // Trainer Endpoints
    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return ResponseEntity.ok(adminService.getAllTrainers());
    }

    @GetMapping("/trainers/{trainerId}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long trainerId) {
        return ResponseEntity.ok(adminService.getTrainerById(trainerId));
    }

    @PutMapping("/trainers")
    public ResponseEntity<ApiResponse> updateTrainer(@RequestBody Trainer trainer) {
        adminService.updateTrainer(trainer);
        return ResponseEntity.ok(new ApiResponse("Trainer updated successfully"));
    }

    @DeleteMapping("/trainers/{trainerId}")
    public ResponseEntity<ApiResponse> deleteTrainer(@PathVariable Long trainerId) {
        adminService.deleteTrainer(trainerId);
        return ResponseEntity.ok(new ApiResponse("Trainer deleted successfully"));
    }

    // Diet Endpoints
    @GetMapping("/diets")
    public ResponseEntity<List<Diet>> getAllDiets() {
        return ResponseEntity.ok(adminService.getAllDiets());
    }

    @GetMapping("/diets/{dietId}")
    public ResponseEntity<Diet> getDietById(@PathVariable Long dietId) {
        return ResponseEntity.ok(adminService.getDietById(dietId));
    }

    @PutMapping("/diets")
    public ResponseEntity<ApiResponse> updateDiet(@RequestBody Diet diet) {
        adminService.updateDiet(diet);
        return ResponseEntity.ok(new ApiResponse("Diet updated successfully"));
    }

    @DeleteMapping("/diets/{dietId}")
    public ResponseEntity<ApiResponse> deleteDiet(@PathVariable Long dietId) {
        adminService.deleteDiet(dietId);
        return ResponseEntity.ok(new ApiResponse("Diet deleted successfully"));
    }

    // Exercise Endpoints
    @GetMapping("/exercises")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(adminService.getAllExercises());
    }

    @GetMapping("/exercises/{exerciseId}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long exerciseId) {
        return ResponseEntity.ok(adminService.getExerciseById(exerciseId));
    }

    @PutMapping("/exercises")
    public ResponseEntity<ApiResponse> updateExercise(@RequestBody Exercise exercise) {
        adminService.updateExercise(exercise);
        return ResponseEntity.ok(new ApiResponse("Exercise updated successfully"));
    }

    @DeleteMapping("/exercises/{exerciseId}")
    public ResponseEntity<ApiResponse> deleteExercise(@PathVariable Long exerciseId) {
        adminService.deleteExercise(exerciseId);
        return ResponseEntity.ok(new ApiResponse("Exercise deleted successfully"));
    }

    // Payment Endpoints
    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(adminService.getAllPayments());
    }

    @GetMapping("/payments/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        return ResponseEntity.ok(adminService.getPaymentById(paymentId));
    }

    //products

 // Get all products
    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        return ResponseEntity.ok(adminService.getAllProducts());
    }

    // Get a single product by ID
    @GetMapping("/products/{productId}")
    public ResponseEntity<Products> getProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(adminService.getProductById(productId));
    }

    // Add a new product
    @PostMapping("/products")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody Products product) {
        adminService.addProduct(product);
        return ResponseEntity.ok(new ApiResponse("Product added successfully"));
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(
            @PathVariable Long productId,
            @RequestBody Products product) {

        // Set the product ID from the path variable to ensure consistency
        product.setProductId(productId);

        // Call the service to update the product
        adminService.updateProduct(product);

        return ResponseEntity.ok(new ApiResponse("Product updated successfully"));
    }


    // Delete a product by ID
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) {
        adminService.deleteProduct(productId);
        return ResponseEntity.ok(new ApiResponse("Product deleted successfully"));
    }
}
