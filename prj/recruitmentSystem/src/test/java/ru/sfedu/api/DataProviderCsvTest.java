/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.sfedu.Constants;

import ru.sfedu.model.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataProviderCsvTest {
    
//    @Test
//    void testGetId(){
//        System.out.println("test DataProviderCsv getId");
//        DataProviderCsv dp = new DataProviderCsv();
//        String path = dp.getPath(Constants.CSV_TITLE_TABLE_PERSON);
//        String id = dp.getId(path);
//        System.out.println("*** id = " + id);
//    }
    
    @Test
    void testSavePersonUser(){
        User person = new User();
        person.setTypePerson(TypePerson.UserType);
        person.setName("Mike");
        person.setEmail("m@m.ru");
        person.setPhone("999");
        person.setAddress("zorge");
        
        IDataProvider dp = new DataProviderCsv();
        Result result = dp.savePerson(person);
        System.out.println(result);
    }
    
    @Test
    void testSavePersonEmployee(){
        Employee person = new Employee();
        person.setTypePerson(TypePerson.EmployeeType);
        person.setName("Mike");
        person.setSalary("98988");
        
        DataProviderCsv dp = new DataProviderCsv();
        Result result = dp.savePerson(person);
        System.out.println(result);
    }
    
    @Test
    void testSaveResume(){
        Resume resume = new Resume();
        resume.setUserId("0");
        resume.setCity("rostov");
        resume.setProfession("Prod");
        
        DataProviderCsv dp = new DataProviderCsv();
        Result result = dp.saveResume(resume);   
        System.out.println(result);
    }
    
    @Test
    void testSaveCompany(){
        Company company = new Company();
        company.setUserId("0");
        company.setTitle("arenadata");
        
        DataProviderCsv dp = new DataProviderCsv();
        Result result = dp.saveCompany(company);
        System.out.println(result);
    }
    
    @Test
    void testSaveVacancy(){
        Vacancy vacancy = new Vacancy();
        vacancy.setCompanyId("0");
        vacancy.setTitle("junior");
        vacancy.setSalary("878778");
        
        DataProviderCsv dp = new DataProviderCsv();
        Result result = dp.saveVacancy(vacancy);
        System.out.println(result);
    }
    
    @Test
    void testSaveSeparateQual(){
        SeparateQual separateQual = new SeparateQual();
        separateQual.setCompanyId("0");
        separateQual.setEmployeeId("0");
        separateQual.setQuality("120");
        
        DataProviderCsv dp = new DataProviderCsv();
        Result result = dp.saveSeparateQual(separateQual);
        System.out.println(result);
    }
    
    @Test
    void testGetUserPositive(){
        String id = "0";
        
        DataProviderCsv dp = new DataProviderCsv();
        try{
            User user = dp.getUser(id);
            System.out.println(user);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetUserNegative(){
        String id = "-1";
        try{
            DataProviderCsv dp = new DataProviderCsv();
            User user = dp.getUser(id);
            System.out.println(user);   
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
        
    @Test
    void testGetResumePositive(){
        String id = "0";
        
        try{
            DataProviderCsv dp = new DataProviderCsv();
            Resume resume = dp.getResume(id);
            System.out.println(resume);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetResumeNegative(){
        String id = "-1";
        
        try{
            DataProviderCsv dp = new DataProviderCsv();
            Resume resume = dp.getResume(id);
            System.out.println(resume);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetCompanyPositive(){
        String id = "0";
        
        try{
            DataProviderCsv dp = new DataProviderCsv();
            Company company = dp.getCompany(id);
            System.out.println(company);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetCompanyNegative(){
        String id = "-1";
        try{
            DataProviderCsv dp = new DataProviderCsv();
            Company company = dp.getCompany(id);
            System.out.println(company);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetVacancyPositive(){
        String id = "0";
        try{    
            DataProviderCsv dp = new DataProviderCsv();
            Vacancy vacancy = dp.getVacancy(id);
            assertEquals(vacancy.getId(), id);
            System.out.println(vacancy);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetVacancyNegative(){
        String id = "-1";
        try{
            DataProviderCsv dp = new DataProviderCsv();
            Vacancy vacancy = dp.getVacancy(id);
            System.out.println(vacancy);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetEmployeePositive(){
        String id = "0";
        
        try{
            DataProviderCsv dp = new DataProviderCsv();
            Employee employee = dp.getEmployee(id);
            System.out.println(employee);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetEmployeeNegative(){
        String id = "-1";
        try{
            DataProviderCsv dp = new DataProviderCsv();
            Employee employee = dp.getEmployee(id);
            System.out.println(employee);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetSeparateQualPositive(){
        String id = "0";
        try{
            DataProviderCsv dp = new DataProviderCsv();
            SeparateQual separateQual = dp.getSeparateQual(id);
            System.out.println(separateQual);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetSeparateQualNigga(){
        String id = "-1";
        
        try{
            DataProviderCsv dp = new DataProviderCsv();
            SeparateQual separateQual = dp.getSeparateQual(id);
            System.out.println(separateQual);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetAllUsers(){
        try{
            DataProviderCsv dp = new DataProviderCsv();
            dp.getAllUsers().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testGetAllResumes(){
        try{
            DataProviderCsv dp = new DataProviderCsv();
            dp.getAllResumes().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testgetAllCompanies(){
        try{
            DataProviderCsv dp = new DataProviderCsv();
            dp.getAllCompanies().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testgetAllVacancies(){
        try{
            DataProviderCsv dp = new DataProviderCsv();
            dp.getAllVacancies().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testgetAllEmployees(){
        try{
            DataProviderCsv dp = new DataProviderCsv();
            dp.getAllEmployees().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testgetAllSeparateQuals(){
        try{
            DataProviderCsv dp = new DataProviderCsv();
            dp.getAllSeparateQuals().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testUpdateUser(){
        try{
            User user = new User();
            user.setTypePerson(TypePerson.UserType);
            user.setId("0");
            user.setName("MIMIMI");
            
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.updatePerson(user);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void testUpdateResume(){
        try{
            Resume resume = new Resume();
            resume.setId("0");
            resume.setUserId("0");
            resume.setCity("rostov");
            resume.setProfession("Director");
            
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.updateResume(resume);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testUpdateCompany(){
        try{
            Company company = new Company();
            company.setId("0");
            company.setUserId("0");
            company.setTitle("IRIIRIRI");
            
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.updateCompany(company);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testUpdateVacancy(){
        try{
            Vacancy vacancy = new Vacancy();
            vacancy.setId("0");
            vacancy.setCompanyId("0");
            vacancy.setTitle("developer");
            vacancy.setSalary("35000");
                    
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.updateVacancy(vacancy);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testUpdateSeparateQual(){
        try{
            SeparateQual separateQual = new SeparateQual();
            separateQual.setId("0");
            separateQual.setCompanyId("0");
            separateQual.setEmployeeId("0");
            separateQual.setQuality("-10");
                    
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.updateSeparateQual(separateQual);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testDeleteUser(){
        try{
            String id = "0";
                    
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.deletePerson(id, TypePerson.UserType);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testDeleteEmployee(){
        try{
            String id = "0";
                    
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.deletePerson(id, TypePerson.EmployeeType);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testDeleteResume(){
        try{
            String id = "0";
                    
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.deleteResume(id);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testDeleteCompany(){
        try{
            String id = "0";
                    
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.deleteCompany(id);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testDeleteVacancy(){
        try{
            String id = "0";
                    
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.deleteVacancy(id);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    void testDeleteSeparateQual(){
        try{
            String id = "0";
                    
            DataProviderCsv dp = new DataProviderCsv();
            Result res = dp.deleteSeparateQual(id);
            assertEquals(Constants.CODE_SUCCESS, res.getCode());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
