package com.marcin.vet.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.marcin.vet.jsonviews.Views;
import com.marcin.vet.models.Appointment;
import com.marcin.vet.models.DTO.AppointmentDTO;
import com.marcin.vet.services.AppointmentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping
    @JsonView(Views.Public.class)
    public Appointment save(@Valid @NotNull @RequestBody AppointmentDTO appointmentDTO,
                            @RequestHeader(name = "customer-pin") String pin){
        return appointmentService.save(appointmentDTO, pin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id,
                       @RequestParam("customer_id") String customer_id,
                       @RequestHeader(name = "customer-pin") String pin){
        appointmentService.delete(id, customer_id, pin);
    }


}
