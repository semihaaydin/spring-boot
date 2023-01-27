package com.saydin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerV1{
    private Long id;
    private String name;

    public CustomerV1(String name) {
        this.name=name;
    }
}
