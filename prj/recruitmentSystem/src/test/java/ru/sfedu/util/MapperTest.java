/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.util;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.sfedu.model.*;

/**
 *
 * @author mike
 */
public class MapperTest {
    @Test
    public void testGetInstance() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("test GetInstance");
        String[] values = {"0","Sasha","20","9990","zorge 28/2"};
        Mapper<Person> mapping = new Mapper<Person>();
        System.out.println(mapping.getInstance(Person.class, values));
    }
    
}
