package com.example.web;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by JasonZh on 2017/8/21.
 */
@Service
@CacheConfig(cacheNames = "users3")
public class UserService {

    @Autowired
    private UserMapper userMapper;


    @Cacheable(key = "#p0")
    public User findByName(String name) {
        System.out.println("ssss");
        User user = userMapper.findByName(name);
        return user;
    }



    @CachePut(key = "#p0.name")
    public User update(User user) {
        if(userMapper.update(user) > 1) {
            return user;
        }
        return user;
    }

}
