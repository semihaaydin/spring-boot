package com.saydin.api;

import com.saydin.model.CustomerV1;
import com.saydin.model.CustomerV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerAccount {

    //1. Yöntem : Rest uri dan yapmak

    @GetMapping(value = "/v1/customer")
    public ResponseEntity<CustomerV1> pathVersionCustomerV1() {
        return ResponseEntity.of(Optional.of(new CustomerV1("Semiha")));
    }

    @GetMapping(value = "/v2/customer")
    public ResponseEntity<CustomerV2> pathVersionCustomerV2() {
        return ResponseEntity.of(Optional.of(new CustomerV2("Semiha", "Aydin")));
    }

    //2. Yöntem : Param Versioning

    //http://localhost:8080/api/param/customer?v1
    @GetMapping(value = "/param/customer", params = "v1")
    public ResponseEntity<CustomerV1> paramVersionCustomerV1() {
        return ResponseEntity.of(Optional.of(new CustomerV1("Semiha")));
    }

    @GetMapping(value = "/param/customer", params = "v2")
    public ResponseEntity<CustomerV2> paramVersionCustomerV2() {
        return ResponseEntity.of(Optional.of(new CustomerV2("Semiha", "Aydin")));


        //3. Yöntem : Header Versioning
        //http://localhost:8080/api/param/customer
        //
    }
        @GetMapping(value = "/header/customer" , headers = "X-VERSION=v1")
        public ResponseEntity<CustomerV1> headerVersionCustomerV1() {
            return ResponseEntity.of(Optional.of(new CustomerV1("Semiha")));
        }

        @GetMapping(value = "/header/customer", headers = "X-VERSION=v2")
        public ResponseEntity<CustomerV2> headersVersionCustomerV2() {
            return ResponseEntity.of(Optional.of(new CustomerV2("Semiha", "Aydin")));
        }


    }
