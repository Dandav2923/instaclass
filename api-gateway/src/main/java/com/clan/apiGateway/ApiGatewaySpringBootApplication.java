package com.clan.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ApiGatewaySpringBootApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ApiGatewaySpringBootApplication.class , args);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
