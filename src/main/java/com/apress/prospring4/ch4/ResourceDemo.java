package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class ResourceDemo {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();
        System.out.println(file.getPath());

        Resource resource1 = ctx.getResource("file://" + file.getPath());
        displayInfo(resource1);

        Resource resource2 = ctx.getResource("classpath:test.txt");
        displayInfo(resource2);

        Resource resource3 = ctx.getResource("http://www.google.com");
        displayInfo(resource3);
    }

    private static void displayInfo(Resource resource) throws IOException {
        System.out.println(resource.getClass());
        System.out.println(resource.getURL().getContent());
        System.out.println("");
    }
}
