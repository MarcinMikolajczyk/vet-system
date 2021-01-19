package com.marcin.vet.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.marcin.vet.jsonviews.Views;
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
    @JsonView({Views.Public.class})
    @JsonProperty("customer_id")
    private String id;

    @Size(min = 4, max = 4)
    @Column(name = "PIN", length = 4, nullable = false)
    @JsonView(Views.Internal.class)
    private String pin;

    @Column(name = "FIRST_NAME", length = 16, nullable = false, updatable = false)
    @JsonView(Views.Public.class)
    private String firstName;

    @Column(name = "LAST_NAME", length = 16, nullable = false, updatable = false)
    @JsonView(Views.Public.class)
    private String lastName;

    @OneToMany(mappedBy = "customer")
    @JsonView(Views.Customer.class)
    private Set<Appointment> appointments = new HashSet<>();
}
