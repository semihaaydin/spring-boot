package com.saydin.service;

import com.github.javafaker.Faker;
import com.saydin.entity.User;
import com.saydin.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    Object target;
    Logger logger= LoggerFactory.getLogger(UserService.class);

    @Async
    public void saveUserWithFakeData(){
        Faker faker = new Faker();
        long start = System.currentTimeMillis();
        List<User> users=new ArrayList<>();
        for(int i=0;i<=100;i++){
            User user=new User();
            String name = faker.name().firstName(); user.setName(name);
            user.setEmail(faker.internet().emailAddress());
            user.setId(i);
            users.add(user);
        }
        long end = System.currentTimeMillis();
        logger.info("Total time {}", (end - start));
        logger.info("save list of user by faker "+Thread.currentThread().getName());
        repository.saveAll(users);
    }

    @Async
    public List<User> findAllUsers(){
        logger.info("get list of user by "+Thread.currentThread().getName());
        List<User> users=repository.findAll();
        users.stream().forEach(user ->{
            try {
                Thread.sleep(5000);
                System.out.println("Get  "+user.getId() +user.getEmail()+" by: "+Thread.currentThread().getName());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        return users;
    }

    @Async
    public List<User> sendEmailTask(){
        logger.info("sendEmailTask list of user by "+Thread.currentThread().getName());
        List<User> users=repository.findAll();
        users.stream().forEach(user ->{
            try {
                Thread.sleep(1000);
                System.out.println("Sending email to "+user.getId() +user.getEmail()+" by: "+Thread.currentThread().getName());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        return users;
    }
    /*
    @Async
    public CompletableFuture<List<User>> saveUsers(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();
        List<User> users = parseCSVFile(file);
        logger.info("saving list of users of size {}", users.size(), "" + Thread.currentThread().getName());
        users = repository.saveAll(users);
        long end = System.currentTimeMillis();
        logger.info("Total time {}", (end - start));
        return CompletableFuture.completedFuture(users);
    }
    @Async
    public CompletableFuture<List<User>> findAllUsers(){
        logger.info("get list of user by "+Thread.currentThread().getName());
        List<User> users=repository.findAll();
        return CompletableFuture.completedFuture(users);
    }
    private List<User> parseCSVFile(final MultipartFile file) throws Exception {
        final List<User> users = new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    final User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);
                    users.add(user);
                }
                return users;
            }
        } catch (final IOException e) {
            logger.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }*/

}
