package com.saydin.api;

import com.saydin.dto.EmploymentDTO;
import com.saydin.service.EmploymentService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employment")

public class EmploymentApi {

    @Autowired
    private EmploymentService employmentService;

    @PostMapping
    public ResponseEntity<EmploymentDTO> kaydet(@Valid @RequestBody EmploymentDTO kisiDto) {
        return ResponseEntity.ok(employmentService.save(kisiDto));
    }

    @GetMapping
    public ResponseEntity<List<EmploymentDTO>> tumunuListele() {
        return ResponseEntity.ok(employmentService.getAll());
    }
}