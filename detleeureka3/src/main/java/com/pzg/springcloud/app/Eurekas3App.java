package com.pzg.springcloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   //启用 eureka服务器
public class Eurekas3App {
    public static void main(String[] args) {
        SpringApplication.run(  Eurekas3App.class, args );
    }
}
