package com.marcin.vet.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.marcin.vet.jsonviews.Views;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.TimeZoneType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
@Getter @Setter
@NoArgsConstructor
public class Appointment extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_VISIT")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "CET")
    @JsonView(Views.Public.class)
    private Date start_visit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_VISIT")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "CET")
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
