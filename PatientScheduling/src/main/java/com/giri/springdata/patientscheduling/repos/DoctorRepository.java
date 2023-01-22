package com.giri.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
