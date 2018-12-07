package com.apress.prospring4.ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        ContactService contactService =
                ctx.getBean("springJpaContactService", ContactService.class);
        listContacts(contactService.findAll());

    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println(" ");

        for (Contact contact : contacts){
            System.out.println(contact);

//            for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
//                System.out.println("---->" + contactTelDetail);
//            }
//
//            for (Hobby hobby : contact.getHobbies()) {
//                System.out.println("---->" + hobby);
//            }
        }

    }
}
