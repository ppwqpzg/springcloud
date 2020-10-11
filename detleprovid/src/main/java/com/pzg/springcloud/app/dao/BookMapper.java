package com.pzg.springcloud.app.dao;



import com.pzg.springcloud.app.bean.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends MisBaseMapper<Book>{
}
