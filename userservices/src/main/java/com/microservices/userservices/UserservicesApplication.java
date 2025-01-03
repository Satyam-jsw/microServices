package com.microservices.userservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.microservices.userservices.external.services")

public class UserservicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserservicesApplication.class, args);

    }
}
