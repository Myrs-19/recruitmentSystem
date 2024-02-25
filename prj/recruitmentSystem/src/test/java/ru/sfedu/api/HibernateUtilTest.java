/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mike
 */
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
        
        log.debug("testGetSessionFactory [3]: close session");
        
        sessionFactory.close();
    }
    
}
