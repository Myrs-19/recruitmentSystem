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
                Person p = new Person(""+ i, "Sasha", "20" + i, "999" + i, "zorge 28/2");
                dataProvider.saveRecord(p);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordsTestBean(){
        System.out.println("test SaveRecordsTestBean");
        try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                TestBean p = new TestBean("" + i, "Mike" + i, "sel", "Miks");
                dataProvider.saveRecord(p);
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
            System.out.println("test GetRecordByID Person, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            Person p = (Person) dataProvider.getRecordByID(id, Person.class);
            
            System.out.println(p);
        } catch (Exception ex){
            fail("Person" + ex.getMessage());
        }
        
        try{
            String id = "0";
            System.out.println("test GetRecordByID TestBean, id = " + id);
            IDataProvider dataProvider1 = new DataProviderCsv();
            TestBean t = (TestBean) dataProvider1.getRecordByID(id, TestBean.class);
            System.out.println(t);
        } catch (Exception ex){
            fail("TestBean" + ex.getMessage());
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
    public void testGetAllRecordTestBean() {
        System.out.println("test GetAllRecordTestBean");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<TestBean> persons = dataProvider.getAllRecord(TestBean.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordTestBean" + ex.getMessage());
        }
    }
    
    @Test
    public void testUpdateRecordByIdPerson(){
        System.out.println("test ChangeRecordByIdPerson");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            Person p = new Person("2", "кака", "20", "9090", "Zorge");
            dataProvider.updateRecordById(p.getId(), p);
            
        } catch(Exception ex){
            fail("test ChangeRecordByIdPerson" + ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordPersonForUpdating(){
        try{
            System.out.println("test SaveRecordPersonForChanging");
            DataProviderCsv dataProvider = new DataProviderCsv();

            Person p = new Person("5", "Mike", "25", "969696", "zorge 68");
            dataProvider.saveRecord(p);
            
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testDeleteRecordPerson() {
        try{
            System.out.println("test DeleteRecordPerson");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("2", Person.class);
            
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
//    @Test
//    public void testgetId() {
//        try{
//            System.out.println("test getId Person");
//            DataProviderCsv dataProvider = new DataProviderCsv();
//            String id = dataProvider.getId(Person.class);
//            System.out.println("id = " + id);
//        } catch (Exception ex){
//            fail(ex.getMessage());
//        }
//    }
}
