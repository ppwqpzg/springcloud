package com.pzg.springcloud.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class detleprovidApplication  {

    public static void main(String[] args) {
        SpringApplication.run(detleprovidApplication.class, args);
    }

}