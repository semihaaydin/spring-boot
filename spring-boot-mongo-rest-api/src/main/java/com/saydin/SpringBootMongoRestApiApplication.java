package com.saydin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories //implement mongo repositories
public class SpringBootMongoRestApiApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoRestApiApplication.class, args);
    }
}
