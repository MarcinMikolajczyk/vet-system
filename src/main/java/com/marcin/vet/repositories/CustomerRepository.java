package com.marcin.vet.repositories;

import com.marcin.vet.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    boolean existsByPinAndId(String pin, String id);
    Optional<Customer> findById(String id);

    @Query("select c from Customer c left join fetch c.appointments where c.id = :id")
    Optional<Customer> findByIdWithAppointments(@Param("id") String id);
}
