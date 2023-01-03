package com.giri.springdata.product.repos;

import com.giri.springdata.product.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
