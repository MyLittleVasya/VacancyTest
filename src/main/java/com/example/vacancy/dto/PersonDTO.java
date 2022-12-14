package com.example.vacancy.dto;

import java.time.LocalDate;

public class PersonDTO {
    private String firstName;

    private String lastName;

    private int age;

    public PersonDTO( String firstName, String lastName, LocalDate date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = LocalDate.now().getYear() - date.getYear();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}