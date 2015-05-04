package com.tugba.service;

import com.tugba.model.Person;
import com.tugba.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by tugba on 01.05.2015.
 */
@Service
public class PersonService {

    @Qualifier("personRepository")
    @Autowired
    PersonRepository personRepository;

    public Person create(Person person) {
        person.setId(UUID.randomUUID().toString());

        return personRepository.save(person);
    }

    public Person read(Person person) {
        return person;
    }

    public List<Person> readAll() {
        return personRepository.findAll();
    }


    public Person update(Person person) {
        Person existingUser = personRepository.findAll(person.getId());

        if (existingUser == null) {
            return null;
        }

        existingUser.setFirstName(person.getFirstName());
        existingUser.setLastName(person.getLastName());
        existingUser.setPhone(person.getPhone());



        return personRepository.save(existingUser);
    }

    public Boolean delete(Person person) {
        Person existingUser = personRepository.findAll(person.getId());

        if (existingUser == null) {
            return false;
        }


        personRepository.delete(existingUser);
        return true;
    }
}
