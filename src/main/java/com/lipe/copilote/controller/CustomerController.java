package com.lipe.copilote.controller;

import com.lipe.copilote.model.Customer;
import com.lipe.copilote.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers")
    public String addCustomer(Customer customer) {
        customerService.addCustomer(customer);
        return "Customer added successfuly";
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfuly";
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(Long id) {
        return customerService.getCustomerById(id);
    }

}
