package com.imechemi.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("loans")
public class Loan {
    private String id;
    private String studentId;
    private String amount;
}
