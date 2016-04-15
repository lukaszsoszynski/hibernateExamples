package com.impag.training.jpa.serivce;

import com.impag.training.jpa.model.Address;
import com.impag.training.jpa.model.Employee;
import com.impag.training.jpa.model.Name;
import com.impag.training.jpa.model.Project;
import com.impag.training.jpa.repository.AddressRepository;
import com.impag.training.jpa.repository.EmployeeRepository;
import com.impag.training.jpa.repository.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationService {

    @NonNull
    private final EmployeeRepository employeeRepository;

    @NonNull
    private final AddressRepository addressRepository;

    @NonNull
    private final ProjectRepository projectRepository;

    @Transactional
    public Employee createEmployee(Name name, Address address) {
        Employee employee = Employee.builder().name(name).salary(BigDecimal.ZERO).employmentStartDate(new Date()).build();
        employee.assignAddress(address);
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public Employee findEmployee(Long id) {
        return employeeRepository.findOne(id);
    }

    @Transactional
    public Project assignEmployeeToProject(Employee employee, Project project){
        project.assignRegularEmployee(employee);
        return project;
    }

    @Transactional
    public void payRaise(Employee employee) {
        BigDecimal salary = employee.getSalary();
        if (salary == null) {
            salary = BigDecimal.ZERO;
        }
        employee.setSalary(salary.add(BigDecimal.ONE));
    }

    @Transactional
    public void defineProjectLeader(long projectId) {
        Employee employee = Employee.builder().name(Name.builder().first("Firs").last("MyName").build()).build();
        Project project = projectRepository.findOne(projectId);
        project.assignLeaderEmployee(employee);
//        projectRepository.save(project);//??
    }

    @Transactional
    public void fireEmployee(Long employId){
        Employee employee = employeeRepository.findOne(employId);
        employee.removeFromAllProjects();
//        employeeRepository.save(employee);
        //??
        employeeRepository.delete(employee);
    }

    public void setSemantic(){

        Employee employee = Employee.builder().name(Name.builder().first("Firs").last("MyName").build()).build();
    }
}
