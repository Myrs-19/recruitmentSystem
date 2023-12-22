/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.sfedu.Constants;

import ru.sfedu.model.*;
import ru.sfedu.util.ConfigurationUtilProperties;
import ru.sfedu.util.FileUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataProviderCsvTest {
    
    private static IDataProvider dp;
    
    @BeforeAll
    public static void setUpClass() {
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
    }
    
    @AfterAll
    public static void tearDownClass() {
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_CLIENT).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_COMPANY).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_EMPLOYEE).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_RESUME).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_SEPARATE_QUAL).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_VACANCY).concat(Constants.CSV_FILE_TYPE));
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)));
        
    }
    
    @Test
    @Order(1)
    void testSavePersonClient(){
        System.out.println("test SaveClient csv");
        
        Client client = new Client();
        
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("Mike");
        client.setSurname("Seleznev");
        client.setAge(33);
        
        client.setPassword("998989898");
        client.setAddress("zorge 28/2");
        
        Result result = dp.savePerson(client);
        System.out.println(result);
    }
    
    @Test
    @Order(3)
    void testSavePersonEmployee(){
        System.out.println("test saveEmployee csv");
        Employee employee = new Employee();
        
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("plplpl");
        employee.setSurname("selsel");
        employee.setAge(20);
        
        employee.setCompanyId(1);
        employee.setStartWorkDate("12-06-2003");
        employee.setSalary(99);
        employee.setIsWorking(false);
        employee.setPosition("middle");
        
        Result result = new Result();
        
        result = dp.savePerson(employee);
        
        System.out.println(result);
    }
    
    @Test
    @Order(4)
    void testSaveResume(){
        System.out.println("test saveResume csv");
        Resume resume = new Resume();
        
        resume.setClientId(1);
        resume.setCity("rostov");
        resume.setProfession("developer");
        
        Result result = dp.saveResume(resume);
        System.out.println(result);
    }
    
    @Test
    @Order(2)
    void testSaveCompany(){
        System.out.println("test SaveCompany csv");
        
        Company company = new Company();
        company.setTitle("arenadata");
        
        Result result = dp.saveCompany(company);
        System.out.println(result);
    }
    
    @Test
    @Order(5)
    void testSaveVacancy(){
        System.out.println("test SaveVacancy csv");
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompanyId(1);
        vacancy.setTitle("java");
        vacancy.setSalary(8797);
        
        Result result = dp.saveVacancy(vacancy);
        System.out.println(result);
    }
    
    @Test
    @Order(6)
    void testSaveSeparateQual(){
        System.out.println("test SaveSeparateQual csv");
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setCompanyId(1);
        separateQual.setEmployeeId(1);
        separateQual.setQuality(7);
        
        Result result = dp.saveSeparateQual(separateQual);
       
        System.out.println(result);
    }
    
    @Test
    @Order(7)
    void testGetClientPositive(){
        System.out.println("test GetClientById positive csv");
        try{
            int id = 1;
            System.out.println(dp.getClient(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(8)
    void testGetClientNegative(){
        System.out.println("test GetClientById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getClient(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
        
    @Test
    @Order(9)
    void testGetResumePositive(){
        System.out.println("test getResumeById positive csv");
        try{
            int id = 1;
            System.out.println(dp.getResume(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(10)
    void testGetResumeNegative(){
        System.out.println("test getResumeById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getResume(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(11)
    void testGetCompanyPositive(){
        System.out.println("test getCompanyById positive csv");
        try{
            int id = 1;
            System.out.println(dp.getCompany(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(12)
    void testGetCompanyNegative(){
        System.out.println("test getCompanyById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getCompany(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(13)
    void testGetVacancyPositive(){
        System.out.println("test getVacancyById positive csv");
        try{
            int id = 1;
            System.out.println(dp.getVacancy(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(14)
    void testGetVacancyNegative(){
        System.out.println("test getVacancyById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getVacancy(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(15)
    void testGetEmployeePositive(){
        System.out.println("test getEmployeeById positive csv");
        try{
            int id = 1;
            System.out.println(dp.getEmployee(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(16)
    void testGetEmployeeNegative(){
        System.out.println("test getEmployeeById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getEmployee(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(17)
    void testGetSeparateQualPositive(){
        System.out.println("test getSeparateQualById positive csv");
        try{
            int id = 1;
            System.out.println(dp.getSeparateQual(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(18)
    void testGetSeparateQualNigga(){
        System.out.println("test getSeparateQualById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getSeparateQual(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(19)
    void testGetAllClients(){
        System.out.println("test GetAllClients csv");
        
        try{
            dp.getAllClients().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(20)
    public void testGetAllResumes(){
        System.out.println("test GetAllResumes csv");
        
        try{
            dp.getAllResumes().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(21)
    public void testGetAllCompanies(){
        System.out.println("test GetAllCompanies csv");
        
        try{
            dp.getAllCompanies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(22)
    public void testGetAllVacancies(){
        System.out.println("test GetAllVacancies csv");
        
        try{
            dp.getAllVacancies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(23)
    public void testGetAllEmployees(){
        System.out.println("test GetAllEmployees csv");
        
        try{
            dp.getAllEmployees().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(24)
    public void testGetAllSeparateQuals(){
        System.out.println("test GetAllSeparateQuals csv");
        
        try{
            dp.getAllSeparateQuals().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(25)
    public void testUpdateClient() {
        System.out.println("test updateClient csv");
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
        System.out.println("test UpdatedEmployee csv");
        Employee employee = new Employee();
        
        employee.setId(1);
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("TEST");
        employee.setSurname("selsel");
        employee.setAge(20);
        
        employee.setCompanyId(1);
        employee.setStartWorkDate("12-06-2003");
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
        System.out.println("test UpdateResume csv");
        Resume resume = new Resume();
        
        resume.setId(1);
        resume.setClientId(1);
        resume.setCity("RRRRRRRRR");
        resume.setProfession("developerTEST");
        
        Result result = new Result();
    
        result = dp.updateResume(resume);
        
        System.out.println(result);
    }
    
    @Test
    @Order(28)
    public void testUpdateCompany() {
        System.out.println("test UpdateCompany csv");
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
        System.out.println("test UpdateVacancy csv");
        Vacancy vacancy = new Vacancy();
        
        vacancy.setId(1);
        vacancy.setCompanyId(1);
        vacancy.setTitle("JAAAAAAAVAAAAAAAa");
        vacancy.setSalary(11);
        
        Result result = new Result();
        
        result = dp.updateVacancy(vacancy);
        
        System.out.println(result);
    }
    
    @Test
    @Order(30)
    public void testUpdateSeparateQual() {
        System.out.println("test UpdateSeparateQual csv");
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setId(1);
        separateQual.setCompanyId(1);
        separateQual.setEmployeeId(1);
        separateQual.setQuality(10);
        separateQual.setDescription("nice");
        
        Result result = new Result();
    
        result = dp.updateSeparateQual(separateQual);
        
        System.out.println(result);
    }
    
    @Test
    @Order(32)
    public void testDeleteClient() {
        System.out.println("test DeleteClient csv");
        int id = 1;
        Result result = dp.deletePerson(id, TypePerson.ClientType);
        System.out.println(result);
    }
    
    @Test
    @Order(35)
    public void testDeleteEmployee() {
        System.out.println("test DeleteEmployee csv");
        int id = 1;
        Result result = dp.deletePerson(id, TypePerson.EmployeeType);
        System.out.println(result);
    }
    
    @Test
    @Order(31)
    public void testDeleteResume() {
        System.out.println("test DeleteResume csv");
        int id = 1;
        Result result = dp.deleteResume(id);
        System.out.println(result);
    }
    
    @Test
    @Order(36)
    public void testDeleteCompany() {
        System.out.println("test DeleteCompany csv");
        int id = 1;
        Result result = dp.deleteCompany(id);
        System.out.println(result);
    }
    
    @Test
    @Order(34)
    public void testDeleteVacancy() {
        System.out.println("test DeleteVacancy csv");
        int id = 1;
        Result result = dp.deleteVacancy(id);
        System.out.println(result);
    }
    
    @Test
    @Order(33)
    public void testDeleteSeparateQual() {
        System.out.println("test DeleteSeparateQual csv");
        int id = 1;
        Result result = dp.deleteSeparateQual(id);
        System.out.println(result);
    }
}
