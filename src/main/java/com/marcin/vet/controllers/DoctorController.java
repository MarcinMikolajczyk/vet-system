package com.marcin.vet.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.marcin.vet.jsonviews.Views;
import com.marcin.vet.models.Doctor;
import com.marcin.vet.services.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }


    @GetMapping
    @JsonView(Views.Public.class)
    public List<Doctor> getAllWithAppointment(){
        return doctorService.findAllWithAppointment();
    }

}
