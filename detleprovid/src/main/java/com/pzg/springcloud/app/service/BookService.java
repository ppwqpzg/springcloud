package com.pzg.springcloud.app.service;


import com.pzg.springcloud.app.bean.Book;

import java.util.List;

public interface BookService {
    public Book getBook(Integer id);
    public List<Book> findAll();
}