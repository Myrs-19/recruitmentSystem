/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu;

import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;
/**
 *
 * @author mike
 */
public class Constants {
    public static final String PREFIX_SETTER_METHOD = "set";
    public static final String NAME_METHOD_GETTING_ID = "getId";
    
    
    public static final String CSV_FILE_TYPE = ".csv";
    public static final char CSV_DEFAULT_SEPARATOR = ',';
    
    public static final String DEFAULT_CONFIG_PATH_PROP = "environment.properties";
    public static final String DEFAULT_CONFIG_PATH_XML = "environment.xml";
    public static final String DEFAULT_CONFIG_PATH_YAML = "environment.yml";
    
    public static final String MONGO_DB_NAME = "ru.sfedu.mongo.db.name";
    public static final String MONGO_HOST = "ru.sfedu.mongo.host";
    public static final String MONGO_PORT = "ru.sfedu.mongo.port";
    public static final String MONGO_URI = "mongodb://" + getConfigurationEntry(MONGO_HOST) + ":" + getConfigurationEntry(MONGO_PORT); 
    
}


































