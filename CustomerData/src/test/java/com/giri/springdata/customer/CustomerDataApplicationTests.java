package com.giri.springdata.customer;

import com.giri.springdata.customer.entities.Customer;
import com.giri.springdata.customer.repos.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CustomerDataApplicationTests {

    @Autowired
    CustomerRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreate() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Giridhar Gopal");
        customer.setEmail("abc@xyz.com");

        repository.save(customer);

    }

    @Test
    void testRead() {
        Optional<Customer> customer = repository.findById(1);
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(1, customer.get().getId());
        Assertions.assertEquals("Giridhar Gopal", customer.get().getName());

    }

    @Test
    void testUpdate() {
        Customer customer = repository.findById(1).get();
        customer.setEmail("xyz@abc.com");
        repository.save(customer);

    }

    @Test
    void testDelete() {
        if (repository.existsById(1)) {
            repository.deleteById(1);
        }

    }

    @Test
    void testCount() {
        System.out.println("Count of customers: " + repository.count());
    }

}
