package com.imechemi.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("students")
public class Student {
    private String id;
    private String name;

    public Student(String name) {
        this.name = name;
    }
}
