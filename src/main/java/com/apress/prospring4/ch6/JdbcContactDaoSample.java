package com.apress.prospring4.ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class JdbcContactDaoSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("META-INF/spring/datasource-drivermanager.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        List<Contact> contacts = contactDao.findAllWithDetail();
        for (Contact contact: contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
        }
//        System.out.println("Last name for CONTACT id 1 is: " + contactDao.findLastNameById(1l));
    }
}
