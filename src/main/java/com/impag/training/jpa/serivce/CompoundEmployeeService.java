package com.impag.training.jpa.serivce;

import com.impag.training.jpa.model.Address;
import com.impag.training.jpa.model.Employee;
import com.impag.training.jpa.model.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class CompoundEmployeeService {

    private final EmployeeService employeeService;

    private final EntityManager entityManager;

    @Autowired
    public CompoundEmployeeService(EmployeeService employeeService, EntityManager entityManager) {
        this.employeeService = employeeService;
        this.entityManager = entityManager;
    }

    @Transactional
    public void loadAndSaveEmployee(){
        Name name = Name.builder().first("Łukasz").middle("Łukasz").last("Maciek").build();
        Address address = Address.builder().city("Warszawa").country("PL").zip("123").street("Dluga").build();
        Employee employee = employeeService.createEmployee(name, address);
//        entityManager.flush();
        System.out.println("Employ saved: " + employee);
        Employee loadedEmployee = employeeService.findEmployee(employee.getId());
        System.out.println("Employee loaded: " + loadedEmployee);
    }
}
