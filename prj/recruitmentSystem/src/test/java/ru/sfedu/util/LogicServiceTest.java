///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package ru.sfedu.util;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import ru.sfedu.Constants;
//
//import ru.sfedu.api.DataProviderCsv;
//import ru.sfedu.api.DataProviderH2;
//import ru.sfedu.api.DataProviderXml;
//import ru.sfedu.api.IDataProvider;
//
//import ru.sfedu.model.*;
//
///**
// *
// * @author mike
// */
//public class LogicServiceTest {
//    
//    public LogicServiceTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//    
//    public static void deleteCSV() {
//        
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_CLIENT).concat(Constants.CSV_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_COMPANY).concat(Constants.CSV_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_EMPLOYEE).concat(Constants.CSV_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_RESUME).concat(Constants.CSV_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_SEPARATE_QUAL).concat(Constants.CSV_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_VACANCY).concat(Constants.CSV_FILE_TYPE));
//        
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)));
//        
//    }
//    
//    
//    public static void deleteH2() {
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)).concat(Constants.H2_DB_NAME).concat(".trace.db"));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)).concat(Constants.H2_DB_NAME).concat(".mv.db"));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)));
//    }
//    
//    public static void deleteXML() {
//            
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_CLIENT).concat(Constants.XML_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_COMPANY).concat(Constants.XML_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_EMPLOYEE).concat(Constants.XML_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_RESUME).concat(Constants.XML_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_SEPARATE_QUAL).concat(Constants.XML_FILE_TYPE));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_VACANCY).concat(Constants.XML_FILE_TYPE));
//        
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)));
//        
//    }
//    
//    @Test
//    public void testHireEmployeePositiveAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test HireEmployeePositive CSV");
//        testHireEmployeePositive(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test HireEmployeePositive H2");
//        testHireEmployeePositive(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test HireEmployeePositive XML");
//        testHireEmployeePositive(dp);
//        deleteXML();
//    }
//    
//    @Test
//    public void testHireEmployeeNegativeAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test HireEmployeeNegative CSV");
//        testHireEmployeeNegative(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test HireEmployeeNegative H2");
//        testHireEmployeeNegative(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test HireEmployeeNegative XML");
//        testHireEmployeeNegative(dp);
//        deleteXML();
//    }
//    
//    public void testHireEmployeePositive(IDataProvider dp){
//        System.out.println("test HireEmployeeCSV Positive");
//        
//        Company company = new Company();
//        
//        company.setTitle("ArenaData");
//        company.setDescription("DataBases company");
//        
//        dp.saveCompany(company);
//        
//        Client client = new Client();
//        
//        client.setTypePerson(TypePerson.ClientType);
//        
//        client.setName("Mike");
//        client.setSurname("Seleznev");
//        client.setAge(33);
//        
//        client.setPassword("998989898");
//        client.setAddress("zorge 28/2");
//        
//        dp.savePerson(client);
//        
//        Resume resume = new Resume();
//        
//        resume.setClientId(1);
//        resume.setCity("rostov");
//        resume.setProfession("developer");
//        
//        dp.saveResume(resume);
//        
//        Vacancy vacancy = new Vacancy();
//        
//        vacancy.setCompanyId(1);
//        vacancy.setTitle("java");
//        vacancy.setSalary(150000);
//        
//        dp.saveVacancy(vacancy);
//        
//        LogicService service = new LogicService(dp);
//        
//        
//        try{
//            service.hireEmployee(1, 1);
//            List<Employee> list = dp.getAllEmployees(); 
//            if(list.isEmpty()){
//                fail("the test failed");
//            }
//            list.forEach(System.out::println);
//            
//        } catch(Exception ex){
//            fail("the test failed");
//        }
//        
//    }
//    
//    public void testHireEmployeeNegative(IDataProvider dp){
//        System.out.println("test HireEmployeeCSV Negative");
//        
//        LogicService service = new LogicService(dp);
//        
//        
//        try{
//            service.hireEmployee(1, 1);
//            List<Employee> list = dp.getAllEmployees(); 
//            if(!list.isEmpty()){
//                fail("the test failed");
//            }
//            
//        } catch(NullPointerException ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DONT_RECORDS, ex.getMessage());
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testGiveAssessmentPositiveAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test GiveAssessmentPositive CSV");
//        testGiveAssessmentPositive(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test GiveAssessmentPositive H2");
//        testGiveAssessmentPositive(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test GiveAssessmentPositive XML");
//        testGiveAssessmentPositive(dp);
//        deleteXML();
//    }
//    
//    @Test
//    public void testGiveAssessmentNegativeAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test GiveAssessmentNegative CSV");
//        testGiveAssessmentNegative(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test GiveAssessmentNegative H2");
//        testGiveAssessmentNegative(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test GiveAssessmentNegative XML");
//        testGiveAssessmentNegative(dp);
//        deleteXML();
//    }
//    
//    public void testGiveAssessmentPositive(IDataProvider dp){
//        System.out.println("test GiveAssessment Positive");
//        
//        Company company = new Company();
//        
//        company.setTitle("ArenaData");
//        company.setDescription("DataBases company");
//        
//        dp.saveCompany(company);
//        
//        Employee employee = new Employee();
//        
//        employee.setTypePerson(TypePerson.EmployeeType);
//        
//        employee.setName("Никита");
//        employee.setSurname("Парамонов");
//        employee.setAge(22);
//        
//        employee.setCompanyId(1);
//        employee.setSalary(23000);
//        employee.setIsWorking(false);
//        employee.setPosition("middle");
//        
//        dp.savePerson(employee);
//        
//        int idEmployee = 1;
//        int idCompany = 1;
//        int quality = 10;
//        String description = null;
//        
//        LogicService service = new LogicService(dp);
//        
//        
//        try{
//            service.giveAssessment(idEmployee, idCompany, quality, description);
//            List<SeparateQual> list = dp.getAllSeparateQuals(); 
//            if(list.isEmpty()){
//                fail("the test failed");
//            }
//            
//            list.forEach(System.out::println);
//            
//        } catch(NullPointerException ex){
//            fail("the test failed");
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DONT_RECORDS, ex.getMessage());
//        }
//    }
//    
//    public void testGiveAssessmentNegative(IDataProvider dp){
//        System.out.println("test GiveAssessment Negative");
//       
//        int idEmployee = 1;
//        int idCompany = 1;
//        int quality = 10;
//        String description = null;
//        
//        LogicService service = new LogicService(dp);
//        
//        
//        try{
//            service.giveAssessment(idEmployee, idCompany, quality, description);
//            dp.getAllSeparateQuals().forEach(System.out::println);
//            
//            List<SeparateQual> list = dp.getAllSeparateQuals(); 
//            if(!list.isEmpty()){
//                fail("the test failed");
//            }
//            
//        } catch(NullPointerException ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DONT_RECORDS, ex.getMessage());
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testClientRegistrationPositiveAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientRegistrationPositive CSV");
//        testClientRegistrationPositive(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientRegistrationPositive H2");
//        testClientRegistrationPositive(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientRegistrationPositive XML");
//        testClientRegistrationPositive(dp);
//        deleteXML();
//    }
//    
//    public void testClientRegistrationPositive(IDataProvider dp){
//        System.out.println("test ClientRegistration Positive");
//        
//        String name = "Mik";
//        String surname = "Sel";
//        String middleName = "Mih";
//        int age = 21;
//        String birthday = "12-06-2003";
//        String phone = "8999999999";
//        String email = "myrs@lab.com";
//        String password = "pipipip";
//        String address = "zorge 28/2";
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.clientRegistration(name, surname, middleName, age, birthday, phone, email, password, address);
//            
//            List<Client> list = dp.getAllClients();
//            if(list.isEmpty()){
//                fail("the test failed");
//            }
//            
//            list.forEach(System.out::println);
//        } catch(Exception ex){
//            fail(ex.getMessage());
//        }
//        
//    }
//    
//    @Test
//    public void testClientRegistrationNegativeAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientRegistrationNegative CSV");
//        testClientRegistrationNegative(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientRegistrationNegative H2");
//        testClientRegistrationNegative(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientRegistrationNegative XML");
//        testClientRegistrationNegative(dp);
//        deleteXML();
//    }
//    
//    public void testClientRegistrationNegative(IDataProvider dp){
//        System.out.println("test ClientRegistration Negative");
//        
//        String name = null;
//        String surname = "Sel";
//        String middleName = "Mih";
//        int age = 21;
//        String birthday = "12-06-2003";
//        String phone = "8999999999";
//        String email = "myrs@lab.com";
//        String password = "pipipip";
//        String address = "zorge 28/2";
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.clientRegistration(name, surname, middleName, age, birthday, phone, email, password, address);
//        
//            fail("the test failed");
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testCompanyRegistrationPositiveAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyRegistrationPositive CSV");
//        testCompanyRegistrationPositive(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyRegistrationPositive H2");
//        testCompanyRegistrationPositive(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyRegistrationPositive XML");
//        testCompanyRegistrationPositive(dp);
//        deleteXML();
//    }
//    
//    public void testCompanyRegistrationPositive(IDataProvider dp){
//        System.out.println("test CompanyRegistration Positive");
//        
//        String title = "ArenaTitle";
//        String description = "Data bases company";
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.companyRegistration(title, description);
//        
//            List<Company> list = dp.getAllCompanies();
//            if(list.isEmpty()){
//                fail("the test failed");
//            }
//            list.forEach(System.out::println);
//        } catch(Exception ex){
//            fail("the test failed");
//        }
//    }
//    
//    @Test
//    public void testCompanyRegistrationNegativeAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyRegistrationNegative CSV");
//        testCompanyRegistrationNegative(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyRegistrationNegative H2");
//        testCompanyRegistrationNegative(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyRegistrationNegative XML");
//        testCompanyRegistrationNegative(dp);
//        deleteXML();
//    }
//    
//    public void testCompanyRegistrationNegative(IDataProvider dp){
//        System.out.println("test CompanyRegistration Positive");
//        
//        String title = null;
//        String description = "Data bases company";
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.companyRegistration(title, description);
//        
//            fail("the test failed");
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testResumeRegistrationPositiveAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistration Positive CSV");
//        testResumeRegistrationPositive(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistration Positive H2");
//        testResumeRegistrationPositive(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistration Positive XML");
//        testResumeRegistrationPositive(dp);
//        deleteXML();
//    }
//    
//    public void testResumeRegistrationPositive(IDataProvider dp){
//        System.out.println("test ResumeRegistration Positive");
//        
//        int idClient = 1;
//        String profession = "developer";
//        String city = "rostov";
//        String skills = "skills";
//        String education = "education";
//        String experience = "experience";
//        boolean sex = true;
//        boolean workPermit = true;
//        String citizenship = "Russian";
//        
//        //сохранение клиента до сохранения его резюме
//        Client client = new Client();
//        
//        client.setTypePerson(TypePerson.ClientType);
//        
//        client.setName("Mike");
//        client.setSurname("Seleznev");
//        client.setAge(33);
//        
//        client.setPassword("998989898");
//        client.setAddress("zorge 28/2");
//        
//        Result result = dp.savePerson(client);
//        System.out.println(result);
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.resumeRegistration(idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
//        
//            List<Resume> list = dp.getAllResumes();
//            if(list.isEmpty()){
//                fail("the test failed");
//            }
//            list.forEach(System.out::println);
//        } catch(Exception ex){
//            fail("the test failed " + ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testResumeRegistrationNegativeClientAllDP(){
//        //проверка на ошибку, когда клиента с таким ID нет
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistrationClient Negative CSV");
//        testResumeRegistrationNegativeClient(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistrationClient Negative H2");
//        testResumeRegistrationNegativeClient(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistrationClient Negative XML");
//        testResumeRegistrationNegativeClient(dp);
//        deleteXML();
//    }
//    
//    public void testResumeRegistrationNegativeClient(IDataProvider dp){
//        System.out.println("test ResumeRegistrationClient Negative");
//        
//        //здесь сохранения клиента перед тестов не происходит поэтому всегда будет ошибка
//        
//        int idClient = 1;
//        String profession = "developer";
//        String city = "rostov";
//        String skills = "skills";
//        String education = "education";
//        String experience = "experience";
//        boolean sex = true;
//        boolean workPermit = true;
//        String citizenship = "Russian";
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.resumeRegistration(idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
//        
//            fail("the test failed");
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testResumeRegistrationNegativeDataAllDP(){
//        //проверка на ошибку, когда клиента с таким ID нет
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistrationData Negative CSV");
//        testResumeRegistrationNegativeData(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistrationData Negative H2");
//        testResumeRegistrationNegativeData(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeRegistrationData Negative XML");
//        testResumeRegistrationNegativeData(dp);
//        deleteXML();
//    }
//    
//    public void testResumeRegistrationNegativeData(IDataProvider dp){
//        System.out.println("test ResumeRegistrationData Negative");
//        
//        //здесь проверка на ошибку когда невалидные данные
//        
//        int idClient = 1;
//        String profession = null;
//        String city = "rostov";
//        String skills = "skills";
//        String education = "education";
//        String experience = "experience";
//        boolean sex = true;
//        boolean workPermit = true;
//        String citizenship = "Russian";
//        
//         //сохранение клиента до сохранения его резюме
//        Client client = new Client();
//        
//        client.setTypePerson(TypePerson.ClientType);
//        
//        client.setName("Mike");
//        client.setSurname("Seleznev");
//        client.setAge(33);
//        
//        client.setPassword("998989898");
//        client.setAddress("zorge 28/2");
//        
//        Result result = dp.savePerson(client);
//        System.out.println(result);
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.resumeRegistration(idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
//        
//            fail("the test failed");
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testVacancyRegistrationPositiveAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Positive CSV");
//        testVacancyRegistrationPositive(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Positive H2");
//        testVacancyRegistrationPositive(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Positive XML");
//        testVacancyRegistrationPositive(dp);
//        deleteXML();
//    }
//    
//    public void testVacancyRegistrationPositive(IDataProvider dp){
//        System.out.println("test VacancyRegistration Positive");
//        
//        int idCompany = 1;
//        String title = "Java. Developer";
//        String specialization = "Programmer";
//        boolean online = false;
//        String skills = "SOAP, RESTFULL";
//        int salary = 95000;
//        String city = "Moscow";
//        String address = "ploshyad`";
//        String experience = "1-3 years";
//        
//        Company company = new Company();
//        company.setTitle("arenadata");
//        company.setDescription("description");
//        
//        Result result = dp.saveCompany(company);
//        System.out.println(result);
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.vacancyRegistration(idCompany, title, specialization, online, skills, salary, city, address, experience);
//        
//            List<Vacancy> list = dp.getAllVacancies();
//            if(list.isEmpty()){
//                fail("the test failed");
//            }
//            list.forEach(System.out::println);
//        } catch(Exception ex){
//            fail("the test failed");
//        }
//    }
//    
//    @Test
//    public void testVacancyRegistrationNegativeCompanyAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Negative Company CSV");
//        testVacancyRegistrationNegativeCompany(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Negative Company H2");
//        testVacancyRegistrationNegativeCompany(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Negative Company XML");
//        testVacancyRegistrationNegativeCompany(dp);
//        deleteXML();
//    }
//    
//    public void testVacancyRegistrationNegativeCompany(IDataProvider dp){
//        System.out.println("test VacancyRegistration Company Negative");
//        
//        //проверка когда такой компании нет
//        
//        int idCompany = 1;
//        String title = "Java. Developer";
//        String specialization = "Programmer";
//        boolean online = false;
//        String skills = "SOAP, RESTFULL";
//        int salary = 95000;
//        String city = "Moscow";
//        String address = "ploshyad`";
//        String experience = "1-3 years";
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.vacancyRegistration(idCompany, title, specialization, online, skills, salary, city, address, experience);
//        
//            fail("the test failed");
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testVacancyRegistrationNegativeDataAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Negative Data CSV");
//        testVacancyRegistrationNegativeData(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Negative Company H2");
//        testVacancyRegistrationNegativeData(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyRegistration Negative Company XML");
//        testVacancyRegistrationNegativeData(dp);
//        deleteXML();
//    }
//    
//    public void testVacancyRegistrationNegativeData(IDataProvider dp){
//        System.out.println("test VacancyRegistration Negative Data");
//        
//        int idCompany = 1;
//        String title = null;
//        String specialization = "Programmer";
//        boolean online = false;
//        String skills = "SOAP, RESTFULL";
//        int salary = 95000;
//        String city = "Moscow";
//        String address = "ploshyad`";
//        String experience = "1-3 years";
//        
//        //сохранение компании вакансии
//        Company company = new Company();
//        company.setTitle("arenadata");
//        company.setDescription("description");
//        
//        Result result = dp.saveCompany(company);
//        System.out.println(result);
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.vacancyRegistration(idCompany, title, specialization, online, skills, salary, city, address, experience);
//        
//            fail("the test failed");
//        } catch(Exception ex){
//            assertEquals(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA, ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testClientChangeAllDp(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientChangeAllDp CSV");
//        testClientChange(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientChangeAllDp H2");
//        testClientChange(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ClientChangeAllDp XML");
//        testClientChange(dp);
//        deleteXML();
//    }
//    
//    public void testClientChange(IDataProvider dp){
//        System.out.println("test ClientChange");
//        
//        testClientRegistrationPositive(dp);
//        
//        int id = 1;
//        String name = "Mik";
//        String surname = "Sel";
//        String middleName = "Mih";
//        int age = 21;
//        String birthday = "12-06-2003";
//        String phone = "7878787877";
//        String email = "Ilya@lab.com";
//        String password = "pipipip";
//        String address = "zorge 28/2";
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.clientChange(id, name, surname, middleName, age, birthday, phone, email, password, address);
//            
//            dp.getAllClients().forEach(System.out::println);
//        } catch(Exception ex){
//            fail(ex.getMessage());
//        }
//        
//    }
//    
//    @Test
//    public void testCompanyChangeAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyChangeAllDP CSV");
//        testCompanyChange(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyChangeAllDP H2");
//        testCompanyChange(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CompanyChangeAllDP XML");
//        testCompanyChange(dp);
//        deleteXML();
//    }
//    
//    public void testCompanyChange(IDataProvider dp){
//        System.out.println("test CompanyChange");
//        
//        int id = 1;
//        String title = "Bebra";
//        String description = "Data bases company";
//        
//        testCompanyRegistrationPositive(dp);
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.companyChange(id, title, description);
//        
//            dp.getAllCompanies().forEach(System.out::println);
//        } catch(Exception ex){
//            fail("the test failed");
//        }
//    }
//    
//    @Test
//    public void testResumeChangeAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeChangeAllDP CSV");
//        testResumeChange(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeChangeAllDP H2");
//        testResumeChange(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test ResumeChangeAllDP XML");
//        testResumeChange(dp);
//        deleteXML();
//    }
//    
//    public void testResumeChange(IDataProvider dp){
//        System.out.println("testResume Change");
//        
//        int id = 1;
//        int idClient = 1;
//        String profession = "MANAGER";
//        String city = "KRASNODAR";
//        String skills = "NO SKILL";
//        String education = "education";
//        String experience = "experience";
//        boolean sex = true;
//        boolean workPermit = true;
//        String citizenship = "Russian";
//        
//        testResumeRegistrationPositive(dp);
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.resumeChange(id, idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
//        
//            dp.getAllResumes().forEach(System.out::println);
//        } catch(Exception ex){
//            fail("the test failed " + ex.getMessage());
//        }
//    }
//    
//    @Test
//    public void testVacancyChangeAllDP(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyChangeAllDP CSV");
//        testVacancyChange(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyChangeAllDP H2");
//        testVacancyChange(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test VacancyChangeAllDP XML");
//        testVacancyChange(dp);
//        deleteXML();
//    }
//    
//    public void testVacancyChange(IDataProvider dp){
//        System.out.println("test VacancyChange");
//        
//        int id = 1;
//        int idCompany = 1;
//        String title = "Java. Developer";
//        String specialization = "Programmer";
//        boolean online = false;
//        String skills = "SOAP, RESTFULL";
//        int salary = 200000;
//        String city = "ANAPA";
//        String address = "NENENE`";
//        String experience = "5 years and above";
//        
//        testVacancyRegistrationPositive(dp);
//        
//        try{
//            LogicService service = new LogicService(dp);
//            service.vacancyChange(id, idCompany, title, specialization, online, skills, salary, city, address, experience);
//        
//            dp.getAllVacancies().forEach(System.out::println);
//        } catch(Exception ex){
//            fail("the test failed");
//        }
//    }
//    
//    @Test
//    public void testDeleteClientAllDp(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteClientAllDp CSV");
//        testDeleteClient(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteClientAllDp H2");
//        testDeleteClient(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteClientAllDp XML");
//        testDeleteClient(dp);
//        deleteXML();
//    }
//    
//    public void testDeleteClient(IDataProvider dp){
//        
//        for(int i = 0; i < 3; i++){
//            testResumeRegistrationPositive(dp);
//        }
//        
//        testClientRegistrationPositive(dp);
//        
//        try{
//            int id = 1;
//            
//            LogicService service = new LogicService(dp);
//            service.deletePerson(id, TypePerson.ClientType);
//            
//            List<Resume> resumes = dp.getAllResumes();
//            if(resumes != null && !resumes.isEmpty()){
//                fail("the test failed");
//            }
//            
//        } catch(NullPointerException ex){
//            
//        }
//    }
//    
//    @Test
//    public void testDeleteCompanyAllDp(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteCompanyAllDp CSV");
//        testDeleteCompany(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteCompanyAllDp H2");
//        testDeleteCompany(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteCompanyAllDp XML");
//        testDeleteCompany(dp);
//        deleteXML();
//    }
//    
//    public void testDeleteCompany(IDataProvider dp){
//        
//        for(int i = 0; i < 3; i++){
//            testVacancyRegistrationPositive(dp);
//        }
//        
//        testCompanyRegistrationPositive(dp);
//        
//        try{
//            int id = 1;
//            
//            LogicService service = new LogicService(dp);
//            service.deleteCompany(id);
//            
//            List<Vacancy> vacancies = dp.getAllVacancies();
//            if(vacancies != null && !vacancies.isEmpty()){
//                fail("the test failed");
//            }
//            
//        } catch(NullPointerException ex){
//            
//        }
//    }
//    
//    @Test
//    public void testDeleteVacancyAllDp(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteVacancyAllDp CSV");
//        testDeleteVacancy(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteVacancyAllDp H2");
//        testDeleteVacancy(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteVacancyAllDp XML");
//        testDeleteVacancy(dp);
//        deleteXML();
//    }
//    
//    public void testDeleteVacancy(IDataProvider dp){
//        
//        testVacancyRegistrationPositive(dp);
//        
//        try{
//            int id = 1;
//            
//            LogicService service = new LogicService(dp);
//            service.deleteVacancy(id);
//            
//            List<Vacancy> vacancies = dp.getAllVacancies();
//            if(vacancies != null && !vacancies.isEmpty()){
//                fail("the test failed");
//            }
//            
//        } catch(NullPointerException ex){
//            
//        }
//    }
//    
//    @Test
//    public void testDeleteResumeAllDp(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteResumeAllDp CSV");
//        testDeleteResume(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteResumeAllDp H2");
//        testDeleteResume(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteResumeAllDp XML");
//        testDeleteResume(dp);
//        deleteXML();
//    }
//    
//    public void testDeleteResume(IDataProvider dp){
//        
//        testResumeRegistrationPositive(dp);
//        
//        try{
//            int id = 1;
//            
//            LogicService service = new LogicService(dp);
//            service.deleteResume(id);
//            
//            List<Resume> resumes = dp.getAllResumes();
//            if(resumes != null && !resumes.isEmpty()){
//                fail("the test failed");
//            }
//            
//        } catch(NullPointerException ex){
//            
//        }
//    }
//    
//    @Test
//    public void testDeleteSeparateQualAllDp(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteSeparateQualAllDp CSV");
//        testDeleteSeparateQual(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteSeparateQualAllDp H2");
//        testDeleteSeparateQual(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test DeleteSeparateQualAllDp XML");
//        testDeleteSeparateQual(dp);
//        deleteXML();
//    }
//    
//    public void testDeleteSeparateQual(IDataProvider dp){
//        
//        testGiveAssessmentPositive(dp);
//        
//        try{
//            int id = 1;
//            
//            LogicService service = new LogicService(dp);
//            service.deleteSeparateQual(id);
//            
//            List<SeparateQual> separateQuals = dp.getAllSeparateQuals();
//            if(separateQuals != null && !separateQuals.isEmpty()){
//                fail("the test failed");
//            }
//            
//        } catch(NullPointerException ex){
//            
//        }
//    }
//    
//    @Test
//    public void testCalculateAssessmentPositiveAllDp(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CalculateAssessmentPositiveAllDp CSV");
//        testCalculateAssessmentPositive(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CalculateAssessmentPositiveAllDp H2");
//        testCalculateAssessmentPositive(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CalculateAssessmentPositiveAllDp XML");
//        testCalculateAssessmentPositive(dp);
//        deleteXML();
//    }
//    
//    
//    public void testCalculateAssessmentPositive(IDataProvider dp){
//        testGiveAssessmentPositive(dp);
//        testGiveAssessmentPositive(dp);
//        testGiveAssessmentPositive(dp);
//        
//        try{
//            
//            int idCompany = 1;
//            LogicService service = new LogicService(dp);
//            service.calculateAssessment(idCompany);
//            
//        } catch(Exception ex){
//            fail("the test faield ex = " + ex);
//        }
//    }
//    
//    @Test
//    public void testCalculateAssessmentNegativeAllDp(){
//        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CalculateAssessmentNegativeAllDp CSV");
//        testCalculateAssessmentNegative(dp);
//        deleteCSV();
//        
//        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CalculateAssessmentNegativeAllDp H2");
//        testCalculateAssessmentNegative(dp);
//        deleteH2();
//        
//        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
//        
//        System.out.println("test CalculateAssessmentNegativeAllDp XML");
//        testCalculateAssessmentNegative(dp);
//        deleteXML();
//    }
//    
//    
//    public void testCalculateAssessmentNegative(IDataProvider dp){
//        testGiveAssessmentPositive(dp);
//        testGiveAssessmentPositive(dp);
//        testGiveAssessmentPositive(dp);
//        
//        try{
//            
//            int idCompany = -1;
//            LogicService service = new LogicService(dp);
//            service.calculateAssessment(idCompany);
//            fail("the test faield");
//        } catch(Exception ex){
//            assertEquals(NullPointerException.class, ex.getClass());
//        }
//    }
//}
