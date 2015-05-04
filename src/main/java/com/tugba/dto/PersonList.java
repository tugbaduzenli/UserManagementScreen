package com.tugba.dto;

import com.tugba.model.Person;

import java.util.List;

/**
 * Created by tugba on 01.05.2015.
 */
public class PersonList {

    private List<Person> persons;

    public List<Person> getUsers() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
