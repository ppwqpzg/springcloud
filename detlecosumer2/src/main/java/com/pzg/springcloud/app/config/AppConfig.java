package com.pzg.springcloud.app.config;


import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class AppConfig {
    //spring容器托管 “restimeplate”  RestTemplate对象
    @Bean
    @LoadBalanced  //加入负载均衡 此处的负载均衡是全局配置(针对当前的微服务)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders headers=new HttpHeaders();
        String auth="admin:a";   //认证的原始用户名和密码
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); //加密处理
        String authHeader="Basic "+new String(encodeAuth);
        headers.set("Authorization",authHeader);    //    Http请求头         Authorization: Base xxxxxxxxx
        return headers;
    }
    //这个会由spring托管，则这个消费端的微服务都会采用这种负载均衡
    //@Bean
    //public IRule ribbonRule(){
        //return new com.netflix.loadbalancer.RandomRule();
    //}
}
