package com.pzg.springcloud.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Detlecosumer2Application {

    public static void main(String[] args) {
        SpringApplication.run(Detlecosumer2Application.class, args);
    }

}