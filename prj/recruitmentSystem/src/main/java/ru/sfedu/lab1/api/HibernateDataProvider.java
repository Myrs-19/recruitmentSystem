package ru.sfedu.lab1.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sfedu.api.HibernateUtil;


public class HibernateDataProvider {
    
    private static final Logger log = LogManager.getLogger(HibernateDataProvider.class.getName());
    
    /**
     * Метод открывает и возвращает созданную сессию
     * @return открытая сессия
     */
    public static Session getSession(){
        log.debug("getSession [1]: get session factory");
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        log.debug("getSession [2]: open and return session");
        
        return sessionFactory.openSession();
    }
}
