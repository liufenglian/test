package com.example.test.designpattern.observer;

public class WeChatClient  implements  Subscriber{
    private String username;

    public WeChatClient(String username) {
        this.username = username;
    }

    @Override
    public int receive(String publisher, String articleName) {
        // 接收到推送时的操作
        System.out.println(String.format("用户<%s> 接收到 <%s>微信公众号 的推送，文章标题为 <%s>", username, publisher, articleName));
        return 0;
    }
}
