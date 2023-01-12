package com.giri.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdata.idgenerators.entities.Employee;
import com.giri.springdata.idgenerators.repos.EmployeeRepository;

@SpringBootTest
class IdGeneratorsApplicationTests {
	
	@Autowired
	EmployeeRepository employeeRepo;

	@Test
	void testEmployeeCreate() {
		Employee employee = new Employee();
		employee.setName("Giri");
		
		employeeRepo.saveAndFlush(employee);
	}

}
