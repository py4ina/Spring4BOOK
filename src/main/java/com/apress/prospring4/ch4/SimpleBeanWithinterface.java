package com.apress.prospring4.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithinterface implements InitializingBean {
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void myInit() {
        System.out.println("MyInit");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type" +
                    SimpleBeanWithinterface.class);
        }
    }

    @Override
    public String toString() {
        return "SimpleBeanWithinterface{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        SimpleBeanWithinterface simleBean1 = getBean("simpleBeanl1", ctx);
        SimpleBeanWithinterface simleBean2 = getBean("simpleBeanl2", ctx);
        SimpleBeanWithinterface simleBean3 = getBean("simpleBeanl3", ctx);
    }

    private static SimpleBeanWithinterface getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBeanWithinterface bean = (SimpleBeanWithinterface) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException e) {
            System.out.println("n error occured in bean configuration: " + e.getMessage());
            return null;
        }

    }
}
