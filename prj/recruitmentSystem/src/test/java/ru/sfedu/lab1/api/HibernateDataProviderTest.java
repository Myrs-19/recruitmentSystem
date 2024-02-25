package ru.sfedu.lab1.api;

import java.util.List;
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
        log.debug("testGetListTitleTables [1]: test get list of data bases");
        
        HibernateDataProvider hdp = new HibernateDataProvider();
        
        log.debug("testGetListTitleTables [2]: get result");
        
        hdp.getListTitleTables().forEach(System.out::println);
    }
    
    /**
     * тест проверяет возвращает ли метод список имен пользователей в базе данных
     * 
     * Тип: позитивный
     */
    @Test
    public void testGetUsenameUser() {
        log.debug("testGetUsenameUser [1]: test get list of data bases");
        
        HibernateDataProvider hdp = new HibernateDataProvider();
        
        log.debug("testGetUsenameUser [2]: get result");
        
        hdp.getUsenameUser().forEach(System.out::println);
    }
}
