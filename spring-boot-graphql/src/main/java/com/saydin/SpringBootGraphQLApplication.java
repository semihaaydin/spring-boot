package com.saydin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link com.coxautodev.graphql.tools.GraphQLQueryResolver}
 * {@link com.coxautodev.graphql.tools.GraphQLMutationResolver}
 *
 */
@SpringBootApplication
public class SpringBootGraphQLApplication {

    //GraphQLQueryResolver : API üzerinde sorgulama
    //GraphQLMutationResolver : Sunucumuzdaki resource değiştirmek için

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphQLApplication.class,args);
    }
}
