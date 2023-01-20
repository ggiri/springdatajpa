package com.giri.springdata.transactionmanagement.services;

import org.springframework.stereotype.Service;


public interface BankAccountService {
	void transfer(int amount);
}
