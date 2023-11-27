package ru.sfedu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.List;
import java.util.Map;
import ru.sfedu.util.ConfigurationUtilProperties;
import ru.sfedu.util.ConfigurationUtilYaml;
import ru.sfedu.util.ConfigurationUtilXml;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import static ru.sfedu.api.MongoProvider.save;
import ru.sfedu.model.Person;

public class Main {
    
    public static void main(String[] args) throws JsonProcessingException {
        
//        log.info("test info level");
//        
//        String address = ConfigurationUtilProperties.getConfigurationEntry("address");
//        log.info("get from properties address: " + address);
//        
//        address = ConfigurationUtilYaml.getConfigurationEntry("address");
//        log.info("get from yaml address: " + address);
//        
//        address = ConfigurationUtilXml.getConfigurationEntry("address");
//        log.info("get from xml address: " + address);
//      
//        //LIST
//        List<String> l = ConfigurationUtilProperties.getConfigurationEntryList("planet");
//        log.info("is list empty: " + l.isEmpty());
//        l.forEach((s) -> log.info("from prop: value = " + s));
//        
//        l = ConfigurationUtilXml.getConfigurationEntryList("planet");
//        log.info("is list empty: " + l.isEmpty());
//        l.forEach((s) -> log.info("from xml: value = " + s));
//        
//        l = ConfigurationUtilYaml.getConfigurationEntryList("planets");
//        log.info("is list empty: " + l.isEmpty());
//        l.forEach((s) -> log.info("from yaml: value = " + s));
//        //LIST
//        
//        //MAP
//        Map<Integer, String> map = ConfigurationUtilProperties.getConfigurationEntryMap("months");
//        map.entrySet().forEach( (el) -> log.info(el.getKey() + " : " + el.getValue()) );
        //MAP
        
    } 
    
    private static final Logger log = LogManager.getLogger(Main.class.getName());
    
    public Main(){
        
        log.debug("Lab2Client[0]: starting application.........");
        
    }
    
    /*
        вторая лабораторка по архитектурке
    */
    private void logBasicSystemInfo() {
        
        log.info("Launching the application...");
        log.info(
        "Operating System: " + System.getProperty("os.name") + " "
        + System.getProperty("os.version")
        );
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");
        
    }
    
}
