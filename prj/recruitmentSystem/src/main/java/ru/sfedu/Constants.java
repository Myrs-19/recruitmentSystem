package ru.sfedu;

import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;

public class Constants {  
    public static final String PROP_MAIL = "mail.properties";
    public static final String USERNAME_MAIL = "miha.seleznv.98@gmail.com";
    public static final String PASSWORD_MAIL = "fcew qikt wuxm qvbr";
    public static final String SUBJECT_MAIL = "ВАС НАНЯЛИ!!!";
    public static final String TEXT_MESSAGE_HAIR_MAIL = "вы были наняты на позицию %s, с зарплатой %d";
    public static final String TEXT_MESSAGE_TEST_MAIL = "вы были наняты на позицию %s, с зарплатой %d, но вас просят пройти тест, свяжитесь с компанией по адресу: %s";
    
    
    public static final String XML_PATH_FOLDER = "ru.sfedu.xml.folder";
    public static final String XML_FILE_TYPE = ".xml";
    
    public static final String TITLE_TABLE_CLIENT = "client";
    public static final String TITLE_TABLE_EMPLOYEE = "employee";
    public static final String TITLE_TABLE_RESUME = "resume";
    public static final String TITLE_TABLE_VACANCY = "vacancy";
    public static final String TITLE_TABLE_COMPANY = "company";
    public static final String TITLE_TABLE_SEPARATE_QUAL = "separateQual";
    
    public static final int FIRST_ID = 1;
    
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
    
    public static final int CODE_ERROR = 422;
    
    public static final int CODE_WARN = 250;
    
    public static final String MESSAGE_CODE_SUCCESS = "OK";
    
    public static final String MESSAGE_CODE_WARN_UPDATE = "record has not changed";
    
    public static final String MESSAGE_CODE_WARN_DELETE = "record has not deleted";
    
    public static final String MESSAGE_EXCEPTION_DONT_RECORDS = "records such bean do not exists";
    
    public static final String MESSAGE_EXCEPTION_DOESNT_VALID_DATA = "data does not valid";
    
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
            .concat("birthday VARCHAR(16), ")
            .concat("phone VARCHAR(11), ")
            .concat("email varchar(128), ")
            .concat("password varchar(128) NOT NULL, ")
            .concat("address varchar(128) NOT NULL")
            .concat(");");
    
    public static final String H2_QUERY_CREATE_EMPLOYEE = "CREATE TABLE IF NOT EXISTS ".concat(TITLE_TABLE_EMPLOYEE)
            .concat("(")
            .concat("id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, ")
            .concat("name VARCHAR(32) NOT NULL, ")
            .concat("surname VARCHAR(32) NOT NULL, ")
            .concat("middleName VARCHAR(32), ")
            .concat("age INTEGER NOT NULL, ")
            .concat("birthday VARCHAR(16), ")
            .concat("phone VARCHAR(11), ")
            .concat("email varchar(128), ")
            .concat("companyId INTEGER NOT NULL REFERENCES ").concat(TITLE_TABLE_COMPANY).concat("(id) ON DELETE CASCADE ON UPDATE CASCADE, ")
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
            .concat("sex BOOLEAN, ")
            .concat("workPermit BOOLEAN, ")
            .concat("citizenship VARCHAR(32)")
            .concat(");");
    
    public static final String H2_QUERY_CREATE_COMPANY = "CREATE TABLE IF NOT EXISTS ".concat(TITLE_TABLE_COMPANY)
            .concat("(")
            .concat("id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, ")
            .concat("title VARCHAR(32) NOT NULL, ")
            .concat("description VARCHAR(256)")
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
            .concat("quality INTEGER NOT NULL, ")
            .concat("description VARCHAR(256)")
            .concat(");");
    
