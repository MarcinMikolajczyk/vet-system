package com.marcin.vet.services;

import com.marcin.vet.exeptions.JPAObjectNotFoundException;
import com.marcin.vet.jsonviews.Views;
import com.marcin.vet.models.Appointment;
import com.marcin.vet.models.Doctor;
import com.marcin.vet.repositories.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @Transactional(readOnly = true)
    public Doctor findDoctorWithAppointmentsById(Long id){
        Optional<Doctor> doctor = doctorRepository.findDoctorWithAppointmentsById(id);
        return doctor.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Appointment> getAllAppointmentsByDay(Long id, Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String _date = dateFormat.format(date);

        Doctor doctor = doctorRepository.findDoctorWithAppointmentsById(id)
                .orElseThrow(() -> new JPAObjectNotFoundException("id", String.valueOf(id)));
        List<Appointment> appointments = doctor.getAppointments().stream().filter(appointment ->
            dateFormat.format(appointment.getStart_visit()).equals(_date)
        ).collect(Collectors.toList());

        return appointments;
    }

    @Transactional(readOnly = true)
    public Set<Doctor> findAllWithAppointment(){
        Set<Doctor> doctors = doctorRepository.findAllWithAppointment();
        return doctors;
    }

}
