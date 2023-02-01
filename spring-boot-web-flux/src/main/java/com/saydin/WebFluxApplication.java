package com.saydin;

import com.saydin.entity.Employee;
import com.saydin.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class WebFluxApplication {

    @Autowired
    private EmployeeRepo employeeRepo;

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class,args);
    }

    @EventListener(ApplicationStartedEvent.class)
        public void appStart(){
        if (employeeRepo.count().block() == 0) {
            IntStream.range(0, 100)
                    .mapToObj(this::generate)
                    .map(employeeRepo::save)
                    .collect(Collectors.toList())
                    .forEach(item -> item.subscribe(System.out::println));
        }
        }

        private Employee generate(int i){
            return Employee.builder()
                    .name("Name" + i)
                    .lastName("Lastname"+i)
                    .birthDate(LocalDate.now())
                    .build();
        }
    }

