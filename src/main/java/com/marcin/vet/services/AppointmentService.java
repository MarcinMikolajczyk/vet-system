package com.marcin.vet.services;

import com.marcin.vet.exeptions.InvalidOperationException;
import com.marcin.vet.exeptions.JPAObjectNotFoundException;
import com.marcin.vet.models.Appointment;
import com.marcin.vet.models.Customer;
import com.marcin.vet.models.DTO.AppointmentDTO;
import com.marcin.vet.models.Doctor;
import com.marcin.vet.repositories.AppointmentRepository;
import com.marcin.vet.repositories.CustomerRepository;
import com.marcin.vet.repositories.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.BiPredicate;


@Service
@Transactional
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final CustomerRepository customerRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              CustomerRepository customerRepository){
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
        this.doctorRepository = doctorRepository;
    }

    public Appointment save(AppointmentDTO appointmentDTO, String pin){

        if(!customerRepository.existsByPinAndId(pin, appointmentDTO.getCustomer_id())) throw new InvalidOperationException("Wrong pin or id");
        if(appointmentDTO.getStart_visit().getTime() >= appointmentDTO.getEnd_visit().getTime()) {
            throw new InvalidOperationException("Bad dates. start_visit is greater than end_visit");
        }

        Appointment appointment = convertAppointmentDTO(appointmentDTO);
        if(appointment.getDoctor().getAppointments().stream()
                .noneMatch(doctorAppointment ->  checkFreeTerm.test(appointment, doctorAppointment))){
           return appointmentRepository.save(appointment);
        } else throw new InvalidOperationException("The selected visit date is currently taken");

    }

    public void delete(Long id, String customer_id, String pin){
        if(!customerRepository.existsByPinAndId(pin, customer_id)) throw new InvalidOperationException("Wrong pin or id");
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new JPAObjectNotFoundException("id", id.toString()));
        appointmentRepository.delete(appointment);

    }

    private Appointment convertAppointmentDTO(AppointmentDTO dto){
        Customer customer = customerRepository.findById(dto.getCustomer_id())
                .orElseThrow(() -> new JPAObjectNotFoundException("id", dto.getCustomer_id()));
        Doctor doctor = doctorRepository.findDoctorWithAppointmentsById(dto.getDoctor_id())
                .orElseThrow(() -> new JPAObjectNotFoundException("id", String.valueOf(dto.getDoctor_id())));

        return Appointment
                .builder()
                .customer(customer)
                .doctor(doctor)
                .end_visit(dto.getEnd_visit())
                .start_visit(dto.getStart_visit())
                .build();
    }

    private BiPredicate<Appointment, Appointment> checkFreeTerm = (s1, s2) ->
            (s1.getStart_visit().getTime() <= s2.getEnd_visit().getTime()) && (s2.getStart_visit().getTime() <= s1.getEnd_visit().getTime());


}
