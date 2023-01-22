package com.giri.springdata.patientscheduling;

import com.giri.springdata.patientscheduling.entities.Appointment;
import com.giri.springdata.patientscheduling.entities.Insurance;
import com.giri.springdata.patientscheduling.entities.Patient;
import com.giri.springdata.patientscheduling.repos.AppointmentRepository;
import com.giri.springdata.patientscheduling.repos.PatientRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdata.patientscheduling.entities.Doctor;
import com.giri.springdata.patientscheduling.repos.DoctorRepository;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PatientSchedulingApplicationTests {

	@Autowired
	DoctorRepository docRepo;

	@Autowired
	PatientRepository patientRepo;
	@Autowired
	private AppointmentRepository appointmentRepo;

	@Test
	void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("John");
		doctor.setLastName("Paul");
		doctor.setSpeciality("General Physician");
		docRepo.save(doctor);
	}

	@Test
	void testCreatePatient(){

		Patient patient = new Patient();
		patient.setFirstName("Peter");
		patient.setLastName("Pan");
		patient.setPhone("12345689");
		Insurance insurance= new Insurance();
		insurance.setProviderName("Star Health");
		patient.setInsurance(insurance);
		Doctor doctor = docRepo.findById(1L).get();
		List<Doctor> doctors = Arrays.asList(doctor);
		patient.setDoctors(doctors);
		patientRepo.save(patient);
	}

	@Test
	void testUpdatePatient(){
		Patient patient = patientRepo.findById(1L).get();
		patient.getInsurance().setCopay(20d);
		patientRepo.save(patient);
	}
	
	@Test
	void testCreateAppointment(){
		Appointment appointment = new Appointment();
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);
		appointment.setReason("I am feeling unwell");
		appointment.setStarted(true);
		appointment.setPatient(patientRepo.findById(1L).get());
		appointment.setDoctor(docRepo.findById(1L).get());
		appointmentRepo.save(appointment);
	}

}
