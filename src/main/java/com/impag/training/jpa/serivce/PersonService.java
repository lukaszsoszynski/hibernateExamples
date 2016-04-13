package com.impag.training.jpa.serivce;

import com.impag.training.jpa.model.Person;
import com.impag.training.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        Person person = new Person();
        person.setName("Ala ma kota");
        personRepository.save(person);
    }
}
