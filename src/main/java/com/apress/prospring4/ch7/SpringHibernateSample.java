package com.apress.prospring4.ch7;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SpringHibernateSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        Contact contact = contactDao.findById(1l);

        contactDao.delete(contact);

        listContactsWithDetail(contactDao.findAllWithDetail());
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");

        for (Contact contact: contacts){
            System.out.println(contact);

            if (contact.getContactTelDetails() != null) {
                for(ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail.toString());
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby: contact.getHobbies()) {
                    System.out.println(hobby.toString());
                }
            }
            System.out.println("-----------------------------------");
        }
    }

    private static void listContact(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");

        for (Contact contact: contacts){
            System.out.println(contact);
            System.out.println();
        }
    }
}
