package com.deliveryfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
public class DeliveryFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryFoodApplication.class, args);
    }

}
