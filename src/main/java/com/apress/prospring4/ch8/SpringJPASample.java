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


        System.out.println("Add new Contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Michail5");
        contact.setLastName("Jackson5");
        contact.setBirthDate(new Date());
        contactAuditService.save(contact);

        listContacts(contactAuditService.findAll());

        System.out.println("--------------");
        System.out.println("Contact with id: " + contact.getId() + " is contact -> " + contact);
        System.out.println("--------------");

        contact.setFirstName("Tom5");
        contactAuditService.save(contact);

        ContactAudit oldContact = contactAuditService.findAuditByRevision(contact.getId(), 1);
        System.out.println(oldContact);
        ContactAudit oldContact2 = contactAuditService.findAuditByRevision(contact.getId(), 2);
        System.out.println(oldContact2);
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
