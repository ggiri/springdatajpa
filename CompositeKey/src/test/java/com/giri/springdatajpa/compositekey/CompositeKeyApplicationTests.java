package com.giri.springdatajpa.compositekey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdatajpa.compositekey.entities.Customer;
import com.giri.springdatajpa.compositekey.entities.CustomerId;
import com.giri.springdatajpa.compositekey.repo.CustomerRepo;

@SpringBootTest
class CompositeKeyApplicationTests {

	@Autowired
	CustomerRepo repo;
	
	
	@Test
	void testSaveCustomer() {
		Customer customer = new Customer();
		CustomerId id = new CustomerId();
		id.setId(1234);
		id.setEmail("xyz@abc.com");
		customer.setId(id);
		customer.setName("Paul");
		repo.save(customer);
	}

}
