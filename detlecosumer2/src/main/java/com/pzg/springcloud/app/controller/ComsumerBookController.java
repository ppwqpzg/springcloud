package com.pzg.springcloud.app.controller;


import com.pzg.springcloud.app.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comsumer")
public class ComsumerBookController {

    //private static final String URL ="http://localhost:8888/book/" ; //通过eureka注册的服务来访问 服务名:DETLEPROVID
    // TODO: 通过eureka中注册服务来访问.

    //直接访问eureka中的服务名即可,这样 ribbon会拉取到服务实例列表，再利用负载均衡算法获取一个服务.
    //                                   http://ip:port/
    private static String RESTURI="http://DETLEPROVID/";

    @Resource
    private LoadBalancerClient loadBalancerClient;//因为ribbon是客服端的负载均衡，所以它可以在客户端的记录访问日志

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id" ) Integer id ){
        ServiceInstance serviceInstance=this.loadBalancerClient.choose(RESTURI);
        String ip=serviceInstance.getHost();
        int port=serviceInstance.getPort();
        System.out.println(
                "[服务提供实例信息]host="+serviceInstance.getHost()
                        +",port="+serviceInstance.getPort()
                        +",serviceId"+serviceInstance.getServiceId()
        );
        return restTemplate.exchange( RESTURI+"book/"+id, HttpMethod.GET, new HttpEntity<Object>(  httpHeaders   ), Book.class ).getBody();
       // return restTemplate.getForObject(URL+"get/", Book.class);
        //return restTemplate.exchange( "http://"+id+":"+"book/"+id, HttpMethod.GET, new HttpEntity<Object>(  httpHeaders   ), Book.class ).getBody();
    }

    @GetMapping("findAll")
    public List<Book> findAll(){
        return restTemplate.exchange(RESTURI+"book/"+"findAll",HttpMethod.GET, new HttpEntity<Object>(  httpHeaders ), List.class).getBody();
       // return restTemplate.getForObject(URL+"findAll",List.class);
    }
}
