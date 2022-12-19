package com.saydin.service;

import com.saydin.dto.EmploymentDTO;

import java.util.List;

public interface EmploymentService {
    EmploymentDTO save(EmploymentDTO employmentDTO);
    List<EmploymentDTO> getAll();
}
