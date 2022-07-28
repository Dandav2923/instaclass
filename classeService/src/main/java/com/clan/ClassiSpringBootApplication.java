package com.clan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassiSpringBootApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ClassiSpringBootApplication.class , args);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}