package com.saydin.repository;

import com.saydin.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User,String> {

    //Veritabanı kök işlemleri yapar.
}
