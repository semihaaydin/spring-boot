package com.saydin.api;

import com.saydin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerApi {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody String customer) throws InterruptedException {
        return ResponseEntity.ok(service.createCustomer(customer));
    }
}
