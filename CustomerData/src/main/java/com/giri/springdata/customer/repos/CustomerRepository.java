package com.giri.springdata.customer.repos;

import com.giri.springdata.customer.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
