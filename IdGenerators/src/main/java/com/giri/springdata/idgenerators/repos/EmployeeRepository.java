package com.giri.springdata.idgenerators.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.idgenerators.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
