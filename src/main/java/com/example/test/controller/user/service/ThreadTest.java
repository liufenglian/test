package com.example.test.controller.user.service;

public class ThreadTest implements  Runnable {
    private  volatile  static  boolean isComplete=false;
    @Override
    public void run() {
        System.out.println("我不配吃肉，我不配吃肉，我不配吃肉！！！");
        isComplete=true;
    }
    public static void main(String[] args) throws InterruptedException {

        Thread threadTest = new Thread(new ThreadTest());
        System.out.println("刚new 完看下状态：" +threadTest.getState().toString());//new
        threadTest.start();
        System.out.println("刚调用状态="+threadTest.getState().toString());//runnable
        while (true){
                System.out.println("执行状态"+threadTest.getState().toString());//出现了被阻塞的状态 Blocked,是因为主线程的while 优先级高于threadTest的缘故吗
                if (isComplete) {
                    System.out.println("执行完毕状态为："+threadTest.getState().toString());//runnable-> terminated
                    break;
            }

        }
    }
}
