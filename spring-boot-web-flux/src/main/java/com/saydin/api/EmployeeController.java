package com.saydin.api;

import com.saydin.entity.Employee;
import com.saydin.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    @GetMapping("/id")
    public Mono<Employee> getById(@PathVariable String id) {
        return employeeRepo.findById(id);
    }

    @GetMapping("/all")
    public Flux<Employee> getById() {
        return employeeRepo.findAll();
    }
}
