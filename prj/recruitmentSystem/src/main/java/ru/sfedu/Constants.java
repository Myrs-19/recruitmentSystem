package ru.sfedu;

import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;

public class Constants {  
    public static final String XML_PATH_FOLDER = "ru.sfedu.xml.folder";
    public static final String XML_FILE_TYPE = ".xml";
    
    public static final String TITLE_TABLE_CLIENT = "client";
    public static final String TITLE_TABLE_EMPLOYEE = "employee";
    public static final String TITLE_TABLE_RESUME = "resume";
    public static final String TITLE_TABLE_VACANCY = "vacancy";
    public static final String TITLE_TABLE_COMPANY = "company";
    public static final String TITLE_TABLE_SEPARATE_QUAL = "separateQual";
    
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
    
    public static final String COMPLETED_SUCCESSFUL = "SUCCESSFUL";
    public static final String COMPLETED_FAIL = "FAIL";
    public static final String DEFAULT_ACTOR = "system";
    
    public static final String H2_CONNECTOR = "ru.sfedu.h2.connector";
    public static final String H2_DB_NAME = "recruitmentSystem";
    public static final String H2_PREFIX_PATH = "./";
    public static final String H2_PATH = "ru.sfedu.h2.folder";
    
    public static final String H2_QUERY_CREATE_CLIENT = "CREATE TABLE IF NOT EXISTS ".concat(TITLE_TABLE_CLIENT)
            .concat("(")
            .concat("id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, ")
            .concat("name VARCHAR(32) NOT NULL, ")
            .concat("surname VARCHAR(32) NOT NULL, ")
            .concat("middleName VARCHAR(32), ")
            .concat("age INTEGER NOT NULL, ")
            .concat("birthday DATE, ")
            .concat("phone VARCHAR(11), ")
            .concat("email varchar(128), ")
            .concat("password varchar(128) NOT NULL, ")
            .concat("address varchar(128) NOT NULL")
            .concat(");");
    
    public static final String H2_QUERY_CREATE_EMPLOYEE = "CREATE TABLE IF NOT EXISTS ".concat(TITLE_TABLE_CLIENT)
            .concat("(")
            .concat("id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, ")
            .concat("name VARCHAR(32) NOT NULL, ")
            .concat("surname VARCHAR(32) NOT NULL, ")
            .concat("middleName VARCHAR(32), ")
            .concat("age INTEGER NOT NULL, ")
            .concat("birthday DATE, ")
            .concat("phone VARCHAR(11), ")
            .concat("email varchar(128), ")
            .concat("companyId INTEGER NOT NULL REFERENCES ").concat(TITLE_TABLE_COMPANY).concat("(id) ON DELETE CASCADE ON UPDATE CASCADE, ")
            .concat("startWorkDate DATE NOT NULL, ")
            .concat("salary INTEGER NOT NULL, ")
            .concat("position varchar(256) NOT NULL, ")
            .concat("isWorking BOOLEAN NOT NULL")
            .concat(");");
    
    public static final String H2_QUERY_CREATE_RESUME = "CREATE TABLE IF NOT EXISTS ".concat(TITLE_TABLE_RESUME)
            .concat("(")
            .concat("id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, ")
            .concat("clientId INTEGER NOT NULL REFERENCES ").concat(TITLE_TABLE_CLIENT).concat("(id) ON DELETE CASCADE ON UPDATE CASCADE, ")
            .concat("profession VARCHAR(128) NOT NULL, ")
            .concat("city VARCHAR(64) NOT NULL, ")
            .concat("skills VARCHAR(256), ")
            .concat("education VARCHAR(256), ")
            .concat("experience VARCHAR(256), ")
            .concat("sex ENUM(" + "\'MAN\', " + "\'WOMAN\'), ")
            .concat("workPermit BOOLEAN, ")
            .concat("citizenship VARCHAR(32)")
            .concat(");");
    
    public static final String H2_QUERY_CREATE_COMPANY = "CREATE TABLE IF NOT EXISTS ".concat(TITLE_TABLE_COMPANY)
            .concat("(")
            .concat("id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, ")
            .concat("title VARCHAR(32) NOT NULL, ")
            .concat("description VARCHAR(256) NOT NULL")
            .concat(");");
    
    public static final String H2_QUERY_CREATE_VACANCY = "CREATE TABLE IF NOT EXISTS ".concat(TITLE_TABLE_VACANCY)
            .concat("(")
            .concat("id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, ")
            .concat("companyId INTEGER NOT NULL REFERENCES ").concat(TITLE_TABLE_COMPANY).concat("(id) ON DELETE CASCADE ON UPDATE CASCADE, ")
            .concat("title VARCHAR(64) NOT NULL, ")
            .concat("specialization VARCHAR(64), ")
            .concat("online BOOLEAN, ")
            .concat("skills VARCHAR(256), ")
            .concat("salary INTEGER NOT NULL, ")
            .concat("city VARCHAR(64), ")
            .concat("address VARCHAR(128), ")
            .concat("experience VARCHAR(256)")
            .concat(");");
    
    public static final String H2_QUERY_CREATE_SEPARATE_QUAL = "CREATE TABLE IF NOT EXISTS ".concat(TITLE_TABLE_SEPARATE_QUAL)
            .concat("(")
            .concat("id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, ")
            .concat("companyId INTEGER NOT NULL REFERENCES ").concat(TITLE_TABLE_COMPANY).concat("(id) ON DELETE CASCADE ON UPDATE CASCADE, ")
            .concat("employeeId INTEGER NOT NULL REFERENCES ").concat(TITLE_TABLE_COMPANY).concat("(id) ON DELETE NO ACTION ON UPDATE NO ACTION, ")
            .concat("quality INTEGER NOT NULL, ")
            .concat("description VARCHAR(256)")
            .concat(");");
            
            
}



































