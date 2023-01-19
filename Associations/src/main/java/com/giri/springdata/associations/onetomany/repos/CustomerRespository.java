package com.giri.springdata.associations.onetomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.associations.onetomany.entities.Customer;

public interface CustomerRespository extends CrudRepository<Customer, Long> {

}
