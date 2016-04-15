package com.impag.training.jpa;

import com.impag.training.jpa.model.LegacyAddress;
import com.impag.training.jpa.model.Name;
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
public class IdGeneratorTest {

    @Autowired
    private ApplicationService applicationService;

    @Test
    @Transactional
    @Rollback(false)
    public void shouldStoreManyEmployees(){
        System.out.println("Method start -----------------------------");
        for(int i = 0; i < 200; ++i){
            Name name = Name.builder().first("Łukasz").middle("Łukasz").last("Maciek").build();
		    LegacyAddress address = LegacyAddress.builder().city("Warszawa").country("PL").zip("123").street("Dluga").build();
		    applicationService.createEmployee(name, null);
        }
        System.out.println("Method end -----------------------------");
    }
}
