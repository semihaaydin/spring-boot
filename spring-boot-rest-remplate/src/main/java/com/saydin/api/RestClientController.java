package com.saydin.api;

import com.saydin.model.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String webUrl="http://localhost:9191/user";

    @GetMapping
    public ResponseEntity<List<User>> getCustomerList(){
        Object result= restTemplate.getForEntity(webUrl,Object.class);
        System.out.println(result);
        return null;
    }


}
