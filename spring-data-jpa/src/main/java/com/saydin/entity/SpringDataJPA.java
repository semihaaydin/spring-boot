package com.saydin.entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDataJPA {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJPA.class, args);
    }
}
