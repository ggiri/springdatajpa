package com.giri.springdata.product;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdata.product.entities.Product;
import com.giri.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductdataApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreate() {
        Product product = new Product();
        product.setId(1);
        product.setName("Pixel7");
        product.setDesc("Great camera");
        product.setPrice(60000.00);

        repository.save(product);

    }

    @Test
    void testRead() {
        Optional<Product> product = repository.findById(1);
        Assertions.assertNotNull(product);
        Assertions.assertEquals(1, product.get().getId());
        Assertions.assertEquals("Pixel7", product.get().getName());
        Assertions.assertEquals(60000.00, product.get().getPrice());

    }

    @Test
    void testUpdate() {
        Product product = repository.findById(1).get();
        product.setDesc("Best pixel till date");
        repository.save(product);

    }

    @Test
    void testDelete() {
        if (repository.existsById(1)) {
            repository.deleteById(1);
        }

    }

    @Test
    void testCount() {
        System.out.println("Count of products: " + repository.count());
    }

}
