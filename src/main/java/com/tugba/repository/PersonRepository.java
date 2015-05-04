package com.tugba.repository;

import com.tugba.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tugba on 01.05.2015.
 */
@Repository
public interface PersonRepository extends MongoRepository <Person, String>{

    Person findAll(String id);

}
