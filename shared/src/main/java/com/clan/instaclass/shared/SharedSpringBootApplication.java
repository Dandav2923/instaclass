package com.clan.instaclass.shared;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharedSpringBootApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SharedSpringBootApplication.class , args);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}


