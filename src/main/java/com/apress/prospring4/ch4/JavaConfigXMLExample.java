package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigXMLExample {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("META-INF/spring/app-context-xml.xml");

        MessageRenderer renderer = ctx.getBean("messageRender", MessageRenderer.class);
        renderer.render();
    }
}
