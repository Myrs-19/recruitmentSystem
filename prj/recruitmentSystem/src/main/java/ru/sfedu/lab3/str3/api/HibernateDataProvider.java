package ru.sfedu.lab3.str3.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.lab3.str3.util.HibernateUtil;

public class HibernateDataProvider {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;
    private Transaction transaction;

    Logger log = LogManager.getLogger(HibernateDataProvider.class.getName());

    public void saveRecord(Object object) throws Exception {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    public void deleteRecord(Object object) throws Exception {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

    public void updateRecord(Object object) throws Exception {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }
    public Object getRecord(Class cl, String id) throws Exception {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session.get(cl, id);
    }
}