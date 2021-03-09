package com.example.test.controller;

import org.springframework.stereotype.Component;

@Component("Two")
public class StrategyTwo implements Strategy {
    @Override
    public String doOperation() {
        return "Two";
    }
}
