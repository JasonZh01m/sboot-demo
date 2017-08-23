package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by JasonZh on 2017/8/21.
 */
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name} limit 1")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);


    @Update("UPDATE USER SET NAME = #{name}, AGE = #{age} WHERE ID = #{id}")
    int update(User user);

}
