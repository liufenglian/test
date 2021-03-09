package com.example.test.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("MyInvocationHandler invoke begin");

        System.out.println("proxy:"+proxy.getClass().getName());

        System.out.println("method: "+ method.getName());

        method.invoke(object, args);

        System.out.println("MyInvocationHandler invoke end");
        return null;
    }

}