    public static final String H2_QUERY_INSERT_CLIENT = String.format("INSERT INTO %s (name, surname, middleName, age, birthday, phone, email, password, address) ", TITLE_TABLE_CLIENT)
            .concat("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
    
    public static final String H2_QUERY_INSERT_EMPLOYEE = String.format("INSERT INTO %s (name, surname, middleName, age, birthday, phone, email, companyId, salary, position, isWorking) ", TITLE_TABLE_EMPLOYEE)
            .concat("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    
    public static final String H2_QUERY_INSERT_COMPANY = String.format("INSERT INTO %s (title, description) ", TITLE_TABLE_COMPANY)
            .concat("VALUES(?, ?)");
    
    public static final String H2_QUERY_INSERT_RESUME = String.format("INSERT INTO %s (clientId, profession, city, skills, education, experience, sex, workPermit, citizenship) ", TITLE_TABLE_RESUME)
            .concat("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
    
    public static final String H2_QUERY_INSERT_VACANCY = String.format("INSERT INTO %s (companyId, title, specialization, online, skills, salary, city, address, experience) ", TITLE_TABLE_VACANCY)
            .concat("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
    
    public static final String H2_QUERY_INSERT_SEPARATE_QUAL = String.format("INSERT INTO %s (companyId, quality, description) ", TITLE_TABLE_SEPARATE_QUAL)
            .concat("VALUES(?, ?, ?)");
    
    public static final String H2_QUERY_GET_RECORD_BY_ID = "SELECT * FROM %s WHERE id = %d";
    
    public static final String H2_QUERY_GET_ALL_RECORD = "SELECT * FROM %s";
    
    public static final String H2_QUERY_UPDATE_CLIENT = String.format("UPDATE %s SET name = ?, surname = ?, middleName = ?, age = ?, birthday = ?, phone = ?, email = ?, password = ?, address = ? ", TITLE_TABLE_CLIENT).concat(" WHERE id = %d");
    
    public static final String H2_QUERY_UPDATE_EMPLOYEE = String.format("UPDATE %s SET name = ?, surname = ?, middleName = ?, age = ?, birthday = ?, phone = ?, email = ?, companyId = ?, salary = ?, position = ?, isWorking = ? ", TITLE_TABLE_EMPLOYEE).concat(" WHERE id = %d");
    
    public static final String H2_QUERY_UPDATE_RESUME = String.format("UPDATE %s SET clientId = ?, profession = ?, city = ?, skills = ?, education = ?, experience = ?, sex = ?, workPermit = ?, citizenship = ? ", TITLE_TABLE_RESUME).concat(" WHERE id = %d");
    
    public static final String H2_QUERY_UPDATE_COMPANY = String.format("UPDATE %s SET title = ?, description = ? ", TITLE_TABLE_COMPANY).concat(" WHERE id = %d");
    
    public static final String H2_QUERY_UPDATE_VACANCY = String.format("UPDATE %s SET companyId = ?, title = ?, specialization = ?, online = ?, skills = ?, salary = ?, city = ?, address = ?, experience = ? ", TITLE_TABLE_VACANCY).concat(" WHERE id = %d");
    
    public static final String H2_QUERY_UPDATE_SEPARATE_QUAL = String.format("UPDATE %s SET companyId = ?, quality = ?, description = ? ", TITLE_TABLE_SEPARATE_QUAL).concat(" WHERE id = %d");
    
    public static final String H2_QUERY_DELETE_RECORD_BY_ID = "DELETE FROM %s WHERE id = %d";
            
    public static final String TEST_MAIN_FOLDER_PATH = "src/test/testFolder/testActualDataFolder/";

    public static final int MAX_QUALITY = 10;
    
    public static final int MIN_QUALITY = 0;
    
    public static final String PATH_RESULT = "ru.sfedu.calculate.result.folder";
    //%s - title company, %d - id company, %s - time
    public static final String NAME_FILE_RESULT = "%s_%d_%s";
    
    public static final String[] HEADER_RESULT = {"id", "title", "result"};
    
    //CLI
    public static final String CLI_CONFIG = "config";
    public static final String CLI_LOG4J = "log4j";
    
    public static final String CLI_XML = "XML";
    public static final String CLI_H2 = "H2";
    public static final String CLI_CSV = "CSV";
    
    public static final String CLI_REGISTRATION_CLIENT = "-client";
    public static final String CLI_CHANGE_CLIENT = "-clientChange";
    public static final String CLI_DELETE_CLIENT = "-clientD";
    
    public static final String CLI_REGISTRATION_RESUME = "-resume";
    public static final String CLI_CHANGE_RESUME = "-resumeChange";
    public static final String CLI_DELETE_RESUME = "-resumeD";
    
    public static final String CLI_REGISTRATION_COMPANY = "-company";
    public static final String CLI_CHANGE_COMPANY = "-companyChange";
    public static final String CLI_DELETE_COMPANY = "-companyD";
    
    public static final String CLI_REGISTRATION_VACANCY = "-vacancy";
    public static final String CLI_CHANGE_VACANCY = "-vacancyChange";
    public static final String CLI_DELETE_VACANCY = "-vacancyD";
    
    public static final String CLI_HIRE = "-hire";
    
    public static final String CLI_GIVE_ASSESSMENT = "-ga";
    public static final String CLI_DELETE_SEPARATE_QUAL = "-spD";
    
    public static final String CLI_CALCULATE_ASSESSMENT = "-ca";
    
    public static final String SEPARATOR_CSV_RECURSE = "#";

    public static final int DEFAULT_PLACE_COMPANY = 1;

    public static final String HIBERNATE_QUERY_LAB1_GET_TITLE_TABLES = "SELECT table_name FROM information_schema.tables WHERE table_schema='public';";
    public static final String HIBERNATE_QUERY_LAB1_GET_TITLE_USERS = "SELECT usename FROM pg_catalog.pg_user;";
    public static final String HIBERNATE_QUERY_LAB1_GET_TITLE_NAMESPACES = "SELECT nspname FROM pg_catalog.pg_namespace;";
    public static final String HIBERNATE_QUERY_LAB1_GET_TITLE_TYPES = "SELECT typname FROM pg_catalog.pg_type;";

    public static final String HIBERNATE_PATH_CONFIG_LAB3_STRAT1 = "src/main/resources/hibernate.cfg.lab3strat1.xml";
    public static final String HIBERNATE_PATH_CONFIG_LAB3_STRAT2 = "src/main/resources/hibernate.cfg.lab3strat2.xml";
    public static final String HIBERNATE_PATH_CONFIG_LAB3_STRAT3 = "src/main/resources/hibernate.cfg.lab3strat3.xml";
    public static final String HIBERNATE_PATH_CONFIG_LAB3_STRAT4 = "src/main/resources/hibernate.cfg.lab3strat4.xml";
    public static final String HIBERNATE_PATH_CONFIG_LAB4 = "src/main/resources/hibernate.cfg.lab4.xml";

    public static final String HIBERNATE_PATH_CONFIG_LAB4 = "src/main/resources/hibernate.cfg.lab4.xml";
}



































