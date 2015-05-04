package com.tugba.service;

import com.tugba.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.UUID;

/**
 * Created by tugba on 01.05.2015.
 */
public class MongoService {

    @Autowired
    MongoTemplate mongoTemplate;

    public void init() {

        // Drop existing collections
        mongoTemplate.dropCollection("persons");

        Person firstPerson = new Person();
        firstPerson.setId(UUID.randomUUID().toString());
        firstPerson.setFirstName("Tuğba");
        firstPerson.setLastName("DÜZENLİ");
        firstPerson.setPhone("538-987-65-43");


        Person secondPerson = new Person();
        secondPerson.setId(UUID.randomUUID().toString());
        secondPerson.setFirstName("Salih");
        secondPerson.setLastName("KILIÇ");
        secondPerson.setPhone("538-123-45-78");

        // Insert to db
        mongoTemplate.insert(firstPerson, "persons");
        mongoTemplate.insert(secondPerson, "persons");
    }
}
