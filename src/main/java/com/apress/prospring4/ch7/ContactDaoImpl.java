package com.apress.prospring4.ch7;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

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
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        Log.info("All contacts");
        return sessionFactory.getCurrentSession().getNamedQuery("Contact.findAllWithDetail").list();
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return (Contact) sessionFactory.getCurrentSession().getNamedQuery("Contact.findById")
                .setParameter("id", id).uniqueResult();
    }

    @Override
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate("Contact", contact);
        Log.info("Contact saved with id: " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
        Log.info("Contact deleted with id: " + contact.getId());
    }
}
