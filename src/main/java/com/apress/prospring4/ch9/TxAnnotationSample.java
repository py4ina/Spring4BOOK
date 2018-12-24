package com.apress.prospring4.ch9;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class TxAnnotationSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/tx-declarative-app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        List<Contact> contacts = contactService.findAll();

        for (Contact contact: contacts){
            System.out.println(contact);
        }

        Contact contact = contactService.findById(1l);
        contact.setFirstName("Peter");
        contactService.save(contact);
        System.out.println(contact);
        System.out.println(contactService.countAll());
    }
}
