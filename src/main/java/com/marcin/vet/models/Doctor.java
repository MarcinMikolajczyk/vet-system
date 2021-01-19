package com.marcin.vet.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.marcin.vet.jsonviews.Views;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DOCTOR")
@Getter @Setter
@NoArgsConstructor
public class Doctor extends BaseEntity{

    @Column(name = "FIRST_NAME", length = 16, nullable = false)
    @JsonView(Views.Public.class)
    private String firstName;

    @Column(name = "LAST_NAME", length = 16, nullable = false)
    @JsonView(Views.Public.class)
    private String lastName;

    @OneToMany(mappedBy = "doctor")
    @JsonView(Views.Doctor.class)
    private Set<Appointment> appointments = new HashSet<>();
}
