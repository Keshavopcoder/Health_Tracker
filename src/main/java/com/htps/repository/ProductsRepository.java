package com.htps.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.htps.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
