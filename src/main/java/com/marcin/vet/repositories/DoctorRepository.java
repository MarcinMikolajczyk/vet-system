package com.marcin.vet.repositories;

import com.marcin.vet.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query(value = "select d from Doctor d left join fetch d.appointments")
    List<Doctor> findAllWithAppointment();

    @Query(value = "select d from Doctor d left join fetch d.appointments where d.id = :id")
    Optional<Doctor> findDoctorWithAppointmentsById(@Param("id") Long id);
}
