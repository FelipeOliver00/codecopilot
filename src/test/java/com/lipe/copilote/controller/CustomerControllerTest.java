package com.lipe.copilote.controller;

import com.lipe.copilote.model.Customer;
import com.lipe.copilote.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void testGetCustomers() {
        when(customerService.getAllCustomers()).thenReturn(List.of(new Customer(1L, "A", "ALEX", "a1@gmail.com", "123456")));
        var customers = customerController.getCustomers();
        Assertions.assertEquals(1, customers.size());
    }

    @Test
    public void testAddCustomer(){
        Customer customer = new Customer(1L, "A", "ALEX", "a1@gmail.com", "123456");
        Assertions.assertEquals("Customer added successfuly", customerController.addCustomer(customer));
    }

    @Test
    public void testDeleteCustomer(){
        var customer = customerController.deleteCustomer(1L);
        Assertions.assertEquals("Customer deleted successfuly", customer);
    }

    @Test
    public void testGetCustomerById(){
        when(customerService.getCustomerById(1L)).thenReturn(new Customer(1L, "A", "ALEX", "a1@gmail.com", "123456"));
        var customer = customerController.getCustomer(1L);
        Assertions.assertEquals("A", customer.getFirstName());
    }
}