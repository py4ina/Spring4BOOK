package com.apress.prospring4.ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringJPASample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        ContactAuditService contactAuditService =
                ctx.getBean("contactAuditService", ContactAuditService.class);

        List<ContactAudit> contacts = contactAuditService.findAll();
        listContacts(contacts);

        System.out.println("Add new Contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Michail");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());

        contactAuditService.save(contact);

        contacts = contactAuditService.findAll();
        listContacts(contacts);

        contact = contactAuditService.findById(2l);
        System.out.println("--------------");
        System.out.println("Contact with id: " + contact.getId() + " is contact -> " + contact);
        System.out.println("--------------");

        System.out.println("Print update Contact");
        contact.setFirstName("Tom");
        contactAuditService.save(contact);

        contacts = contactAuditService.findAll();
        listContacts(contacts);
    }

    private static void listContacts(List<ContactAudit> contacts) {
        System.out.println(" ");

        for (ContactAudit contact : contacts){
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
