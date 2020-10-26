package com.pzg.springcloud.app.robinConfigration;


import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
//这个类暂时不会被spring托管
public class RobinConfigure {
    @Bean
    public IRule ribbonRule(){
        return new com.netflix.loadbalancer.RandomRule();

    }

}
