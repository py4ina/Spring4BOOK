package com.apress.prospring4.ch3.xml;

import com.apress.prospring4.ch3.MessageProvider;


public class ConfigurabeMessageProvider implements MessageProvider {
    private String message;

    public ConfigurabeMessageProvider(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
