package com.saydin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAsync
public class SpringBootAOPApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAOPApplication.class,args);
    }
}
