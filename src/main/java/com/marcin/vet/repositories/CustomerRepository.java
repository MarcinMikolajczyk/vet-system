package com.marcin.vet.repositories;

import com.marcin.vet.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByPinAndId(String pin, Long id);
}
