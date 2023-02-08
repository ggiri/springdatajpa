package com.giri.springdatajpa.multipleds.product.repos;

import com.giri.springdatajpa.multipleds.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
