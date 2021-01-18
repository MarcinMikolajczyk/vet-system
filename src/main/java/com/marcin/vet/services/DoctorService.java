package com.marcin.vet.services;

import com.marcin.vet.models.Doctor;
import com.marcin.vet.repositories.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Doctor findDoctorWithAppointmentsById(Long id){
        Optional<Doctor> doctor = doctorRepository.findDoctorWithAppointmentsById(id);
        return doctor.orElse(null);
    }

    public List<Doctor> findAllWithAppointment(){
        List<Doctor> doctors = doctorRepository.findAllWithAppointment();
        return !doctors.isEmpty() ? doctors : null;
    }

}
