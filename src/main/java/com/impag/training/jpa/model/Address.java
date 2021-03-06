package com.impag.training.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;

    private String city;

    private String zip;

    private String country;

    @OneToOne(mappedBy = "address")
    @Basic(optional = false)
    private Employee employee;
}
