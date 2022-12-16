package com.saydin.api;

import com.saydin.model.Department;
import com.saydin.repository.DepartmentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentApi {
    private final DepartmentRepository departmentRepository;

    @PostConstruct
    public void init(){
        Department department=new Department();
        department.setName("sales");
        department.setSubDepartment("internal");
        departmentRepository.save(department);
    }
    @GetMapping("/{search}")
    public ResponseEntity <List<Department>> getUser(@PathVariable String search){
        return  ResponseEntity.ok(departmentRepository.getByNameCustomerQuery(search));
    }
}
