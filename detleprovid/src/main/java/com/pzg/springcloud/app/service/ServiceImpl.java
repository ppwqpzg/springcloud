package com.pzg.springcloud.app.service;


import com.pzg.springcloud.app.bean.Book;
import com.pzg.springcloud.app.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements BookService {

    @Autowired(required = false)
    private BookMapper bookMapper;

    @Override
    public Book getBook(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Book> findAll(){
        return bookMapper.selectAll();
    }

}