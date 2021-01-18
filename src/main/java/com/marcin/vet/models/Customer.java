package com.marcin.vet.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
@Getter @Setter
@NoArgsConstructor
public class Customer {

    @Id
    @Size(min = 4, max = 4)
    @Column(name = "ID", length = 4, nullable = false, updatable = false)
    private String id;

    @Size(min = 4, max = 4)
    @Column(name = "PIN", length = 4, nullable = false)
    private String pin;

    @Column(name = "FIRST_NAME", length = 16, nullable = false, updatable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 16, nullable = false, updatable = false)
    private String lastName;

    @OneToMany(mappedBy = "customer")
    private Set<Appointment> appointments = new HashSet<>();
}
