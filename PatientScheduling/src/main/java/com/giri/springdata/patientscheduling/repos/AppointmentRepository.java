package com.giri.springdata.patientscheduling.repos;

import com.giri.springdata.patientscheduling.entities.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
