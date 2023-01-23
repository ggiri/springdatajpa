package com.giri.mongodb;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
