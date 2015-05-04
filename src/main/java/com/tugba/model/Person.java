package com.tugba.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by tugba on 01.05.2015.
 */
@Document
public class Person {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phone;

    public Person(){}

    public Person(String id, String firstName, String lastName, String phone){

        super();
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
