package com.impag.training.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private BigDecimal budget;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "leader_id")
    private Employee leader;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_employee")
    private List<Employee> employees;

    public void assignRegularEmployee(Employee employee) {
        if(employees == null){
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    public void assignLeaderEmployee(Employee leader){
        this.leader = leader;
        assignRegularEmployee(leader);
    }
}
