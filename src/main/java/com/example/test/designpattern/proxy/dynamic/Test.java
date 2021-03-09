package com.example.test.designpattern.proxy.dynamic;

import java.lang.reflect.Proxy;

public class Test {


    public static void main(String[] args) {
        Student s = new Student();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Class<?> [] interfaces =  s.getClass().getInterfaces();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(s);

        Person proxy = (Person)Proxy.newProxyInstance(classLoader,interfaces,myInvocationHandler);

        proxy.sayHello("xiaohai",20);
    }

}
