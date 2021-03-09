package com.example.test.designpattern.tactics;


/**
 * 环境角色
 * */
public class Environment {
    private Strategy strategy;

    public Environment(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return strategy.calc(a, b);
    }

}
