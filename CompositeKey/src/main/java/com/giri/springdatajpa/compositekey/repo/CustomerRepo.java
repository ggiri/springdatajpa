package com.giri.springdatajpa.compositekey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.springdatajpa.compositekey.entities.Customer;
import com.giri.springdatajpa.compositekey.entities.CustomerId;

public interface CustomerRepo extends JpaRepository<Customer, CustomerId> {

}
