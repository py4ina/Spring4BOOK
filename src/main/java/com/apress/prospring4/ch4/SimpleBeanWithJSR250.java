package com.apress.prospring4.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class SimpleBeanWithJSR250 {
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type" +
                    SimpleBeanWithJSR250.class);
        }
    }

    @Override
    public String toString() {
        return "SimpleBeanWithJSR250{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        SimpleBeanWithJSR250 simleBean1 = getBean("simpleBeanl1", ctx);
        SimpleBeanWithJSR250 simleBean2 = getBean("simpleBeanl2", ctx);
        SimpleBeanWithJSR250 simleBean3 = getBean("simpleBeanl3", ctx);
    }

    private static SimpleBeanWithJSR250 getBean(String beanName, GenericXmlApplicationContext ctx) {
        try {
            SimpleBeanWithJSR250 bean = (SimpleBeanWithJSR250) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException e) {
            System.out.println("n error occured in bean configuration: " + e.getMessage());
            return null;
        }
    }
}
