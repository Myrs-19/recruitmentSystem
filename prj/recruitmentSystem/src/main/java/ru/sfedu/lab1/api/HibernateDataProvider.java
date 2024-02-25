package ru.sfedu.lab1.api;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.Constants;
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
     * Метод выполняет нативный sql запрос
     * @param query - запрос на выполнение
     * @return возвращает запрос
     */
    public static NativeQuery executeNativeQuery(String query){
        log.debug("executeNativeQuery [1]: get session");
        
        Session session = getSession();
        
        log.debug("executeNativeQuery [2]: begin transaction");
        
        session.beginTransaction();
        
        log.debug("executeNativeQuery [3]: query");
        
        return session.createNativeQuery(query);
        
    }
    
    /**
     * Метод возвращает список таблиц в базе данных
     * @return лист списка баз данных
     */
    public List<String> getListTitleTables(){
        log.debug("getListTitleTables [1]: get title tables in data base");
        return executeNativeQuery(Constants.HIBERNATE_QUERY_LAB1_GET_TITLE_TABLES).list();
    }
    
    /**
     * Метод возвращает имена пользователей в базе данных
     * @return 
     */
    public List<String> getUsenameUser(){
        log.debug("getUsenameUser [1]: get title users in data base");
        return executeNativeQuery(Constants.HIBERNATE_QUERY_LAB1_GET_TITLE_USERS).list();
    }
    
}
