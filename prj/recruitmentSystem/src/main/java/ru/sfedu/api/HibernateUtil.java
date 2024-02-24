package ru.sfedu.api;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    private static final Logger log = LogManager.getLogger(HibernateUtil.class.getName());
    /**
     * Создание фабрики
     *
     */
    public static SessionFactory getSessionFactory() {
        log.debug("getSessionFactory [1]: getting session factory");
        
        if (sessionFactory == null) {            
            log.debug("getSessionFactory [2]: load config file (default directory)");
            
            try{
                // loads configuration and mappings
                Configuration configuration = new Configuration().configure();

                log.debug("getSessionFactory [3]: get ServiceRegistry");

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties()).build();

                log.debug("getSessionFactory [4]: get MetadataSources");

                MetadataSources metadataSources = new MetadataSources(serviceRegistry);
                //metadataSources.addAnnotatedClass(TestEntity.class);// Аннотированная сущность

                log.debug("getSessionFactory [5]: metadataSources.addResource");

                metadataSources.addResource("named-queries.hbm.xml");// Именованные запросы

                log.debug("getSessionFactory [6]: final getting session factory");

                sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
            
            } catch(HibernateException ex){
                log.error("getSessionFactory [7]: error = {}", ex);
            }
        }
        
        return sessionFactory;
    }
}

