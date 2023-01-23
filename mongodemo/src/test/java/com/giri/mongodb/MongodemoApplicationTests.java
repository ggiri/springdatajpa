package com.giri.mongodb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.mongodb.model.Product;
import com.giri.mongodb.repos.ProductRepository;
import org.springframework.test.context.TestPropertySource;

//@SpringBootTest
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class MongodemoApplicationTests {
	
	@Autowired
	ProductRepository repository;

	@Test
	void testSave() {
		Product product = new Product();
		product.setName("Dell");
		product.setPrice(50000);
		Product savedProduct = repository.save(product);
		assertNotNull(savedProduct);
	}
	
	@Test
	void testFindAll() {
		List<Product> products = repository.findAll();
		assertEquals(1, products.size());		
	}
	
	@Test
	void testDelete() {
		repository.deleteById("63ce72db4d6fb126c9a19add");
		Optional<Product> product = repository.findById("63ce72db4d6fb126c9a19add");
		assertEquals(Optional.empty(), product);
	}
	
	@Test
	void createProductForUpdate() {
		Product product = new Product();
		product.setName("HP");
		product.setPrice(50000);
		Product savedProduct = repository.save(product);
		assertNotNull(savedProduct);
	}
	
	@Test
	void updateProduct() {
		Product product = repository.findById("63ce76a020407c16f0fa34c5").get();
		product.setPrice(60000);
		Product updatedProduct = repository.save(product);
		assertEquals(60000, updatedProduct.getPrice());	
	}

}
