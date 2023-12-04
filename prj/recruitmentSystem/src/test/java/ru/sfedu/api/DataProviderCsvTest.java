/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import ru.sfedu.model.*;
/**
 *
 * @author mike
 */
public class DataProviderCsvTest {
    
    @Test
    public void testDataProviderCsv(){
        System.out.println("test DataProviderCsv");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
        } catch(Exception ex){
            fail("Error creating object of DataProviderCsv class");
        }
    }

    /**
     * Test of saveRecord method, of class DataProviderCsv.
     */
    @Test
  public void testSaveRecordsPerson(){
        System.out.println("test SaveRecordsPerson");
            try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                User p = new User();
                p.setAge("age");
                p.setBirthday("birthday");
                p.setMiddleName("middile name");
                p.setName("name");
                p.setSurname("surname");
                p.setPassword("pass");
                p.setPhone("phone");
                p.setEmail("email");
                p.setAddress("add");
                dataProvider.saveRecord(p);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordsUser(){
        System.out.println("test SaveRecordsUser");
            try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                User u = new User();
                u.setName("name");
                u.setSurname("surname");
                u.setEmail("email");
                u.setPhone("phone");
                u.setPassword("password");
                dataProvider.saveRecord(u);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    /**
     * Test of getRecordByID method, of class DataProviderCsv.
     */
    @Test
    public void testGetRecordByID() {
        try{
            String id = "0";
            System.out.println("test GetRecordByID User, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            User p = (User) dataProvider.getRecordByID(id, User.class);
            
            System.out.println(p);
        } catch (Exception ex){
            fail("Person" + ex.getMessage());
        }
    }

    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordPerson() {
        System.out.println("test GetAllRecordPerson");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<Person> persons = dataProvider.getAllRecord(Person.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordPerson" + ex.getMessage());
        }
    }
    
    
    @Test
    public void testUpdateRecordByIdPerson(){
        System.out.println("test ChangeRecordByIdPerson");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            Person p = new Person();
            p.setId("2");
            dataProvider.updateRecordById(p.getId(), p);
            
        } catch(Exception ex){
            fail("test ChangeRecordByIdPerson" + ex.getMessage());
        }
    }
    
    @Test
    public void testDeleteRecordPerson() {
        try{
            System.out.println("test DeleteRecordPerson");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("3", Person.class);
            
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }

}
