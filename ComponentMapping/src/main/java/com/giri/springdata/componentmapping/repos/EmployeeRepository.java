package com.giri.springdata.componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
