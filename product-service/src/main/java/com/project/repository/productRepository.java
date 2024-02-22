package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Integer> {

}
