package ru.sfedu.lab1.api;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HibernateDataProviderTest {

    private static final Logger log = LogManager.getLogger(HibernateDataProviderTest.class.getName());
    
    /**
     * тест проверяет успешность открытия сессии
     * 
     * Тип: позитивный
     */
    @Test
    public void testGetSession() {
        log.debug("testGetSession [1]: test get session");
        
        Session session = HibernateDataProvider.getSession();
        
        log.debug("testGetSession [2]: close opened session");
        
        session.close();
    }
    
    /**
     * тест проверяет возвращает ли метод список названий таблиц в базе данных
     * 
     * Тип: позитивный
     */
    @Test
    public void testGetListTitleTables() {
        log.debug("testGetListTitleTables [1]: test get list of tables");
        
        HibernateDataProvider hdp = new HibernateDataProvider();
        
        log.debug("testGetListTitleTables [2]: get result");
        
        try{
            hdp.getListTitleTables().forEach(System.out::println);
        } catch(Exception ex){
            log.error("testGetListTitleTables [3]: error = {}", ex.getMessage());
            fail("incorrect sql or hibernate configuration");
        }
    }
    
    /**
     * тест проверяет возвращает ли метод список имен пользователей в базе данных
     * 
     * Тип: позитивный
     */
    @Test
    public void testGetUsenameUser() {
        log.debug("testGetUsenameUser [1]: test get list of users usename");
        
        HibernateDataProvider hdp = new HibernateDataProvider();
        
        log.debug("testGetUsenameUser [2]: get result");
        
        try{
            hdp.getListUsenameUser().forEach(System.out::println);
        } catch(Exception ex){
            log.error("testGetUsenameUser [3]: error = {}", ex.getMessage());
            fail("incorrect sql or hibernate configuration");
        }
    }
    
    /**
     * тест проверяет возвращает ли метод список имен пространства имен в базе данных
     * 
     * Тип: позитивный
     */
    @Test
    public void testGetListTitleNamespaces() {
        log.debug("testGetListTitleNamespaces [1]: test get list of data base namespaces ");
        
        HibernateDataProvider hdp = new HibernateDataProvider();
        
        log.debug("testGetListTitleNamespaces [2]: get result");
        
        try{
            hdp.getListTitleNamespaces().forEach(System.out::println);
        } catch(Exception ex){
            log.error("testGetListTitleNamespaces [3]: error = {}", ex.getMessage());
            fail("incorrect sql or hibernate configuration");
        }
    }
    
    /**
     * тест проверяет возвращает ли метод список имен типов в базе данных
     * 
     * Тип: позитивный
     */
    @Test
    public void testGetListTitleTypes() {
        log.debug("testGetListTitleTypes [1]: test get list of types name in data base");
        
        HibernateDataProvider hdp = new HibernateDataProvider();
        
        log.debug("testGetListTitleTypes [2]: get result");
        
        try{
            hdp.getListTitleTypes().forEach(System.out::println);
        } catch(Exception ex){
            log.error("testGetListTitleTypes [3]: error = {}", ex.getMessage());
            fail("incorrect sql or hibernate configuration");
        }
    }
    
    
}
