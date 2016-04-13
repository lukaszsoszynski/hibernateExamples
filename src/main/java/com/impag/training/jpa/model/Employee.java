package com.impag.training.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] photo;

    @Temporal(TemporalType.DATE)
    private Date employmentStartDate;

    @Temporal(TemporalType.DATE)
    private Date employmentEndDate;

    private BigDecimal salary;
}
