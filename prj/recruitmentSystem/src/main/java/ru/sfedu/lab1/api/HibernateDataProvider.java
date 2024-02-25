package ru.sfedu.lab1.api;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
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
    
    /**
     * Метод возвращает список таблиц в базе данных
     * @return лист списка баз данных
     */
    public List<String> getListTables(){
        log.debug("getListTables [1]: get list data bases");
        
        Session session = getSession();
        
        log.debug("getListTables [2]: begin transaction");
        
        session.beginTransaction();
        
        log.debug("getListTables [3]: query");
        
        NativeQuery query = session.createNativeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema='public';");
        
        return query.list();
    }
}
