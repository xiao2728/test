package com.example.springboot002.dao;

import com.example.springboot002.pojo.Detail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DetailDao {
    @Select("select * from news_detail where id = #{id}")
    public Detail getDetailById(Long id);
}
