package com.apress.prospring4.ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        Contact contact = new Contact();
        contact.setId(1l);
        contact.setFirstName("Chris");
        contact.setLastName("John");
        contact.setBirthDate(new Date(
                (new GregorianCalendar(1977, 10, 1)).getTime().getTime()));

        contactDao.insert(contact);

        listContacts(contactDao.findAll());
    }

    private static void listContacts(List<Contact> contacts) {
        for (Contact contact: contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
        }
    }
}
