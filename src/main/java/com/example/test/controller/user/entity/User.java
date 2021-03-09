package com.example.test.controller.user.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-15 16:10:13
 */
@Builder(toBuilder = true)
@Data
public class User {

    private Long id;
    
    private String name;
    
    private String passWord;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}