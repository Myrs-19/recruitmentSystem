/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import java.sql.*;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ru.sfedu.Constants;

import ru.sfedu.model.*;

/**
 *
 * @author mike
 */
public class DataProviderH2Test {
    
    public DataProviderH2Test() {
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

    @Test
    public void testInitH2(){
        IDataProvider dp = new DataProviderH2();
    }
   
    
    @Test
    public void testSaveClient(){
        System.out.println("test SaveClient h2");
        IDataProvider dp = new DataProviderH2();
        
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
    public void testSaveCompany(){
        System.out.println("test SaveCompany h2");
        
        IDataProvider dp = new DataProviderH2();
        
        Company company = new Company();
        company.setTitle("arenadata");
        
        Result result = dp.saveCompany(company);
        System.out.println(result);
    }
    
    @Test
    public void testSaveEmployee() {
    
        testSaveCompany();
        
        System.out.println("test saveEmployee h2");
        Employee employee = new Employee();
        
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("plplpl");
        employee.setSurname("selsel");
        employee.setAge(20);
        
        employee.setCompanyId(4);
        employee.setStartWorkDate("12-06-2003");
        employee.setSalary(99);
        employee.setIsWorking(false);
        employee.setPosition("middle");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderH2();
        result = dp.savePerson(employee);
        
        System.out.println(result);
    }
    
    @Test
    public void testSaveResume() {
        
        testSaveClient();
        
        System.out.println("test saveResume h2");
        Resume resume = new Resume();
        
        resume.setClientId(3);
        resume.setCity("rostov");
        resume.setProfession("developer");
        
        IDataProvider dp = new DataProviderH2();
        Result result = dp.saveResume(resume);
        System.out.println(result);
    }
    
    @Test
    public void testSaveVacancy() {
        testSaveCompany();
        
        System.out.println("test SaveVacancy h2");
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompanyId(4);
        vacancy.setTitle("java");
        vacancy.setSalary(8797);
        
        IDataProvider dp = new DataProviderH2();
        Result result = dp.saveVacancy(vacancy);
        System.out.println(result);
    }
    
    @Test
    public void testSaveSeparateQual() {
        testSaveCompany();
        testSaveEmployee();
        System.out.println("test SaveSeparateQual h2");
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setCompanyId(4);
        separateQual.setEmployeeId(8);
        separateQual.setQuality(7);
        
        IDataProvider dp = new DataProviderH2();
        Result result = dp.saveSeparateQual(separateQual);
       
        System.out.println(result);
    }
    
    @Test
    public void testGetClientByIdPositive(){
        testSaveClient();
        System.out.println("test GetClientById positive h2");
        try{
            int id = 1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getClient(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetClientByIdNegative(){
       
        System.out.println("test GetClientById negative h2");
        try{
            int id = -1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getClient(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetResumeByIdPositive(){
        testSaveResume();
        System.out.println("test getResumeById positive h2");
        try{
            int id = 1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getResume(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetResumeByIdNegative(){
    
        System.out.println("test getResumeById negative h2");
        try{
            int id = -1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getResume(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetCompanyByIdPositive(){
        testSaveCompany();
        System.out.println("test getCompanyById positive h2");
        try{
            int id = 1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getCompany(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetCompanyByIdNegative(){
       
        System.out.println("test getCompanyById negative h2");
        try{
            int id = -1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getCompany(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetVacancyByIdPositive(){
        testSaveVacancy();
        System.out.println("test getVacancyById positive h2");
        try{
            int id = 1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getVacancy(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetVacancyByIdNegative(){
        
        System.out.println("test getVacancyById negative h2");
        try{
            int id = -1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getVacancy(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetEmployeeByIdPositive(){
        testSaveEmployee();
        System.out.println("test getEmployeeById positive h2");
        try{
            int id = 2;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getEmployee(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetEmployeeByIdNegative(){
       
        System.out.println("test getEmployeeById negative h2");
        try{
            int id = -1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getEmployee(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetSeparateQualByIdPositive(){
        testSaveSeparateQual();
        System.out.println("test getSeparateQualById positive h2");
        try{
            int id = 1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getSeparateQual(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetSeparateQualByIdNegative(){
        
        System.out.println("test getSeparateQualById negative h2");
        try{
            int id = -1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getSeparateQual(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetAllClients(){
        System.out.println("test GetAllClients h2");
        
        try{
        IDataProvider dp = new DataProviderH2();
        
        dp.getAllClients().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetAllResumes(){
        System.out.println("test GetAllResumes h2");
        
        try{
        IDataProvider dp = new DataProviderH2();
        
        dp.getAllResumes().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetAllCompanies(){
        System.out.println("test GetAllCompanies h2");
        
        try{
        IDataProvider dp = new DataProviderH2();
        
        dp.getAllCompanies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetAllVacancies(){
        System.out.println("test GetAllVacancies h2");
        
        try{
        IDataProvider dp = new DataProviderH2();
        
        dp.getAllVacancies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetAllEmployees(){
        System.out.println("test GetAllEmployees h2");
        
        try{
        IDataProvider dp = new DataProviderH2();
        
        dp.getAllEmployees().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetAllSeparateQuals(){
        System.out.println("test GetAllSeparateQuals h2");
        
        try{
        IDataProvider dp = new DataProviderH2();
        
        dp.getAllSeparateQuals().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
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
        
        IDataProvider dp = new DataProviderH2();
        result = dp.updatePerson(client);
        
        System.out.println(result);
    }
    
    
    @Test
    public void testUpdatedEmployee() {
        System.out.println("test UpdatedEmployee h2");
        Employee employee = new Employee();
        
        employee.setId(2);
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
        
        IDataProvider dp = new DataProviderH2();
        result = dp.updatePerson(employee);
        System.out.println(result);
    }
    
    @Test
    public void testUpdateResume() {
        System.out.println("test UpdateResume h2");
        Resume resume = new Resume();
        
        resume.setId(1);
        resume.setClientId(1);
        resume.setCity("RRRRRRRRR");
        resume.setProfession("developerTEST");
        
        Result result = new Result();
    
        IDataProvider dp = new DataProviderH2();
        result = dp.updateResume(resume);
        
        System.out.println(result);
    }
    
    @Test
    public void testUpdateCompany() {
        System.out.println("test UpdateCompany h2");
        Company company = new Company();
        
        company.setId(1);
        company.setTitle("DATAAA");
        
        Result result = new Result();
    
        IDataProvider dp = new DataProviderH2();
        result = dp.updateCompany(company);
        
        System.out.println(result);
    }
    
    @Test
    public void testUpdateVacancy() {
        System.out.println("test UpdateVacancy h2");
        Vacancy vacancy = new Vacancy();
        
        vacancy.setId(1);
        vacancy.setCompanyId(1);
        vacancy.setTitle("JAAAAAAAVAAAAAAAa");
        vacancy.setSalary(11);
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderH2();
        result = dp.updateVacancy(vacancy);
        
        System.out.println(result);
    }
    
    @Test
    public void testUpdateSeparateQual() {
        System.out.println("test UpdateSeparateQual h2");
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setId(1);
        separateQual.setCompanyId(1);
        separateQual.setEmployeeId(1);
        separateQual.setQuality(10);
        separateQual.setDescription("nice");
        
        Result result = new Result();
    
        IDataProvider dp = new DataProviderH2();
        result = dp.updateSeparateQual(separateQual);
        
        System.out.println(result);
    }
    
    @Test
    public void testDeleteClient() {
        System.out.println("test DeleteClient h2");
        int id = 1;
        IDataProvider dp = new DataProviderH2();
        Result result = dp.deletePerson(id, TypePerson.ClientType);
        System.out.println(result);
    }
    
    @Test
    public void testDeleteEmployee() {
        System.out.println("test DeleteEmployee h2");
        int id = 1;
        IDataProvider dp = new DataProviderH2();
        Result result = dp.deletePerson(id, TypePerson.EmployeeType);
        System.out.println(result);
    }
    
    @Test
    public void testDeleteResume() {
        System.out.println("test DeleteResume h2");
        int id = 4;
        IDataProvider dp = new DataProviderH2();
        Result result = dp.deleteResume(id);
        System.out.println(result);
    }
    
    @Test
    public void testDeleteCompany() {
        System.out.println("test DeleteCompany h2");
        int id = 1;
        IDataProvider dp = new DataProviderH2();
        Result result = dp.deleteCompany(id);
        System.out.println(result);
    }
    
    @Test
    public void testDeleteVacancy() {
        System.out.println("test DeleteVacancy h2");
        int id = 4;
        IDataProvider dp = new DataProviderH2();
        Result result = dp.deleteVacancy(id);
        System.out.println(result);
    }
    
    @Test
    public void testDeleteSeparateQual() {
        System.out.println("test DeleteSeparateQual h2");
        int id = 3;
        IDataProvider dp = new DataProviderH2();
        Result result = dp.deleteSeparateQual(id);
        System.out.println(result);
    }
}
