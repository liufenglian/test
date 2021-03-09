package com.example.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    FactoryForStrategy factoryForStrategy;

    @GetMapping("/testOne")
    public String sayHello()
    {
        return   factoryForStrategy.getStrategy("Two").doOperation();
    }

    }
