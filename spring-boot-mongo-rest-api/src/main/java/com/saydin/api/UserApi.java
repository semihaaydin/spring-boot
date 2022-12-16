package com.saydin.api;

import com.saydin.model.User;
import com.saydin.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private IUserRepository userRepository;

    @PostConstruct
    public void init(){
        User user=new User();
        user.setName("Sem");
        user.setSurname("Ayd");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> add(User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
