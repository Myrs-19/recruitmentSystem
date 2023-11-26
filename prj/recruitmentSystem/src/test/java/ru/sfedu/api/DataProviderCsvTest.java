/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ru.sfedu.model.Person;
import ru.sfedu.api.DataProviderCsv;
/**
 *
 * @author mike
 */
public class DataProviderCsvTest {
    
    public DataProviderCsvTest() {
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

    /**
     * Test of initDataProviter method, of class DataProviderCsv.
     */
    @Test
    public void testInitDataProviter() throws Exception {
        System.out.println("initDataProviter");
        DataProviderCsv instance = null;
        instance.initDataProviter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveRecord method, of class DataProviderCsv.
     */
    @Test
    public void testSaveRecord() throws Exception {
        System.out.println("saveRecord");
        IDataProvider dataProvider = new DataProviderCsv();
        for(int i = 0; i < 3; i++){
            Person p = new Person(i, "Sasha", 20 + i, "999" + i, "zorge 28/2");
            dataProvider.saveRecord(p);
        }
        
    }

    /**
     * Test of deleteRecord method, of class DataProviderCsv.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");
        Object obj = null;
        DataProviderCsv instance = null;
        instance.deleteRecordById(0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecordByID method, of class DataProviderCsv.
     */
    @Test
    public void testGetRecordByID() {
        System.out.println("getRecordByID");
        DataProviderCsv instance = null;
        Object expResult = null;
        Object result = instance.getRecordByID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecord() {
        System.out.println("getAllRecord");
        DataProviderCsv instance = null;
        Object[] expResult = null;
        Object[] result = instance.getAllRecord();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
