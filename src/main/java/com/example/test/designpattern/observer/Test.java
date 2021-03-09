package com.example.test.designpattern.observer;

public class Test {

    public static void main(String[] args) {
        WeChatAccounts accounts = new WeChatAccounts("小旋锋");

        WeChatClient user1 = new WeChatClient("张三");
        WeChatClient user2 = new WeChatClient("李四");
        WeChatClient user3 = new WeChatClient("王五");

        accounts.subscribe(user1);
        accounts.subscribe(user2);
        accounts.subscribe(user3);

        accounts.publishArticles("设计模式 | 观察者模式及典型应用", "观察者模式的内容...");

        accounts.unsubscribe(user1);
        accounts.publishArticles("设计模式 | 单例模式及典型应用", "单例模式的内容....");
    }
}
