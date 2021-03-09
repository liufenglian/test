package com.example.test.designpattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy  implements MethodInterceptor {

    //需要代理的目标对象
    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] arr, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理开始监听！");
        Object invoke = method.invoke(target,arr);
        System.out.println("cglib动态代理监听结束！");
        return invoke;
    }

    public Object getCglibProxy(Object objectTarget){
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);
        Object rest = enhancer.create();
        return rest;
    }
}
