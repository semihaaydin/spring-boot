package com.saydin.controller;

import com.saydin.dto.EmploymentDTO;
import com.saydin.service.EmploymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/kisi")

public class EmploymentController {

    @Autowired
    public EmploymentService employmentService;

    @GetMapping
    public ResponseEntity<List<EmploymentDTO>> getAll() {
        return ResponseEntity.ok(employmentService.getAll());
    }
}
