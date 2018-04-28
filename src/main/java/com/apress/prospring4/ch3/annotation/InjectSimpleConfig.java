package com.apress.prospring4.ch3.annotation;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    public String name = "John Smith";
    public int age = 35;
    public float height = 1.778f;
    public boolean programmer = true;
    public Long ageInSeconds = 1009843200L;

}
