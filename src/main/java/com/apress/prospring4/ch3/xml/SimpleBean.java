package com.apress.prospring4.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        SimpleBean parent = (SimpleBean) ctx.getBean("inheritParent");
        SimpleBean child = (SimpleBean) ctx.getBean("inheritChild");

        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }
}
