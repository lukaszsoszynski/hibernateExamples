package com.impag.training.jpa.model;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private String number;

    private PhoneType type;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
