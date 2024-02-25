package ru.sfedu.lab1.api;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HibernateDataProviderTest {

    private static final Logger log = LogManager.getLogger(HibernateDataProviderTest.class.getName());
    
    @Test
    public void testGetSession() {
        log.debug("testGetSession [1]: test get session");
        
        Session session = HibernateDataProvider.getSession();
        
        log.debug("testGetSession [2]: close opened session");
        
        session.close();
    }
    
}
