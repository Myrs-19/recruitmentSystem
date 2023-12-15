package ru.sfedu;

import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;

public class Constants {  
    public static final String XML_PATH_FOLDER = "ru.sfedu.xml.folder";
    public static final String XML_FILE_TYPE = ".xml";
    
    public static final String TITLE_TABLE_PERSON = "Person";
    public static final String TITLE_TABLE_CLIENT = "Client";
    public static final String TITLE_TABLE_EMPLOYEE = "Employee";
    public static final String TITLE_TABLE_RESUME = "Resume";
    public static final String TITLE_TABLE_VACANCY = "Vacancy";
    public static final String TITLE_TABLE_COMPANY = "Company";
    public static final String TITLE_TABLE_SEPARATE_QUAL = "SeparateQual";
    
    public static final String FIRST_ID = "0";
    
    public static final String CSV_PATH_FOLDER = "ru.sfedu.csv.folder";
    public static final String CSV_FILE_TYPE = ".csv";
    public static final char CSV_DEFAULT_SEPARATOR = ',';
    
    public static final String DEFAULT_CONFIG_PATH_PROP = "environment.properties";
    public static final String DEFAULT_CONFIG_PATH_XML = "environment.xml";
    public static final String DEFAULT_CONFIG_PATH_YAML = "environment.yml";
    
    public static final String MONGO_DB_NAME = "ru.sfedu.mongo.db.name";
    public static final String MONGO_HOST = "ru.sfedu.mongo.host";
    public static final String MONGO_PORT = "ru.sfedu.mongo.port";
    public static final String MONGO_URI = "mongodb://" + getConfigurationEntry(MONGO_HOST) + ":" + getConfigurationEntry(MONGO_PORT); 
    
    public static final String MONGO_FIELD_TIME = "time";
    public static final String MONGO_FIELD_COMMAND = "command";
    public static final String MONGO_FIELD_REPOSITORY = "repository";
    public static final String MONGO_FIELD_OBJECT = "obj";
    
    public static final int CODE_SUCCESS = 200;
    public static final String MESSAGE_CODE_SUCCESS = "OK";
    public static final int CODE_ERROR = 422;
}



































