package com.impag.training.jpa;

import com.impag.training.jpa.model.Employee;
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
public class EntityLifeCycleTest {

    @Autowired
    public ApplicationService applicationService;

    @Test
    public void readOnlyTransaction() {
        System.out.println("\nWe stert here+++++++");
        Employee employee = applicationService.findEmployee(30L);
    }

    @Test
    @Transactional(readOnly = true)
    @Rollback(false)
    public void payRaiseTest(){
        System.out.println("\nWe stert here+++++++");
        Employee employee = applicationService.findEmployee(30L);
        applicationService.payRaise(employee);
        //entityManager.flush();
    }

}
