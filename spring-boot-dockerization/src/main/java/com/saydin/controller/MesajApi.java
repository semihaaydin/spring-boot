package com.saydin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesajVer")
public class MesajApi {

    @GetMapping
    public String getMessage(){
        return "docker image api is success";
    }
}
