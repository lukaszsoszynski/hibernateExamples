package com.impag.training.jpa.serivce;

import com.impag.training.jpa.model.LegacyAddress;
import com.impag.training.jpa.model.Employee;
import com.impag.training.jpa.model.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class CompoundEmployeeService {

    private final ApplicationService applicationService;

    private final EntityManager entityManager;

    @Autowired
    public CompoundEmployeeService(ApplicationService applicationService, EntityManager entityManager) {
        this.applicationService = applicationService;
        this.entityManager = entityManager;
    }

    @Transactional
    public void loadAndSaveEmployee(){
        Name name = Name.builder().first("Łukasz").middle("Łukasz").last("Maciek").build();
        LegacyAddress address = LegacyAddress.builder().city("Warszawa").country("PL").zip("123").street("Dluga").build();
        Employee employee = applicationService.createEmployee(name, null);
//        entityManager.flush();
        System.out.println("Employ saved: " + employee);
        Employee loadedEmployee = applicationService.findEmployee(employee.getId());
        System.out.println("Employee loaded: " + loadedEmployee);
    }
}
