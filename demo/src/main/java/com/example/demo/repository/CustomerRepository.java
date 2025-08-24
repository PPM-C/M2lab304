package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List <Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
