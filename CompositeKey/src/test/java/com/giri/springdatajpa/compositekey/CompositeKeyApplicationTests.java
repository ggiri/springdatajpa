package com.giri.springdatajpa.compositekey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdatajpa.compositekey.entities.Customer;
import com.giri.springdatajpa.compositekey.repo.CustomerRepo;

@SpringBootTest
class CompositeKeyApplicationTests {

	@Autowired
	CustomerRepo repo;
	
	
	@Test
	void testSaveCustomer() {
		Customer customer = new Customer();
		customer.setId(123);
		customer.setEmail("abc@xyz.com");
		customer.setName("John");
		repo.save(customer);
	}

}
