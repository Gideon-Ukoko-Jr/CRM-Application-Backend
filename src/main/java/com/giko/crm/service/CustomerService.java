package com.giko.crm.service;

import com.giko.crm.exception.UserNotFoundException;
import com.giko.crm.model.Customer;
import com.giko.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        customer.setCustomerCode(UUID.randomUUID().toString());
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findCustomerById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found"));
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteCustomerById(id);
    }
}
