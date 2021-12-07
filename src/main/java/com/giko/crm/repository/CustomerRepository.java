package com.giko.crm.repository;

import com.giko.crm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long id);
    void deleteCustomerById(Long id);
}
