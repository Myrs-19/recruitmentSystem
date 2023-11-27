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

import ru.sfedu.model.Person;
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
    public void testSaveRecord(){
        DataProviderCsv<Person> dataProvider = new DataProviderCsv<Person>();
        
        System.out.println("saveRecord");
        for(int i = 0; i < 3; i++){
            Person p = new Person(""+ i, "Sasha", "20" + i, "999" + i, "zorge 28/2");
            dataProvider.saveRecord(p);
        }
    }

    /**
     * Test of getRecordByID method, of class DataProviderCsv.
     */
    @Test
    public void testGetRecordByID() {
    }

    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("testGetAllRecord");
        
        IDataProvider<Person> dataProvider = new DataProviderCsv<Person>();
        List<Person> persons = dataProvider.getAllRecord(Person.class);
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
