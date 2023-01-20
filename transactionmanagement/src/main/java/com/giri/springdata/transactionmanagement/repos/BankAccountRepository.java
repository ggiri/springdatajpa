package com.giri.springdata.transactionmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
