package com.example.test.designpattern.tactics;


/**
 * 定义具体策略角色
 * */
public class AddStrategy implements Strategy {

    @Override
    public int calc(int num1, int num2) {
         return num1 + num2;
    }
}
