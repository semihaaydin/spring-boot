package com.saydin.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
@Builder
@ToString
public class Employee {
    private String id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
}
