package com.example.vacancy.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonDTO {
    private String firstName;

    private String lastName;

    private long age;

    public PersonDTO( String firstName, String lastName, LocalDate date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = ChronoUnit.YEARS.between(date, LocalDate.now());
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

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
