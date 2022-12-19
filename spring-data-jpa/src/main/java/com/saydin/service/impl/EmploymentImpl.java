package com.saydin.service.impl;

import com.saydin.dto.EmploymentDTO;
import com.saydin.entity.Employment;
import com.saydin.repository.EmploymentRepository;
import com.saydin.service.EmploymentService;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class EmploymentImpl implements EmploymentService {

    private final EmploymentRepository employmentRepository;

    @Override
    @Transactional
    public EmploymentDTO save(EmploymentDTO employmentDTO) {
        Assert.notNull(employmentDTO.getName(), "Name must be required!");

        Employment employment = new Employment();
        employment.setName(employmentDTO.getName());
        employment.setLastName(employmentDTO.getLastName());
        final  Employment employmentDb = employmentRepository.save(employment);
        employmentDTO.setId(employmentDb.getId());
        return employmentDTO;
    }

    @Override
    public List<EmploymentDTO> getAll() {
        List<Employment> employments = employmentRepository.findAll();
        List<EmploymentDTO> employmentDTOs = new ArrayList<>();
        employments.forEach(it -> {
            EmploymentDTO employmentDto =new EmploymentDTO();
            employmentDto.setId(it.getId());
            employmentDto.setName(it.getName());
            employmentDto.setLastName(it.getLastName());
            employmentDTOs.add(employmentDto);
        });
        return employmentDTOs;
    }
}
