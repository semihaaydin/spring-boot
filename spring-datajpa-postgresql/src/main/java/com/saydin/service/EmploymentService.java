package com.saydin.service;

import com.saydin.dto.EmploymentDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmploymentService {

    EmploymentDTO save(EmploymentDTO employmentDTO);
    void delete(Long id);
    List<EmploymentDTO> getAll();
    Page<EmploymentDTO> getAll(Pageable pageable);
}
