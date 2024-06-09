package ru.sfedu.lab5.api;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.sfedu.Constants;
import ru.sfedu.lab5.model.Company;
import ru.sfedu.lab5.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class HibernateDataProvider implements IHibernateDataProvider{

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;
    private Transaction transaction;

    Logger log = LogManager.getLogger(HibernateDataProvider.class.getName());

    public HibernateDataProvider(){
        if (session == null){
            log.debug("HibernateDataProvider [1]: create session");
            session = sessionFactory.openSession();
        }
    }

    public void saveRecord(Object object) throws Exception {
        //session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        //session.close();
    }

    public void deleteRecord(Object object) throws Exception {
        //session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        //session.close();
    }

    public void updateRecord(Object object) throws Exception {
        //session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        //session.close();
    }
    public Object getRecord(Class cl, String id) throws Exception {
        //session = sessionFactory.openSession();
        //transaction = session.beginTransaction();
        return session.get(cl, id);
    }

    @Override
    public List<Company> selectAllNativeSql() {
        log.debug("selectAllNativeSql [1]: select all Company entities");
        String nativeSql = Constants.HIBERNATE_NATIVE_SQL_SELECT_COMPANY;
        List<Company> results = null;
        try {
            NativeQuery<Company> query = session.createNativeQuery(nativeSql, Company.class);
            results = query.getResultList();
        } catch (Exception e) {
            log.error("selectAllNativeSql [2]: ERROR {}", e.getMessage());
        }
        log.debug("selectAllNativeSql [3]: end work");
        return results;
    }

    @Override
    public List<Company> selectAllCriteria() {
        log.debug("selectAllCriteria [1]: select all Company entities");
        List<Company> results = new ArrayList<>();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Company> critQuery = builder.createQuery(Company.class);
            Root<Company> root = critQuery.from(Company.class);
            critQuery.select(root);
            Query<Company> query = session.createQuery(critQuery);
            results = query.getResultList();
        } catch (Exception e) {
            log.error("selectAllCriteria [2]: ERROR {}", e.getMessage());
        }
        log.debug("selectAllCriteria [3]: end work");
        return results;
    }

    @Override
    public List<Company> selectAllHQL() {
        log.debug("selectAllHQL [1]: select all Company entities");
        String hqlQuery = Constants.HIBERNATE_HSQL_SELECT_COMPANY;
        List<Company> results = new ArrayList<>();
        try {
            Query<Company> query = session.createQuery(hqlQuery, Company.class);
            results = query.getResultList();
        } catch (Exception e) {
            log.error("selectAllHQL [2]: ERROR {}", e.getMessage());
        }
        log.debug("selectAllHQL [3]: end work");
        return results;
    }

}