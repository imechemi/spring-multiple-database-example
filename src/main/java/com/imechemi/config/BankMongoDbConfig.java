package com.imechemi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.imechemi.repository.bank", mongoTemplateRef = "bankMongoTemplate")
public class BankMongoDbConfig {
}
