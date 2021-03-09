package com.example.test.designpattern.proxy.static1;

/**
 * 静态代理，这个代理类也必须要实现和被代理类相同的Person接口
 * */
public class ProxyTest implements Person {

    private Person p;

    public ProxyTest(Person p) {
        this.p = p;
    }

    @Override
    public void sayHello(String content, int age) {

        System.out.println("ProxyTest sayHello begin");
        //在代理类的方法中 间接访问被代理对象的方法
        p.sayHello(content, age);
        System.out.println("ProxyTest sayHello end");

    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("ProxyTest sayHello begin");
        //在代理类的方法中 间接访问被代理对象的方法
        p.sayGoodBye(seeAgin, time);
        System.out.println("ProxyTest sayHello end");
    }


}
