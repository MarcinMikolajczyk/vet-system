package com.marcin.vet.models.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class AppointmentDTO {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone = "CET")
    private Date start_visit;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone = "CET")
    private Date end_visit;
    private Long doctor_id;
    private String customer_id;
}
