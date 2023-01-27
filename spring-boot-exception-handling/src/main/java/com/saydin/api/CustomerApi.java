package com.saydin.api;

import com.saydin.exception.EntityNotFoundException;
import com.saydin.model.Customer;
import com.saydin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerApi {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Customer> getCustomer(String name){
        return ResponseEntity.ok(customerService.getCustomerByName(name));
    }


}
