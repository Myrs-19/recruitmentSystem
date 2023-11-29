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
    public void testGetInstancePerson() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("test GetInstancePerson");
        String[] values = {"0","Sasha","20","9990","zorge 28/2"};
        Mapper<Person> mapping = new Mapper<Person>();
        System.out.println(mapping.getInstance(Person.class, values));
    }
    
    @Test
    public void testGetInstanceTestBean() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("test GetInstanceTestBean");
        String[] values = {"0","Mike0","sel","Miks"};
        Mapper<TestBean> mapping = new Mapper<TestBean>();
        System.out.println(mapping.getInstance(TestBean.class, values));
    }
    
    /**
     *
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @Test
    public void getIdInstanceTestBean() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("test getIdInstanceTestBean");
        TestBean tb = new TestBean("Mike0","sel","Miks");
        Mapper<TestBean> mapping = new Mapper<TestBean>();
        System.out.println(mapping.getIdInstance(tb));
    }
    
    @Test
    public void testSetIdInstanceTestBean(){
        System.out.println("test SetIdInstanceTestBean");
        
        Mapper<TestBean> mapping = new Mapper<TestBean>();
        TestBean tb = new TestBean("Mike0","sel","Miks");
        String id = "5";
        
        mapping.setIdInstance(tb, id);
    
        System.out.println("id = " + tb.getId());
    }
}
