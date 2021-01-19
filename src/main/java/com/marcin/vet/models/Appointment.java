package com.marcin.vet.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.marcin.vet.jsonviews.Views;
import lombok.*;
import org.hibernate.type.TimeZoneType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
@Getter @Setter
@NoArgsConstructor
@Builder
public class Appointment extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_VISIT")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone = "CET")
    @JsonView(Views.Public.class)
    private Date start_visit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_VISIT")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone = "CET")
    @JsonView(Views.Public.class)
    private Date end_visit;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    @JsonView(value = { Views.Customer.class, Views.Internal.class })
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonView(value = { Views.Internal.class, Views.Doctor.class })
    private Customer customer;

    public Appointment(Date start_visit, Date end_visit, Doctor doctor, Customer customer){
        this.end_visit = end_visit;
        this.start_visit = start_visit;
        this.doctor = doctor;
        this.customer = customer;
    }

}
