package com.saydin.service;

import com.saydin.aop.CustomExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @CustomExecutionTime
    public String createCustomer(String customer) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("customer createCustomer created with " + customer);
        return customer;
    }
}
