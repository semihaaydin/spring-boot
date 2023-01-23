package com.saydin.api;

import com.saydin.model.User;
import com.saydin.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {

    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public List<User> getAll(){
       return userRepository.findAll();
    }
}
