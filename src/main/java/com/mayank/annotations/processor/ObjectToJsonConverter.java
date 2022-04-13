package com.mayank.annotations.processor;

import com.mayank.annotations.Init;
import com.mayank.annotations.JsonElement;
import com.mayank.annotations.JsonSerializable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

    public String convertToJson(Object object) throws IllegalArgumentException {
        try {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


    private void checkIfSerializable(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("The object to serialize is null");
        }

        Class<?> clazz = object.getClass();

        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new IllegalArgumentException("The class "
                    + clazz.getSimpleName()
                    + " is not annotated with JsonSerializable");
        }
    }

    private void initializeObject(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            for (Annotation annotation : clazz.getAnnotations()) {
                if (annotation instanceof JsonElement) {
                    JsonElement fileInfo = (JsonElement) annotation;
                    System.out.println("Author :" + fileInfo.key());
                }
            }
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(field.getName(), (String) field.get(object));
            }
        }

        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));

//        System.out.println("mayank " + jsonString);


        return "{" + jsonString + "}";

    }
}
