package com.apress.prospring4.ch7;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll();
    List findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
