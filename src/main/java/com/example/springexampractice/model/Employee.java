package com.example.springexampractice.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Employee {
    @Id
    @Column(name = "employeeNumber")
    private Long id;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "reportsTo")
    @JsonIgnoreProperties("manager")
    private Employee manager;

    @Column(name = "officeCode")
    private String officeCode;

    @Column(name = "jobTitle")
    private String jobTitle;
}
