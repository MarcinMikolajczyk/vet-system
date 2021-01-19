package com.marcin.vet.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.marcin.vet.jsonviews.Views;
import com.marcin.vet.models.Appointment;
import com.marcin.vet.models.Doctor;
import com.marcin.vet.services.DoctorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }


    @GetMapping("/{id}")
    @JsonView(Views.Doctor.class)
    public List<Appointment> getWithAppointment(@PathVariable Long id,
                                                @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        return doctorService.getAllAppointmentsByDay(id, date);
    }


}
