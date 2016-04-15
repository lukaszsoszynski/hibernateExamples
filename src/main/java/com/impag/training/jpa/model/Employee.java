package com.impag.training.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(generator = "seq_employee")
//    @SequenceGenerator(name = "seq_employee", sequenceName = "seq_emp", allocationSize = 10)
    @GenericGenerator(name = "seq_employee", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_emp"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled")})
    private Long id;

    @Embedded
    private Name name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToMany(mappedBy = "employees", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Project> projects;

    @OneToMany(mappedBy = "leader")
    private List<Project> projectLeader;

    @OneToMany(mappedBy = "employee")
    private List<Phone> phones;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] photo;

    @Temporal(TemporalType.DATE)
    private Date employmentStartDate;

    @Temporal(TemporalType.DATE)
    private Date employmentEndDate;

    private BigDecimal salary;

    public void assignAddress(Address address) {
        this.address = address;
    }

    public void removeFromAllProjects(){
        if(projects != null){
            projects.clear();
        }
        if(projectLeader != null){
            projectLeader.clear();
        }
    }
}
