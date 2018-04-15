package com.apress.prospring4.ch2;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldМessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}