package com.imechemi.config.client;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@Configuration
public class MongoDbConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb.school")
    public MongoProperties schoolDatabaseProperties() {
        return new MongoProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb.bank")
    public MongoProperties bankDatabaseProperties() {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "schoolMongoTemplate")
    public MongoTemplate schoolMongoTemplateRef() {
        return new MongoTemplate(schoolMongoDbFactory(schoolDatabaseProperties()));
    }

    @Bean(name = "bankMongoTemplate")
    public MongoTemplate bankMongoTemplateRef() {
        return new MongoTemplate((bankMongoDbFactory(bankDatabaseProperties())));
    }

    @Primary
    @Bean
    public MongoDbFactory schoolMongoDbFactory (MongoProperties mongoProperties) {
        return new SimpleMongoClientDbFactory(schoolMongoClient(mongoProperties), mongoProperties.getDatabase());
    }

    @Bean
    public MongoDbFactory bankMongoDbFactory(MongoProperties mongoProperties) {
        return new SimpleMongoClientDbFactory(bankMongoClient(mongoProperties), mongoProperties.getDatabase());
    }

    @Bean
    @Primary
    public MongoClient schoolMongoClient(MongoProperties mongo) {
        MongoCredential credential = MongoCredential.createCredential(mongo.getUsername(), mongo.getDatabase(), mongo.getPassword());
        ConnectionString connectionString = new ConnectionString(mongo.getUri());
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .credential(credential)
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(clientSettings);
    }

    @Bean
    public MongoClient bankMongoClient(MongoProperties mongo) {
        MongoCredential credential = MongoCredential.createCredential(mongo.getUsername(), mongo.getDatabase(), mongo.getPassword());
        ConnectionString connectionString = new ConnectionString(mongo.getUri());
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .credential(credential)
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(clientSettings);
    }
}
