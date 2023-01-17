package com.giri.springdata.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdata.componentmapping.entities.Address;
import com.giri.springdata.componentmapping.entities.Employee;
import com.giri.springdata.componentmapping.repos.EmployeeRepository;

@SpringBootTest
class ComponentMappingApplicationTests {
	
	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreate() {
		Employee emp= new Employee();
		emp.setId(123);
		emp.setName("Giridhar");
		Address address = new Address();
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setStreetaddress("Domlur");
		address.setZipcode("71");
		emp.setAddress(address);
		repository.save(emp);
	}

}
