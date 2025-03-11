package com.htps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htps.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
