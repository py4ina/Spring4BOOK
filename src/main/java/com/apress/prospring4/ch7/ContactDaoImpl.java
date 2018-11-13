package com.apress.prospring4.ch7;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
    private static final Log Log = LogFactory.getLog(ContactDaoImpl.class);
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<com.apress.prospring4.ch7.Contact> findAll() {
        return null;
    }

    @Override
    public List<com.apress.prospring4.ch7.Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public com.apress.prospring4.ch7.Contact findById(Long id) {
        return null;
    }

    @Override
    public com.apress.prospring4.ch7.Contact save(com.apress.prospring4.ch7.Contact contact) {
        return null;
    }

    @Override
    public void delete(Long contactId) {

    }
}
