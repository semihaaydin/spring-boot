package com.saydin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerV2 {
    private Long id;
    private String name;
    private String surname;

    public CustomerV2(String name,String surname) {
        this.name=name;
        this.surname=surname;
    }

}
