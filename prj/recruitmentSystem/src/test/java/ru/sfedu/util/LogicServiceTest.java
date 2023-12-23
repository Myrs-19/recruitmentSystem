/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.util;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
        
        try{
            List<Employee> list = dp.getAllEmployees(); 
            if(list.isEmpty()){
                fail("the test failed");
            }
            list.forEach(System.out::println);
            
        } catch(NullPointerException ex){
            fail("the test failed");
        }
        
    }
    
    public void testHireEmployeeNegative(IDataProvider dp){
        System.out.println("test HireEmployeeCSV Negative");
        
        LogicService service = new LogicService(dp);
        service.hireEmployee(1, 1);
        
        try{
            
            List<Employee> list = dp.getAllEmployees(); 
            if(!list.isEmpty()){
                fail("the test failed");
            }
            
        } catch(NullPointerException ex){
            assertEquals(Constants.MESSAGE_EXCEPTION_DONT_RECORDS, ex.getMessage());
        }
    }
    
    @Test
    public void testGiveAssessmentPositiveAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test GiveAssessmentPositive CSV");
        testGiveAssessmentPositive(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test GiveAssessmentPositive H2");
        testGiveAssessmentPositive(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test GiveAssessmentPositive XML");
        testGiveAssessmentPositive(dp);
        deleteXML();
    }
    
    @Test
    public void testGiveAssessmentNegativeAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test GiveAssessmentNegative CSV");
        testGiveAssessmentNegative(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test GiveAssessmentNegative H2");
        testGiveAssessmentNegative(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test GiveAssessmentNegative XML");
        testGiveAssessmentNegative(dp);
        deleteXML();
    }
    
    public void testGiveAssessmentPositive(IDataProvider dp){
        System.out.println("test GiveAssessment Positive");
        
        Company company = new Company();
        
        company.setTitle("ArenaData");
        company.setDescription("DataBases company");
        
        dp.saveCompany(company);
        
        Employee employee = new Employee();
        
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("Никита");
        employee.setSurname("Парамонов");
        employee.setAge(22);
        
        employee.setCompanyId(1);
        employee.setSalary(23000);
        employee.setIsWorking(false);
        employee.setPosition("middle");
        
        dp.savePerson(employee);
        
        int idEmployee = 1;
        int idCompany = 1;
        int quality = 10;
        String description = null;
        
        LogicService service = new LogicService(dp);
        service.giveAssessment(idEmployee, idCompany, quality, description);
        
        try{
            List<SeparateQual> list = dp.getAllSeparateQuals(); 
            if(list.isEmpty()){
                fail("the test failed");
            }
            
            list.forEach(System.out::println);
            
        } catch(NullPointerException ex){
            fail("the test failed");
        }
    }
    
    public void testGiveAssessmentNegative(IDataProvider dp){
        System.out.println("test GiveAssessment Negative");
       
        int idEmployee = 1;
        int idCompany = 1;
        int quality = 10;
        String description = null;
        
        LogicService service = new LogicService(dp);
        service.giveAssessment(idEmployee, idCompany, quality, description);
        
        try{
            dp.getAllSeparateQuals().forEach(System.out::println);
            
            List<SeparateQual> list = dp.getAllSeparateQuals(); 
            if(!list.isEmpty()){
                fail("the test failed");
            }
            
        } catch(NullPointerException ex){
            assertEquals(Constants.MESSAGE_EXCEPTION_DONT_RECORDS, ex.getMessage());
        }
    }
    
    @Test
    public void testClientRegistrationPositiveAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ClientRegistrationPositive CSV");
        testClientRegistrationPositive(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ClientRegistrationPositive H2");
        testClientRegistrationPositive(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ClientRegistrationPositive XML");
        testClientRegistrationPositive(dp);
        deleteXML();
    }
    
    public void testClientRegistrationPositive(IDataProvider dp){
        System.out.println("test ClientRegistration Positive");
        
        String name = "Mik";
        String surname = "Sel";
        String middleName = "Mih";
        int age = 21;
        String birthday = "12-06-2003";
        String phone = "8999999999";
        String email = "myrs@lab.com";
        String password = "pipipip";
        String address = "zorge 28/2";
        
        try{
            LogicService service = new LogicService(dp);
            service.clientRegistration(name, surname, middleName, age, birthday, phone, email, password, address);
            
            dp.getAllClients().forEach(System.out::println);
        } catch(Exception ex){
            fail(ex.getMessage());
        }
        
    }
    
    @Test
    public void testClientRegistrationNegativeAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ClientRegistrationNegative CSV");
        testClientRegistrationNegative(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ClientRegistrationNegative H2");
        testClientRegistrationNegative(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ClientRegistrationNegative XML");
        testClientRegistrationNegative(dp);
        deleteXML();
    }
    
    public void testClientRegistrationNegative(IDataProvider dp){
        System.out.println("test ClientRegistration Negative");
        
        String name = null;
        String surname = "Sel";
        String middleName = "Mih";
        int age = 21;
        String birthday = "12-06-2003";
        String phone = "8999999999";
        String email = "myrs@lab.com";
        String password = "pipipip";
        String address = "zorge 28/2";
        
        try{
            LogicService service = new LogicService(dp);
            service.clientRegistration(name, surname, middleName, age, birthday, phone, email, password, address);
        
            fail("the test failed");
        } catch(Exception ex){
            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
        }
    }
    
    @Test
    public void testCompanyRegistrationPositiveAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test CompanyRegistrationPositive CSV");
        testCompanyRegistrationPositive(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test CompanyRegistrationPositive H2");
        testCompanyRegistrationPositive(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test CompanyRegistrationPositive XML");
        testCompanyRegistrationPositive(dp);
        deleteXML();
    }
    
    public void testCompanyRegistrationPositive(IDataProvider dp){
        System.out.println("test CompanyRegistration Positive");
        
        String title = "ArenaTitle";
        String description = "Data bases company";
        
        try{
            LogicService service = new LogicService(dp);
            service.companyRegistration(title, description);
        
            dp.getAllCompanies().forEach(System.out::println);
        } catch(Exception ex){
            fail("the test failed");
        }
    }
    
    @Test
    public void testCompanyRegistrationNegativeAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test CompanyRegistrationNegative CSV");
        testCompanyRegistrationNegative(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test CompanyRegistrationNegative H2");
        testCompanyRegistrationNegative(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test CompanyRegistrationNegative XML");
        testCompanyRegistrationNegative(dp);
        deleteXML();
    }
    
    public void testCompanyRegistrationNegative(IDataProvider dp){
        System.out.println("test CompanyRegistration Positive");
        
        String title = null;
        String description = "Data bases company";
        
        try{
            LogicService service = new LogicService(dp);
            service.companyRegistration(title, description);
        
            fail("the test failed");
        } catch(Exception ex){
            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
        }
    }
    
    @Test
    public void testResumeRegistrationPositiveAllDP(){
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistration Positive CSV");
        testResumeRegistrationPositive(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistration Positive H2");
        testResumeRegistrationPositive(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistration Positive XML");
        testResumeRegistrationPositive(dp);
        deleteXML();
    }
    
    public void testResumeRegistrationPositive(IDataProvider dp){
        System.out.println("test ResumeRegistration Positive");
        
        int idClient = 1;
        String profession = "developer";
        String city = "rostov";
        String skills = "skills";
        String education = "education";
        String experience = "experience";
        boolean sex = true;
        boolean workPermit = true;
        String citizenship = "Russian";
        
        //сохранение клиента до сохранения его резюме
        Client client = new Client();
        
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("Mike");
        client.setSurname("Seleznev");
        client.setAge(33);
        
        client.setPassword("998989898");
        client.setAddress("zorge 28/2");
        
        Result result = dp.savePerson(client);
        System.out.println(result);
        
        try{
            LogicService service = new LogicService(dp);
            service.resumeRegistration(idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
        
            dp.getAllResumes().forEach(System.out::println);
        } catch(Exception ex){
            fail("the test failed " + ex.getMessage());
        }
    }
    
    @Test
    public void testResumeRegistrationNegativeClientAllDP(){
        //проверка на ошибку, когда клиента с таким ID нет
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistrationClient Negative CSV");
        testResumeRegistrationNegativeClient(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistrationClient Negative H2");
        testResumeRegistrationNegativeClient(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistrationClient Negative XML");
        testResumeRegistrationNegativeClient(dp);
        deleteXML();
    }
    
    public void testResumeRegistrationNegativeClient(IDataProvider dp){
        System.out.println("test ResumeRegistrationClient Negative");
        
        //здесь сохранения клиента перед тестов не происходит поэтому всегда будет ошибка
        
        int idClient = 1;
        String profession = "developer";
        String city = "rostov";
        String skills = "skills";
        String education = "education";
        String experience = "experience";
        boolean sex = true;
        boolean workPermit = true;
        String citizenship = "Russian";
        
        try{
            LogicService service = new LogicService(dp);
            service.resumeRegistration(idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
        
            fail("the test failed");
        } catch(Exception ex){
            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
        }
    }
    
    @Test
    public void testResumeRegistrationNegativeDataAllDP(){
        //проверка на ошибку, когда клиента с таким ID нет
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistrationData Negative CSV");
        testResumeRegistrationNegativeData(dp);
        deleteCSV();
        
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistrationData Negative H2");
        testResumeRegistrationNegativeData(dp);
        deleteH2();
        
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        System.out.println("test ResumeRegistrationData Negative XML");
        testResumeRegistrationNegativeData(dp);
        deleteXML();
    }
    
    public void testResumeRegistrationNegativeData(IDataProvider dp){
        System.out.println("test ResumeRegistrationData Negative");
        
        //здесь проверка на ошибку когда невалидные данные
        
        int idClient = 1;
        String profession = null;
        String city = "rostov";
        String skills = "skills";
        String education = "education";
        String experience = "experience";
        boolean sex = true;
        boolean workPermit = true;
        String citizenship = "Russian";
        
         //сохранение клиента до сохранения его резюме
        Client client = new Client();
        
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("Mike");
        client.setSurname("Seleznev");
        client.setAge(33);
        
        client.setPassword("998989898");
        client.setAddress("zorge 28/2");
        
        Result result = dp.savePerson(client);
        System.out.println(result);
        
        try{
            LogicService service = new LogicService(dp);
            service.resumeRegistration(idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
        
            fail("the test failed");
        } catch(Exception ex){
            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
        }
    }
    
}
