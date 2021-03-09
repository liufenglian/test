package com.example.test.designpattern.observer;

public interface Subscriber {
    int receive(String publisher, String articleName);
}
