package com.apress.prospring4.ch8;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    List findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
