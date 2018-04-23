package com.apress.prospring4.ch3;


import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldМessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
