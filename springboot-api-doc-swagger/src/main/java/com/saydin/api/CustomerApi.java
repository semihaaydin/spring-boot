package com.saydin.api;

import com.saydin.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Api(value = "Core Customer Api ")
public class CustomerApi {

    List<Customer> customers=new ArrayList<>();

    @PostConstruct
    public void init(){
        customers.add(new Customer(1L,"A company","Mahmut"));
        customers.add(new Customer(1L,"B company","Ali"));
        customers.add(new Customer(1L,"C company","Veli"));
    }

    @GetMapping
    @ApiOperation(value = "Get All Customer",notes = "Attention Performance")
    ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Customer> save(@ApiParam(value = "Customer path") @RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.ok(customer);
    }

}
