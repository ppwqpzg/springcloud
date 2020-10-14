package com.pzg.springcloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   //启用 eureka服务器
public class Eurekas2App {
    public static void main(String[] args) {
        SpringApplication.run(  Eurekas2App.class, args );
    }
}
