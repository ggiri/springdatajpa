package com.giri.springdata.associations.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.associations.manytomany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
