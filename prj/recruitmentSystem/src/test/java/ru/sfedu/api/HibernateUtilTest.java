package ru.sfedu.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.sfedu.lab1.api.HibernateDataProviderTest;


public class HibernateUtilTest {
    private static final Logger log = LogManager.getLogger(HibernateUtilTest.class.getName());
    
    public HibernateUtilTest() {
    }

    /**
     * инициализация фабрики сессий и 
     * создание и открытие сессии, 
     * после закрытие сессии
     * 
     * Тип: Позитивный
     */
    @Test
    public void testGetSessionFactory() {
        log.debug("testGetSessionFactory [1]: get instance session factory");
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        log.debug("testGetSessionFactory [2]: open session");
        
        Session session = sessionFactory.openSession();
        
        log.debug("testGetSessionFactory [3]: close session factory");
        
        sessionFactory.close();
    }
    
    /**
     * Метод тестирует открытие и использование 
     * пользовательского файла конфигурации hibernate
     * 
     * Тип: Позитивный
     */
    @Test
    public void testUsingCustomConfigurationFile() {
        log.debug("testUsingCustomConfigurationFile [1]: load custom configuration hibernate file");
        
        String path = "/home/mike/study/hibernate.cfg.xml";
        
        log.debug("testUsingCustomConfigurationFile [2]: set path to configuration file");
        
        HibernateUtil.setPathConfig(path);
        
        log.debug("testUsingCustomConfigurationFile [3]: run test methods for HibernateDataProvider");
        
        HibernateDataProviderTest hibernateDataProviderTest = new HibernateDataProviderTest();
        
        log.debug("testUsingCustomConfigurationFile [4]: run testGetListTitleNamespaces");
        
        hibernateDataProviderTest.testGetListTitleNamespaces();
        
        log.debug("testUsingCustomConfigurationFile [5]: run testGetListTitleTables");
        
        hibernateDataProviderTest.testGetListTitleTables();
        
        log.debug("testUsingCustomConfigurationFile [6]: run testGetListTitleTypes");
        
        hibernateDataProviderTest.testGetListTitleTypes();
        
        log.debug("testUsingCustomConfigurationFile [7]: run testGetListUsenameUser");
        
        hibernateDataProviderTest.testGetListUsenameUser();
        
    }
    
    
    
}
