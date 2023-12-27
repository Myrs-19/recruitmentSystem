/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ru.sfedu.Constants;

import ru.sfedu.model.*;
import ru.sfedu.util.ConfigurationUtilProperties;
import ru.sfedu.util.FileUtil;

/**
 *
 * @author mike
 */
@TestMethodOrder(OrderAnnotation.class)
public class DataProviderH2Test{
    
    private static IDataProvider dp;
    
    public DataProviderH2Test() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
        dp = new DataProviderH2(Constants.TEST_MAIN_FOLDER_PATH);
    }
    
//    @AfterAll
//    public static void tearDownClass() {
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)).concat(Constants.H2_DB_NAME).concat(".trace.db"));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)).concat(Constants.H2_DB_NAME).concat(".mv.db"));
//        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.H2_PATH)));
//    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    @Order(1)
    public void testSaveClient(){
        System.out.println("test SaveClient h2");
        
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("nameClient");
        client.setSurname("nameSurname");
        client.setMiddleName("middleNameClient");
        client.setAge(32);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("my.rs@mail.ru");
        client.setPassword("pipipipi");
        client.setAddress("address zorge 28/2");
        
        Result result = dp.savePerson(client);
        System.out.println(result);
    }
    
    @Test
    @Order(2)
    public void testSaveCompany(){
        System.out.println("test SaveCompany h2");
        
        Company company = new Company();
        company.setTitle("arenadata");
        company.setDescription("desc");
        
        Result result = dp.saveCompany(company);
        System.out.println(result);
    }
    
    @Test
    @Order(3)
    public void testSaveEmployee() {
        System.out.println("test saveEmployee h2");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save employee");
        company.setDescription("xml test save");
        
        Employee employee = new Employee();
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("nameEmployee");
        employee.setSurname("surnameEmployee");
        employee.setMiddleName("middleNameEmployee");
        employee.setAge(33);
        employee.setBirthday("12-06-2003");
        employee.setPhone("89964095446");
        employee.setEmail("mseleznev@sfedu.ru");
        employee.setSalary(350000);
        employee.setPosition("head of yandex");
        employee.setIsWorking(false);
        
        employee.setCompany(company);
        
        Result result = new Result();
        
        result = dp.savePerson(employee);
        
        System.out.println(result);
    }
    
    @Test
    @Order(4)
    public void testSaveResume() {
        System.out.println("test saveResume h2");
        
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        client.setId(1);
        client.setName("nameClient");
        client.setSurname("nameSurname");
        client.setMiddleName("middleNameClient");
        client.setAge(32);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("my.rs@mail.ru");
        client.setPassword("pipipipi");
        client.setAddress("address zorge 28/2");
        
        Resume resume = new Resume();
        
        resume.setClient(client);
        resume.setCity("rostov");
        resume.setProfession("developer");
        
        Result result = dp.saveResume(resume);
        System.out.println(result);
    }
    
    @Test
    @Order(5)
    public void testSaveVacancy() {
        System.out.println("test SaveVacancy h2");
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save employee");
        company.setDescription("xml test save");
        
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompany(company);
        vacancy.setTitle("java");
        vacancy.setSalary(8797);
        
        Result result = dp.saveVacancy(vacancy);
        System.out.println(result);
    }
    
    @Test
    @Order(6)
    public void testSaveSeparateQual() {
        System.out.println("test SaveSeparateQual h2");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save employee");
        company.setDescription("xml test save");
        
        
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setCompany(company);
        separateQual.setQuality(7);
        
        Result result = dp.saveSeparateQual(separateQual);
       
        System.out.println(result);
    }
    
    @Test
    @Order(7)
    public void testGetClientByIdPositive(){
        System.out.println("test GetClientById positive h2");
        try{
            int id = 1;
            System.out.println(dp.getClient(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(8)
    public void testGetClientByIdNegative(){
       
        System.out.println("test GetClientById negative h2");
        try{
            int id = -1;
            System.out.println(dp.getClient(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(9)
    public void testGetResumeByIdPositive(){
        System.out.println("test getResumeById positive h2");
        try{
            int id = 1;
            Resume resume = dp.getResume(id); 
            System.out.println(resume); 
            System.out.println(resume.getClient()); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(10)
    public void testGetResumeByIdNegative(){
        System.out.println("test getResumeById negative h2");
        try{
            int id = -1;
            System.out.println(dp.getResume(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(11)
    public void testGetCompanyByIdPositive(){
        System.out.println("test getCompanyById positive h2");
        try{
            int id = 1;
            System.out.println(dp.getCompany(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(12)
    public void testGetCompanyByIdNegative(){
        System.out.println("test getCompanyById negative h2");
        try{
            int id = -1;
            System.out.println(dp.getCompany(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(13)
    public void testGetVacancyByIdPositive(){
        System.out.println("test getVacancyById positive h2");
        try{
            int id = 1;
            Vacancy vacancy = dp.getVacancy(id); 
            System.out.println(vacancy); 
            System.out.println(vacancy.getCompany());
            
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(14)
    public void testGetVacancyByIdNegative(){
        System.out.println("test getVacancyById negative h2");
        try{
            int id = -1;
            System.out.println(dp.getVacancy(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(15)
    public void testGetEmployeeByIdPositive(){
        System.out.println("test getEmployeeById positive h2");
        try{
            int id = 1;
            Employee employee = dp.getEmployee(id); 
            System.out.println(employee); 
            System.out.println(employee.getCompany()); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(16)
    public void testGetEmployeeByIdNegative(){
        System.out.println("test getEmployeeById negative h2");
        try{
            int id = -1;
            System.out.println(dp.getEmployee(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(17)
    public void testGetSeparateQualByIdPositive(){
        System.out.println("test getSeparateQualById positive h2");
        try{
            int id = 1;
            SeparateQual separateQual = dp.getSeparateQual(id); 
            System.out.println(separateQual); 
            System.out.println(separateQual.getCompany()); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(18)
    public void testGetSeparateQualByIdNegative(){
        System.out.println("test getSeparateQualById negative h2");
        try{
            int id = -1;
            System.out.println(dp.getSeparateQual(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(19)
    public void testGetAllClients(){
        System.out.println("test GetAllClients h2");
        
        try{
            dp.getAllClients().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(20)
    public void testGetAllResumes(){
        System.out.println("test GetAllResumes h2");
        
        try{
            dp.getAllResumes().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(21)
    public void testGetAllCompanies(){
        System.out.println("test GetAllCompanies h2");
        
        try{
            dp.getAllCompanies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(22)
    public void testGetAllVacancies(){
        System.out.println("test GetAllVacancies h2");
        
        try{
            dp.getAllVacancies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(23)
    public void testGetAllEmployees(){
        System.out.println("test GetAllEmployees h2");
        
        try{
            dp.getAllEmployees().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(24)
    public void testGetAllSeparateQuals(){
        System.out.println("test GetAllSeparateQuals h2");
        
        try{
            dp.getAllSeparateQuals().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(25)
    public void testUpdateClient() {
        System.out.println("test updateClient h2");
        Client client = new Client();
        int id = 1;
        client.setId(id);
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("plplpl");
        client.setSurname("MIMIMIMI");
        client.setAge(20);
        
        client.setEmail("a");
        client.setPhone("756");
        client.setAddress("zorrr");
        client.setPassword("ppiipi");
        
        Result result = new Result();
        
        result = dp.updatePerson(client);
        
        System.out.println(result);
    }
    
    @Test
    @Order(26)
    public void testUpdatedEmployee() {
        System.out.println("test UpdatedEmployee h2");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save employee");
        company.setDescription("xml test save");
        
        Employee employee = new Employee();
        
        employee.setId(1);
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("TEST");
        employee.setSurname("selsel");
        employee.setAge(20);
        
        employee.setCompany(company);
        employee.setSalary(99);
        employee.setIsWorking(false);
        employee.setPosition("senior");
        
        Result result = new Result();
        
        result = dp.updatePerson(employee);
        System.out.println(result);
    }
    
    @Test
    @Order(27)
    public void testUpdateResume() {
        System.out.println("test UpdateResume h2");
        
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        client.setId(1);
        client.setName("nameClient");
        client.setSurname("nameSurname");
        client.setMiddleName("middleNameClient");
        client.setAge(32);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("my.rs@mail.ru");
        client.setPassword("pipipipi");
        client.setAddress("address zorge 28/2");
        
        Resume resume = new Resume();
        
        resume.setId(1);
        resume.setClient(client);
        resume.setCity("RRRRRRRRR");
        resume.setProfession("developerTEST");
        
        Result result = new Result();
    
        result = dp.updateResume(resume);
        
        System.out.println(result);
    }
    
    @Test
    @Order(28)
    public void testUpdateCompany() {
        System.out.println("test UpdateCompany h2");
        Company company = new Company();
        
        company.setId(1);
        company.setTitle("DATAAA");
        
        Result result = new Result();
    
        result = dp.updateCompany(company);
        
        System.out.println(result);
    }
    
    @Test
    @Order(29)
    public void testUpdateVacancy() {
        System.out.println("test UpdateVacancy h2");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save employee");
        company.setDescription("xml test save");
        
        Vacancy vacancy = new Vacancy();
        
        vacancy.setId(1);
        vacancy.setCompany(company);
        vacancy.setTitle("JAAAAAAAVAAAAAAAa");
        vacancy.setSalary(11);
        
        Result result = new Result();
        
        result = dp.updateVacancy(vacancy);
        
        System.out.println(result);
    }
    
    @Test
    @Order(30)
    public void testUpdateSeparateQual() {
        System.out.println("test UpdateSeparateQual h2");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save employee");
        company.setDescription("xml test save");
        
        Employee employee = new Employee();
        employee.setCompany(company);
        
        employee.setTypePerson(TypePerson.EmployeeType);    
        
        employee.setId(1);
        employee.setName("nameEmployee");
        employee.setSurname("surnameEmployee");
        employee.setMiddleName("middleNameEmployee");
        employee.setAge(33);
        employee.setBirthday("12-06-2003");
        employee.setPhone("89964095446");
        employee.setEmail("mseleznev@sfedu.ru");
        employee.setSalary(350000);
        employee.setPosition("head of yandex");
        employee.setIsWorking(false);
        
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setId(1);
        separateQual.setCompany(company);
        separateQual.setQuality(10);
        separateQual.setDescription("nice");
        
        Result result = new Result();
    
        result = dp.updateSeparateQual(separateQual);
        
        System.out.println(result);
    }
    
    @Test
    @Order(32)
    public void testDeleteClient() {
        System.out.println("test DeleteClient h2");
        int id = 1;
        Result result = dp.deletePerson(id, TypePerson.ClientType);
        System.out.println(result);
    }
    
    @Test
    @Order(35)
    public void testDeleteEmployee() {
        System.out.println("test DeleteEmployee h2");
        int id = 1;
        Result result = dp.deletePerson(id, TypePerson.EmployeeType);
        System.out.println(result);
    }
    
    @Test
    @Order(31)
    public void testDeleteResume() {
        System.out.println("test DeleteResume h2");
        int id = 1;
        Result result = dp.deleteResume(id);
        System.out.println(result);
    }
    
    @Test
    @Order(36)
    public void testDeleteCompany() {
        System.out.println("test DeleteCompany h2");
        int id = 1;
        Result result = dp.deleteCompany(id);
        System.out.println(result);
    }
    
    @Test
    @Order(34)
    public void testDeleteVacancy() {
        System.out.println("test DeleteVacancy h2");
        int id = 1;
        Result result = dp.deleteVacancy(id);
        System.out.println(result);
    }
    
    @Test
    @Order(33)
    public void testDeleteSeparateQual() {
        System.out.println("test DeleteSeparateQual h2");
        int id = 1;
        Result result = dp.deleteSeparateQual(id);
        System.out.println(result);
    }
}
