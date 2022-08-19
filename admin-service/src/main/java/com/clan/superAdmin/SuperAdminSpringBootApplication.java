package com.clan.superAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableEurekaClient
public class SuperAdminSpringBootApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SuperAdminSpringBootApplication.class , args);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
