package com.imechemi.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("students")
@Getter
public class Student {
    @Id
    private String id;

    private String name;

    public Student(String name) {
        this.name = name;
    }
}
