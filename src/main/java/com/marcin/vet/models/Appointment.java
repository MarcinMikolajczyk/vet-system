package com.marcin.vet.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.marcin.vet.jsonviews.Views;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
@Getter @Setter
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonView(Views.Public.class)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_VISIT")
    @JsonView(Views.Public.class)
    private Date start_visit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STOP_VISIT")
    @JsonView(Views.Public.class)
    private Date end_visit;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    @JsonView(Views.Internal.class)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonView(Views.Internal.class)
    private Customer customer;
}
