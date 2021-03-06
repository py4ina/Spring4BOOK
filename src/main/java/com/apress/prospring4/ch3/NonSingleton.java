package com.apress.prospring4.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NonSingleton {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        String s1 = (String) ctx.getBean("noSingleton");
        String s2 = (String) ctx.getBean("noSingleton");

        System.out.println("Identity Equal?: " + (s1 == s2));
        System.out.println("Value Equal:? " + s1.equals(s2));
        System.out.println(s1);
        System.out.println(s2);
    }
}
