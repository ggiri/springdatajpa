package com.giri.springdata.hibernateinheritance.repos;

import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.hibernateinheritance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
