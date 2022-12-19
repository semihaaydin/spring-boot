package com.saydin.service.impl;

import com.saydin.dto.EmploymentDTO;
import com.saydin.entity.Address;
import com.saydin.entity.Employment;
import com.saydin.repository.AddressRepository;
import com.saydin.repository.EmploymentRepository;
import com.saydin.service.EmploymentService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class EmploymentServiceImpl implements EmploymentService {

    private final EmploymentRepository employmentRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public EmploymentDTO save(EmploymentDTO employmentDTO) {
        Assert.isNull(employmentDTO.getName(),"Name is request");

        Employment employment=new Employment();
        employment.setName(employmentDTO.getName());
        employment.setSurname(employmentDTO.getSurname());
        final Employment employmentDb=employmentRepository.save(employment);

        List<Address> liste= new ArrayList<>();

        employmentDTO.getAddressList().forEach(s -> {
            Address address=new Address();
            address.setAddress(s);
            address.setAddressType(Address.AdressType.HOME);
            address.setIsActive(true);
            address.setEmployment(employmentDb);
            liste.add(address);
        });

        addressRepository.saveAll(liste);
        employmentDTO.setId(employmentDb.getId());
        return employmentDTO;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<EmploymentDTO> getAll() {
        List<Employment> employments=employmentRepository.findAll();
        List<EmploymentDTO> employmentDTOList=new ArrayList<>();

        employments.forEach(e -> {
            EmploymentDTO employmentDTO=new EmploymentDTO();
            employmentDTO.setId(e.getId());
            employmentDTO.setName(e.getName());
            employmentDTO.setSurname(e.getSurname());
            employmentDTO.setAddressList(e.getAddressList().stream().map(Address::getAddress).collect(Collectors.toList()));
            employmentDTOList.add(employmentDTO);
        });
        return employmentDTOList;
    }

    @Override
    public Page<EmploymentDTO> getAll(Pageable pageable) {
        return null;
    }


}
