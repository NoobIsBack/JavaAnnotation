package com.mayank.annotations.processor;

import com.mayank.annotations.model.Person;

public class Main {


    public static void main(String[] args) {
        ObjectToJsonConverter objectToJsonConverter = new ObjectToJsonConverter();
        Person person = new Person("kanchan", "pal", "30");

        System.out.println(objectToJsonConverter.convertToJson(person));
    }

}
