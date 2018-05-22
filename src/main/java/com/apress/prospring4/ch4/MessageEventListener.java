package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        MessageEvent event = (MessageEvent) messageEvent;
        System.out.println("Received: " + event.getMsg());
    }
}
