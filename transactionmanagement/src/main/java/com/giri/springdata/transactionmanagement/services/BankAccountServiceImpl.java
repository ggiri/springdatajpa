package com.giri.springdata.transactionmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.springdata.transactionmanagement.entities.BankAccount;
import com.giri.springdata.transactionmanagement.repos.BankAccountRepository;

import jakarta.transaction.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankRepo;
	
	@Override
	@Transactional
	public void transfer(int amount) {
		// TODO Auto-generated method stub
		BankAccount account1 = bankRepo.findById(1).get();
		account1.setBal(account1.getBal()-500);
		bankRepo.save(account1);
		
		if(true) {
			throw new RuntimeException();
		}
		
		BankAccount account2 = bankRepo.findById(2).get();
		account2.setBal(account2.getBal()+500);
		bankRepo.save(account2);

	}

}
