package com.apress.prospring4.ch3;

import com.apress.prospring4.ch2.MessageProvider;

public class HelloWorldМessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
