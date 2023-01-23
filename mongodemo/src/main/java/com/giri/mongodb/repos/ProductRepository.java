package com.giri.mongodb.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.giri.mongodb.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
