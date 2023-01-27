package com.saydin.service;

import com.github.javafaker.Faker;
import com.saydin.api.CustomerApi;
import com.saydin.exception.EntityNotFoundException;
import com.saydin.model.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    List<Customer> customers=new ArrayList<Customer>();

    @PostConstruct
    public void init(){
        Faker faker=new Faker();
        for(int i=0;i<=100;i++){
            Customer customer= new Customer();
            customer.setName(faker.name().firstName());
            System.out.println(customer.getName());
            customers.add(customer);
        }
    }

    public Customer getCustomerByName(String name) {
        if (name.equals("1")) {
           throw new IllegalArgumentException();
        } else {
            return customers.stream().filter(item -> item.getName().equals(name)).findFirst()
                    .orElseThrow(() -> new EntityNotFoundException(name));
        }
    }
}
