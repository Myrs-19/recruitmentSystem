/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import java.util.List;
import org.junit.jupiter.api.Assertions;
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
        
        DataProviderCsv dp = new DataProviderCsv();
        dp.savePerson(person);
        
    }
    
    @Test
    void testSavePersonEmployee(){
        Employee person = new Employee();
        person.setTypePerson(TypePerson.EmployeeType);
        person.setName("Mike");
        person.setSalary("98988");
        
        DataProviderCsv dp = new DataProviderCsv();
        dp.savePerson(person);
        
    }
    
    @Test
    void testSaveResume(){
        Resume resume = new Resume();
        resume.setUserId("0");
        resume.setCity("rostov");
        resume.setProfession("Prod");
        
        DataProviderCsv dp = new DataProviderCsv();
        dp.saveResume(resume);   
    }
    
    @Test
    void testSaveCompany(){
        Company company = new Company();
        company.setUserId("0");
        company.setTitle("arenadata");
        
        DataProviderCsv dp = new DataProviderCsv();
        dp.saveCompany(company);
    }
    
    @Test
    void testSaveVacancy(){
        Vacancy vacancy = new Vacancy();
        vacancy.setCompanyId("0");
        vacancy.setTitle("junior");
        vacancy.setSalary("878778");
        
        DataProviderCsv dp = new DataProviderCsv();
        dp.saveVacancy(vacancy);
    }
    
    @Test
    void testSaveSeparateQual(){
        SeparateQual separateQual = new SeparateQual();
        separateQual.setCompanyId("0");
        separateQual.setEmployeeId("0");
        separateQual.setQuality("120");
        
        DataProviderCsv dp = new DataProviderCsv();
        dp.saveSeparateQual(separateQual);
    }
}
