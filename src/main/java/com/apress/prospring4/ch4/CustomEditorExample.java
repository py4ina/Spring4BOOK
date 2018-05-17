package com.apress.prospring4.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomEditorExample {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        CustomEditorExample bean = (CustomEditorExample) ctx.getBean("exampleBean");
        System.out.println(bean.getName());
    }
}
