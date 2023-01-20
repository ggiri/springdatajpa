package com.giri.springdata.associations;

import com.giri.springdata.associations.manytomany.entities.Programmer;
import com.giri.springdata.associations.manytomany.entities.Project;
import com.giri.springdata.associations.manytomany.repos.ProgrammerRepository;
import com.giri.springdata.associations.onetomany.entities.Customer;
import com.giri.springdata.associations.onetomany.entities.PhoneNumber;
import com.giri.springdata.associations.onetomany.repos.CustomerRespository;
import com.giri.springdata.associations.onetoone.entities.License;
import com.giri.springdata.associations.onetoone.entities.Person;
import com.giri.springdata.associations.onetoone.repos.LicenseRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class AssociationsApplicationTests {

    @Autowired
    CustomerRespository repository;

    @Autowired
    ProgrammerRepository programmerRepo;

    @Autowired
    LicenseRepository licenseRepo;


    @Test
    void contextLoads() {
    }

    @Test
    void testCreateCustomer() {

        Customer customer = new Customer();
        customer.setName("Paul");
        HashSet<PhoneNumber> numbers = new HashSet<>();
        PhoneNumber ph1 = new PhoneNumber();
        ph1.setNumber("123456");
        ph1.setType("Mobile");
        PhoneNumber ph2 = new PhoneNumber();
        ph2.setNumber("0987654321");
        ph2.setType("Cell");
        customer.addPhoneNumber(ph1);
        customer.addPhoneNumber(ph2);
        repository.save(customer);

    }

    @Test
//    @Transactional --- for lazy loading
    void testLoadCustomer() {
        Customer customer = repository.findById(7L).get();
        System.out.println(customer);
        Set<PhoneNumber> phoneNumbers = customer.getPhoneNumbers();
        for (PhoneNumber phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber.getNumber() + " " + phoneNumber.getType());
        }
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = repository.findById(7L).get();
        customer.setName("Paul John");
        Set<PhoneNumber> phoneNumbers = customer.getPhoneNumbers();
        phoneNumbers.forEach(p -> p.setType("cell"));
        repository.save(customer);
    }

    @Test
    void testDeleteCustomer() {
        repository.deleteById(8L);
    }

    @Test
    void testManyToManyCreateProgrammer() {
        Programmer programmer = new Programmer();
        programmer.setName("Mark");
        programmer.setSalary(10000);
        HashSet<Project> projects = new HashSet<>();
        Project p1 = new Project();
        p1.setName("P1");
        projects.add(p1);
        programmer.setProjects(projects);
        programmerRepo.save(programmer);

    }

    @Test
//    @Transactional -- lazy loading
    void testManyToManyFindProgrammer() {
        Programmer findById = programmerRepo.findById(1).get();
        System.out.println(findById);
        System.out.println(findById.getProjects());
    }

    @Test
    void testOneToOneCreateLicense() {

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        Date nextYear = cal.getTime();

        License license = new License();
        license.setType("bike");
        license.setValid_from(today);
        license.setValid_to(nextYear);

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Paul");
        person.setAge(35);

        license.setPerson(person);

        licenseRepo.save(license);
    }

    @Test
    @Transactional
    void testCaching(){
        repository.findById(6L);
        repository.findById(6L);//query is fired only once
    }

}
