package com.impag.training.jpa;

import com.impag.training.jpa.model.Address;
import com.impag.training.jpa.model.Employee;
import com.impag.training.jpa.model.Name;
import com.impag.training.jpa.serivce.CompoundEmployeeService;
import com.impag.training.jpa.serivce.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		Name name = Name.builder().first("Łukasz").middle("Łukasz").last("Maciek").build();
		Address address = Address.builder().city("Warszawa").country("PL").zip("123").street("Dluga").build();
		Employee employee = employeeService.createEmployee(name, address);
		System.out.println("Employ saved: " + employee);
		Employee loadedEmployee = employeeService.findEmployee(employee.getId());
		System.out.println("Employee loaded: " + loadedEmployee);

		//-----------------
		System.out.println("In one transaction");
		CompoundEmployeeService compoundEmployeeService = context.getBean(CompoundEmployeeService.class);
		compoundEmployeeService.loadAndSaveEmployee();
	}
}
