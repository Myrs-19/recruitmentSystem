package ru.sfedu.api;

import java.io.File;
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
    
    //путь до пользовательского конфига
    private static String pathConfig;
    
    //конфигурация hibernate
    private static Configuration configuration;
    
    /**
     * метод создание фабрики
     *  @return SessionFactory возвращает созданную фабрику
     */
    public static SessionFactory getSessionFactory() {
        log.debug("getSessionFactory [1]: getting session factory");
        
        if (sessionFactory == null || sessionFactory.isClosed()) {            
            log.debug("getSessionFactory [2]: load config file (default directory)");
            
            try{
                // loads configuration and mappings
                loadConfiguration();

                log.debug("getSessionFactory [3]: get ServiceRegistry");

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties()).build();

                log.debug("getSessionFactory [4]: get MetadataSources");

                MetadataSources metadataSources = new MetadataSources(serviceRegistry);
                //metadataSources.addAnnotatedClass(TestEntity.class);// Аннотированная сущность

                //log.debug("getSessionFactory [5]: metadataSources.addResource");

                //metadataSources.addResource("named-queries.hbm.xml");// Именованные запросы

                log.debug("getSessionFactory [5]: final getting session factory");

                sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
            
            } catch(HibernateException ex){
                log.error("getSessionFactory [6]: error = {}", ex.getMessage());
            }
        }
        
        return sessionFactory;
    }

    public static String getPathConfig() {
        return pathConfig;
    }

    public static void setPathConfig(String pathConfig) {
        HibernateUtil.pathConfig = pathConfig;
    }
    
    /**
     * Метод загружает конфигурацию hibernate
     */
    private static void loadConfiguration(){
        log.debug("loadConfiguration [1]: load configuration");
        System.out.println("--------------------------------" + pathConfig + "--------------------------" + (pathConfig != null));
        
        if (pathConfig != null) {
            log.debug("loadConfiguration [2]: custom configuration file");

            File file = new File(pathConfig);
            configuration = new Configuration().configure(file);
        } else {
            log.debug("loadConfiguration [3]: default configuration file");

            configuration = new Configuration().configure();
        }
    }
    
    
}

