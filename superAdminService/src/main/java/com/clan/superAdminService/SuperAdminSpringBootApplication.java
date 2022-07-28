package com.clan.superAdminService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperAdminSpringBootApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SuperAdminSpringBootApplication.class , args);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
