/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import java.sql.*;

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
        
        employee.setCompanyId(1);
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
        
        resume.setClientId(1);
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
        
        vacancy.setCompanyId(1);
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
        
        separateQual.setCompanyId(1);
        separateQual.setEmployeeId(1);
        separateQual.setQuality(7);
        
        IDataProvider dp = new DataProviderH2();
        Result result = dp.saveSeparateQual(separateQual);
       
        System.out.println(result);
    }
    
    @Test
    public void testGetClientByIdPositive(){
        testSaveClient();
        System.out.println("test GetClientById positive");
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
       
        System.out.println("test GetClientById negative");
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
        System.out.println("test getResumeById positive");
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
    
        System.out.println("test getResumeById negative");
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
        System.out.println("test getCompanyById positive");
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
       
        System.out.println("test getCompanyById negative");
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
        System.out.println("test getVacancyById positive");
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
        
        System.out.println("test getVacancyById negative");
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
        System.out.println("test getEmployeeById positive");
        try{
            int id = 1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getEmployee(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    public void testGetEmployeeByIdNegative(){
       
        System.out.println("test getEmployeeById negative");
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
        System.out.println("test getSeparateQualById positive");
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
        
        System.out.println("test getSeparateQualById negative");
        try{
            int id = -1;
            IDataProvider dp = new DataProviderH2();
            System.out.println(dp.getSeparateQual(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
}
