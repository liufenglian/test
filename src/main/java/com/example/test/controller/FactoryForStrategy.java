package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FactoryForStrategy {

    @Autowired
    Map<String, Strategy> strategys = new ConcurrentHashMap<>(3);

    public Strategy getStrategy(String component) {
        System.out.println(strategys);
        Strategy strategy = strategys.get(component);
        if(strategy == null) {
            throw new RuntimeException("no strategy defined");
        }
        return strategy;
    }
}
