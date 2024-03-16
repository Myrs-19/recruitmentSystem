package ru.sfedu.lab2.api;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import org.hibernate.HibernateException;

import ru.sfedu.Constants;
import ru.sfedu.lab1.util.HibernateUtil;

/**
 * Открывается одна сессия для всех запросов  
 * @author mike
 */
public class HibernateDataProvider {
    
    private static final Logger log = LogManager.getLogger(HibernateDataProvider.class.getName());
    
    //Открытая сессия для запросов (Потоко безопасно делать общую сессию на все методы для запросов?)
    private static Session session;
    
    /**
     * Метод открывает и возвращает созданную сессию
     * @return открытая сессия
     * @throws HibernateException incorrect hibernate configuration
     */
    public static Session getSession() throws HibernateException{
        log.debug("getSession [1]: get session factory");
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        log.debug("getSession [2]: open and return session");
        
        return sessionFactory.openSession();
    }
    
    /**
     * Метод выполняет нативный sql запрос
     * @param query - запрос на выполнение
     * @return возвращает запрос
     * @throws Exception ошибка при невалидном sql запросе или ошибка конфигурации hibernate
     */
    public static NativeQuery executeNativeQuery(String query) throws Exception{
        log.debug("executeNativeQuery [1]: get session");
        
        if(session == null){
            session = getSession();
        }
        
        //transaction already active
//        log.debug("executeNativeQuery [2]: begin transaction");
        
//        session.beginTransaction();
        
        log.debug("executeNativeQuery [3]: query");
        
        NativeQuery nativeQuery = session.createNativeQuery(query);
        
        log.debug("executeNativeQuery [3]: close session");
        
//        session.close();
        
        return nativeQuery;
    }
    
    /**
     * Метод возвращает список таблиц в базе данных
     * @return лист списка баз данных
     * @throws Exception See also {@link HibernateDataProvider#executeNativeQuery(String)}.
     */
    public List<String> getListTitleTables() throws Exception{
        log.debug("getListTitleTables [1]: get title tables in data base");
        return executeNativeQuery(Constants.HIBERNATE_QUERY_LAB1_GET_TITLE_TABLES).list();
    }
    
    /**
     * Метод возвращает имена пользователей в базе данных
     * @return список пользователей базы данных
     * @throws Exception See also {@link HibernateDataProvider#executeNativeQuery(String)}.
     */
    public List<String> getListUsenameUser() throws Exception{
        log.debug("getUsenameUser [1]: get title users in data base");
        return executeNativeQuery(Constants.HIBERNATE_QUERY_LAB1_GET_TITLE_USERS).list();
    }
    
    /**
     * Метод возвращает названия имен пространств
     * @return список пространства имен базы данных
     * @throws Exception See also {@link HibernateDataProvider#executeNativeQuery(String)}.
     */
    public List<String> getListTitleNamespaces() throws Exception{
        log.debug("getListTitleNamespaces [1]: get title namespaces in database");
        return executeNativeQuery(Constants.HIBERNATE_QUERY_LAB1_GET_TITLE_NAMESPACES).list();
    }
    
    /**
     * Метод возвращает названия типов данных в базе
     * @return список имен типов базы данных
     * @throws Exception See also {@link HibernateDataProvider#executeNativeQuery(String)}.
     */
    public List<String> getListTitleTypes() throws Exception{
        log.debug("getListTitleTypes [1]: get title types in database");
        return executeNativeQuery(Constants.HIBERNATE_QUERY_LAB1_GET_TITLE_TYPES).list();
    }
}
