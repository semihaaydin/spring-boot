package com.saydin.repo;

import com.saydin.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepo extends ReactiveMongoRepository<Employee,String> {
}
