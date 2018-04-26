package com.apress.prospring4.ch3.annotation;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    private String name = "John Smith";
    private int age = 35;
    private float height = 1.778f;
    private boolean programmer = true;
    private Long ageInSeconds = 1009843200L;

}
