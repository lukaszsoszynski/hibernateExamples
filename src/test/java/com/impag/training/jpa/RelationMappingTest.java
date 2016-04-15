package com.impag.training.jpa;

import com.impag.training.jpa.model.Address;
import com.impag.training.jpa.model.Employee;
import com.impag.training.jpa.model.Name;
import com.impag.training.jpa.model.Project;
import com.impag.training.jpa.repository.ProjectRepository;
import com.impag.training.jpa.serivce.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RelationMappingTest {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    @Rollback(false)
    public void shouldCreateEmployee(){
        Name name = Name.builder().first("aaa").last("bb").build();
        Address addres = Address.builder().city("Lodz").build();
        applicationService.createEmployee(name, addres);

    }

    @Test
    @Transactional
    @Rollback(false)
    public void assignEmployeeToProject(){
        Employee employee = applicationService.findEmployee(43601L);
        Project project = Project.builder().description("my project").name("Project").build();
//        project = projectRepository.save(project);
        applicationService.assignEmployeeToProject(employee, project);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void assignLeaderToProject(){
        applicationService.defineProjectLeader(100136L);
    }


    @Test
    @Transactional
    @Rollback(false)
    public void fireEmployee(){
        applicationService.fireEmployee(43601L);
    }
}
