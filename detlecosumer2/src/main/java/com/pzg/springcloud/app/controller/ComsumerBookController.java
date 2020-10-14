package com.pzg.springcloud.app.controller;


import com.pzg.springcloud.app.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/comsumer")
public class ComsumerBookController {

    private static final String URL ="http://localhost:8888/book/" ;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id" ) Integer id ){
        return restTemplate.exchange( URL+id, HttpMethod.GET, new HttpEntity<Object>(  httpHeaders   ), Book.class ).getBody();
       // return restTemplate.getForObject(URL+"get/", Book.class);
    }

    @GetMapping("findAll")
    public List<Book> findAll(){
        return restTemplate.exchange(URL+"findAll",HttpMethod.GET, new HttpEntity<Object>(  httpHeaders ), List.class).getBody();
       // return restTemplate.getForObject(URL+"findAll",List.class);
    }
}
