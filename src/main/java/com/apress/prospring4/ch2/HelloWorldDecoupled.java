package com.apress.prospring4.ch2;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        MessageProvider messageProvider = new HelloWorldМessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
