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
    
    @Test
    public void testHireEmployeeCSVPositive(){
        System.out.println("test HireEmployeeCSV Positive");
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
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
        
        Result result = dp.saveVacancy(vacancy);
        
        LogicService service = new LogicService(dp);
        service.hireEmployee(1, 1);
        
        dp.getAllEmployees().forEach(System.out::println);
        
        deleteCSV();
    }
    
    @Test
    public void testHireEmployeeXML(){
        
    }
    
    @Test
    public void testHireEmployeeH2(){
        
    }
    
}
