package com.saydin.controller;

import com.saydin.entity.User;
import com.saydin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity saveUsersWithFakeData() {
        service.saveUserWithFakeData();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users")
    public List<User> findAllUsers() {
        return  service.findAllUsers();
    }


    @GetMapping(value = "/getUsersByThread")
    public  ResponseEntity getUsers(){
        service.sendEmailTask();
        List<User> users1=service.findAllUsers();
        if(!users1.isEmpty()) {
            for (User u : users1) {
                System.out.println(u.getId());
            }
        }
        return  ResponseEntity.status(HttpStatus.OK).build();
    }


/*
    @PostMapping(value = "/users",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = "application/json")
    public ResponseEntity saveUsers(@RequestParam(value="files") MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            service.saveUsers(file);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users", produces = "application/json")
    public CompletableFuture<ResponseEntity> findAllUsers() {
        return  service.findAllUsers().thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/getUsersByThread", produces = "application/json")
    public  ResponseEntity getUsers(){
        CompletableFuture<List<User>> users1=service.findAllUsers();
        CompletableFuture<List<User>> users2=service.findAllUsers();
        CompletableFuture<List<User>> users3=service.findAllUsers();
        CompletableFuture.allOf(users1,users2,users3).join();
        return  ResponseEntity.status(HttpStatus.OK).build();
    }*/
}
