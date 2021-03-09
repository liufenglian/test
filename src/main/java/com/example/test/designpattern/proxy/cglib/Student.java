package com.example.test.designpattern.proxy.cglib;


import com.example.test.designpattern.proxy.dynamic.Person;

/**
 *需要被代理的类 实现了一个接口Person
 * */
public class Student  {

    public void sayHello(String content, int age) {
        System.out.println("student say hello" + content + " "+ age);

    }

    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("student sayGoodBye " + time + " "+ seeAgin);
    }
}
