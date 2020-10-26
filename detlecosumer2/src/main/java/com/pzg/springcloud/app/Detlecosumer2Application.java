package com.pzg.springcloud.app;



import com.pzg.springcloud.app.robinConfigration.RobinConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "DETLEPROVID",configuration = RobinConfigure.class)
//如有多个服务器必须采用@RibbonClients
public class Detlecosumer2Application {
    public static void main(String[] args) {
        SpringApplication.run(Detlecosumer2Application.class, args);
    }

}