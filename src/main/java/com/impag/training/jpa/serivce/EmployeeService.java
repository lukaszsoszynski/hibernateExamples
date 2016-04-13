package com.impag.training.jpa.serivce;

import com.impag.training.jpa.model.Address;
import com.impag.training.jpa.model.Employee;
import com.impag.training.jpa.model.Name;
import com.impag.training.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee createEmployee(Name name, Address address){
        Employee employee = Employee.builder().name(name).address(address).salary(BigDecimal.ZERO).employmentStartDate(new Date()).build();
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee findEmployee(Long id){
        return employeeRepository.findOne(id);
    }
}
