package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerStatus;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest

class CustomerRepositoryTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer("John Doe", CustomerStatus.Gold, 15000);
        customerRepository.save(customer);
        assertNotNull(customer.getCustomerId());
    }



}
