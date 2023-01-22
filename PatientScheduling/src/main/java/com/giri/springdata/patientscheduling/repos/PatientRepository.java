package com.giri.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.patientscheduling.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
