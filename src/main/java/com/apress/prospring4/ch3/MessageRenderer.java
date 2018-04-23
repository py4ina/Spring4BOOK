package com.apress.prospring4.ch3;

import com.apress.prospring4.ch2.MessageProvider;

public interface MessageRenderer {
    void render();
    void  setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMassageProvider();
}
