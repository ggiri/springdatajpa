package com.giri.springdata.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdata.transactionmanagement.services.BankAccountService;

@SpringBootTest
class TransactionmanagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	@Test
	void testTransfer() {
		service.transfer(500);
		System.out.println("test inside");
	}

}
