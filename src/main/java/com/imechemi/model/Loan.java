package com.imechemi.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("loans")
@Getter
public class Loan {
    @Id
    private String id;

    private String studentId;

    private double amount;

    public Loan(String studentId, double amount) {
        this.studentId = studentId;
        this.amount = amount;
    }
}
