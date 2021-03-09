package com.example.test.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Subscriber> subscribers;
    private boolean pubStatus = false;

    public Publisher() {
        subscribers = new ArrayList<Subscriber>();
    }

    protected void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    protected void unsubscribe(Subscriber subscriber) {
        if (this.subscribers.contains(subscriber)) {
            this.subscribers.remove(subscriber);
        }
    }

    protected void notifySubscribers(String publisher, String articleName) {
        if (this.pubStatus == false) {
            return;
        }
        for (Subscriber subscriber : this.subscribers) {
            subscriber.receive(publisher, articleName);
        }
        this.clearPubStatus();
    }

    protected void setPubStatus() {
        this.pubStatus = true;
    }

    protected void clearPubStatus() {
        this.pubStatus = false;
    }
}
