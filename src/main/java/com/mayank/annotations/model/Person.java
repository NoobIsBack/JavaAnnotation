package com.mayank.annotations.model;

import com.mayank.annotations.Init;
import com.mayank.annotations.JsonElement;
import com.mayank.annotations.JsonSerializable;

@JsonSerializable
public class Person {
    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;
    @JsonElement(key= "personAge")
    private String age;

    private String address;

    @Init
    private void init() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase()
                + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase()
                + this.lastName.substring(1);
    }

    public Person(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
