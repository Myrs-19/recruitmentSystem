/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.util;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import ru.sfedu.model.*;

/**
 *
 * @author mike
 */
public class MapperTest {
    @Test
    public void testGetInstancePerson() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("test GetInstancePerson");
        String[] values = {"0","Sasha","20","9990","zorge 28/2"};
        BeanUtil<Person> mapping = new BeanUtil<Person>();
    }

}
