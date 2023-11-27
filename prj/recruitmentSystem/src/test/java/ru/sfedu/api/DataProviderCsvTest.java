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

import org.junit.jupiter.api.Test;

import ru.sfedu.model.*;
/**
 *
 * @author mike
 */
public class DataProviderCsvTest {
    

    /**
     * Test of initDataProviter method, of class DataProviderCsv.
     */
    @Test
    public void testInitDataProviter(){
    }

    /**
     * Test of saveRecord method, of class DataProviderCsv.
     */
    @Test
    public void testSaveRecordPerson(){
        DataProviderCsv<Person> dataProvider = new DataProviderCsv<Person>();
        
        System.out.println("saveRecord");
        for(int i = 0; i < 3; i++){
            Person p = new Person(""+ i, "Sasha", "20" + i, "999" + i, "zorge 28/2");
            dataProvider.saveRecord(p);
        }
    }
    
    @Test
    public void testSaveRecordTestBean(){
        DataProviderCsv<TestBean> dataProvider = new DataProviderCsv<TestBean>();
        
        System.out.println("saveRecord");
        for(int i = 0; i < 3; i++){
            TestBean p = new TestBean("" + i, "Mike" + i, "sel", "Miks");
            dataProvider.saveRecord(p);
        }
    }

    /**
     * Test of getRecordByID method, of class DataProviderCsv.
     */
    @Test
    public void testGetRecordByID() {
        System.out.println("test GetRecordByID Person");
        String id = "0";
        IDataProvider<Person> dataProvider = new DataProviderCsv<Person>();
        Person p = (Person) dataProvider.getRecordByID(id, Person.class);
        System.out.println(p);
        
        System.out.println("test GetRecordByID TestBean");
        id = "0";
        IDataProvider<TestBean> dataProvider1 = new DataProviderCsv<TestBean>();
        TestBean t = (TestBean) dataProvider1.getRecordByID(id, TestBean.class);
        System.out.println(t);
    }

    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordPerson() {
        System.out.println("testGetAllRecordPerson");
        
        IDataProvider<Person> dataProvider = new DataProviderCsv<Person>();
        List<Person> persons = dataProvider.getAllRecord(Person.class);
        persons.forEach(it -> System.out.println(it));

    }
    
    @Test
    public void testGetAllRecordTestBean() {
        System.out.println("testGetAllRecordTestBean");
        
        IDataProvider<TestBean> dataProvider = new DataProviderCsv<TestBean>();
        List<TestBean> persons = dataProvider.getAllRecord(TestBean.class);
        persons.forEach(it -> System.out.println(it));

    }
    
    @Test
    public void testPrint(){
        
    }
        
    /**
     * Test of deleteRecord method, of class DataProviderCsv.
     */
    @Test
    public void testDeleteRecord() {
        
    }
}
