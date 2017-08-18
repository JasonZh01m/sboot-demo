package com.example.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by JasonZh on 2017/8/16.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1L;
    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
    // 省略getter和setter


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
