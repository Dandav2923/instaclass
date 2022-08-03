package com.clan.instaclass.instituteService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InsituteApplication {
    public static void main(String[] args) {
        SpringApplication.run(InsituteApplication.class, args);
    }
}