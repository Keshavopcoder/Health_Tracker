package com.htps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htps.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
