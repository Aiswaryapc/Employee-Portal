package com.axis.finalproject.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
