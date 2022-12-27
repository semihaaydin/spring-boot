package com.saydin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootRabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitApplication.class,args);
    }

}
