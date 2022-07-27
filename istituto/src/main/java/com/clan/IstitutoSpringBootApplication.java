package com.clan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IstitutoSpringBootApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(IstitutoSpringBootApplication.class , args);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
