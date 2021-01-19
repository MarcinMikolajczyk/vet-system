package com.marcin.vet.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.marcin.vet.jsonviews.Views;
import com.marcin.vet.models.Customer;
import com.marcin.vet.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    @JsonView(Views.Customer.class)
    public Customer getCustomer(@PathVariable String id){
        return customerService.getCustomerWithAllAppointment(id);
    }
}
