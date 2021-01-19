package com.marcin.vet.services;

import com.marcin.vet.exeptions.JPAObjectNotFoundException;
import com.marcin.vet.models.Customer;
import com.marcin.vet.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerWithAllAppointment(String id){
        return customerRepository.findByIdWithAppointments(id)
                .orElseThrow(() -> new JPAObjectNotFoundException("id", id));
    }

}
