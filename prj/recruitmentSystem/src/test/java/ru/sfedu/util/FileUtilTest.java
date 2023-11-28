/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.sfedu.Constants;

/**
 *
 * @author mike
 */
public class FileUtilTest {
    
    public FileUtilTest() {
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
     * Test of createFolderIfNotExists method, of class FileUtil.
     */
    @Test
    public void testCreateFolderIfNotExists(){
        System.out.println("test сreateFolderIfNotExists");
        try{
            String folderPath = Constants.CSV_PATH_FOLDER;
            FileUtil.createFolderIfNotExists(folderPath);
        } catch(Exception ex){
            fail("ошибка создания директории");
        }
        
    }
    
}