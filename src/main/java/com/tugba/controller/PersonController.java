package com.tugba.controller;

import com.tugba.dto.PersonList;
import com.tugba.model.Person;
import com.tugba.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tugba on 01.05.2015.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping
    public String getPersonsPage() {
        return "users";
    }

    @RequestMapping(value="/records")
    public @ResponseBody
    PersonList getPersons() {

        PersonList personList = new PersonList();
        personList.setPersons(personService.readAll());
        return personList;
    }

    @RequestMapping(value="/get")
        public @ResponseBody
        Person get(@RequestBody Person person) {
        return personService.read(person);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public @ResponseBody Person create(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam String id) {


        Person newPerson = new Person();
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setPhone(phone);
        newPerson.setId(id);

        return personService.create(newPerson);
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public @ResponseBody Person update(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam String id) {



        Person existingPerson = new Person();
        existingPerson.setFirstName(firstName);
        existingPerson.setLastName(lastName);
        existingPerson.setPhone(phone);
        existingPerson.setId(id);

        return personService.update(existingPerson);
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public @ResponseBody Boolean delete(
            @RequestParam String id) {

        Person existingPerson = new Person();
        existingPerson.setId(id);

        return personService.delete(existingPerson);
    }

}
