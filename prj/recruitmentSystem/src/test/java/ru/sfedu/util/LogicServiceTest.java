/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sfedu.Constants;

import ru.sfedu.api.DataProviderCsv;
import ru.sfedu.api.DataProviderH2;
import ru.sfedu.api.DataProviderXml;
import ru.sfedu.api.IDataProvider;

import ru.sfedu.model.*;

/**
 *
 * @author mike
 */
public class LogicServiceTest {
    
    public LogicServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    public static void deleteCSV() {
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_CLIENT).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_COMPANY).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_EMPLOYEE).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_RESUME).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_SEPARATE_QUAL).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_VACANCY).concat(Constants.CSV_FILE_TYPE));
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)));
        
    }
    
    
    public static void deleteH2() {
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)).concat(Constants.H2_DB_NAME).concat(".trace.db"));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)).concat(Constants.H2_DB_NAME).concat(".mv.db"));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)));
    }
    
    public static void deleteXML() {
            
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_CLIENT).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_COMPANY).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_EMPLOYEE).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_RESUME).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_SEPARATE_QUAL).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_VACANCY).concat(Constants.XML_FILE_TYPE));
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)));
        
    }
    
    @Test
    public void testHireEmployeePositiveAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test HireEmployeePositive CSV");
        testHireEmployeePositive(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test HireEmployeePositive H2");
        testHireEmployeePositive(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test HireEmployeePositive XML");
        testHireEmployeePositive(dp);
        deleteXML();
    }
    
    @Test
    public void testHireEmployeeNegativeAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test HireEmployeeNegative CSV");
        testHireEmployeeNegative(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test HireEmployeeNegative H2");
        testHireEmployeeNegative(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test HireEmployeeNegative XML");
        testHireEmployeeNegative(dp);
        deleteXML();
    }
    
    public void testHireEmployeePositive(IDataProvider dp){
        System.out.println("test HireEmployeeCSV Positive");
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        Company company = new Company();
        
        company.setTitle("ArenaData");
        company.setDescription("DataBases company");
        
        dp.saveCompany(company);
        
        Client client = new Client();
        
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("Mike");
        client.setSurname("Seleznev");
        client.setAge(33);
        
        client.setPassword("998989898");
        client.setAddress("zorge 28/2");
        
        dp.savePerson(client);
        
        Resume resume = new Resume();
        
        resume.setClientId(1);
        resume.setCity("rostov");
        resume.setProfession("developer");
        
        dp.saveResume(resume);
        
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompanyId(1);
        vacancy.setTitle("java");
        vacancy.setSalary(150000);
        
        dp.saveVacancy(vacancy);
        
        LogicService service = new LogicService(dp);
        service.hireEmployee(1, 1);
        
        dp.getAllEmployees().forEach(System.out::println);
        
    }
    
    @Test
    public void testHireEmployeeNegative(IDataProvider dp){
        System.out.println("test HireEmployeeCSV Negative");
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        LogicService service = new LogicService(dp);
        service.hireEmployee(1, 1);
        
    }
    
    @Test
    public void testHireEmployeeXML(){
        
    }
    
    @Test
    public void testHireEmployeeH2(){
        
    }
    
}
