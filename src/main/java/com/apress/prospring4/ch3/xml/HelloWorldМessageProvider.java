package com.apress.prospring4.ch3.xml;

import com.apress.prospring4.ch3.MessageProvider;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldМessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}