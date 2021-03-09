package com.example.test.designpattern.proxy.static1;

public class Test {

    public static void main(String[] args) {

        Student s = new Student();

        ProxyTest proxyTest = new ProxyTest(s);

        proxyTest.sayHello("welcome to java", 20);

        System.out.println("******");

        proxyTest.sayGoodBye(true, 100);


    }
}
