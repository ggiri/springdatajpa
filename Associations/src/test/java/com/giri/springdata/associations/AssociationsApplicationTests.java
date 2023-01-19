package com.giri.springdata.associations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdata.associations.onetomany.entities.Customer;
import com.giri.springdata.associations.onetomany.entities.PhoneNumber;
import com.giri.springdata.associations.onetomany.repos.CustomerRespository;

@SpringBootTest
class AssociationsApplicationTests {

    @Autowired
    CustomerRespository repository;


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
            System.out.println(phoneNumber.getNumber()+" "+phoneNumber.getType());
        }
	}

    @Test
    void testUpdateCustomer() {
        Customer customer = repository.findById(7L).get();
        customer.setName("Paul John");
        Set<PhoneNumber> phoneNumbers = customer.getPhoneNumbers();
        phoneNumbers.forEach(p->p.setType("cell"));
        repository.save(customer);
    }

    @Test
    void testDeleteCustomer() {
        repository.deleteById(8L);
    }

}
