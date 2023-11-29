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
import ru.sfedu.model.CommandType;
import ru.sfedu.model.Person;
import ru.sfedu.model.RepositoryType;
import ru.sfedu.model.TestBean;

/**
 *
 * @author mike
 */
public class MongoProviderTest {
    

    @Test
    public void testSaveDeletedPerson() {
        System.out.println("test SaveUpdatedPerson");
        
        CommandType command = CommandType.DELETED;
        RepositoryType repositoryType = RepositoryType.CSV;
        Person p = new Person();
        
        p.setAddress("address");
        p.setAge("99");
        p.setId("111");
        p.setName("name");
        p.setPhone("90099");
        
        MongoProvider.save(command, repositoryType, p);
    }
    
    @Test
    public void testSaveUpdatedPerson() {
        System.out.println("test SaveUpdatedPerson");
        
        CommandType command = CommandType.UPDATED;
        RepositoryType repositoryType = RepositoryType.CSV;
        Person p = new Person();
        
        p.setAddress("address");
        p.setAge("99");
        p.setId("111");
        p.setName("MikeYes");
        p.setPhone("99999999");
        
        MongoProvider.save(command, repositoryType, p);
    }
    
    @Test
    public void testSaveUpdatedTestBean() {
        System.out.println("test SaveUpdatedTestBean");
        
        CommandType command = CommandType.UPDATED;
        RepositoryType repositoryType = RepositoryType.CSV;
        TestBean p = new TestBean();
        
        p.setId("1212");
        p.setMiddleName("MIKEMIKE");
        p.setName("ANOTHERYEAR");
        p.setSurname("YRYRYRYRY");
        
        MongoProvider.save(command, repositoryType, p);
    }
    
    @Test
    public void testSaveDeletedTestBean() {
        System.out.println("test SaveDeletedTestBean");
        
        CommandType command = CommandType.DELETED;
        RepositoryType repositoryType = RepositoryType.CSV;
        TestBean p = new TestBean();
        
        p.setId("33131");
        p.setMiddleName("EKIMEKIM");
        p.setName("reay");
        p.setSurname("ROR:A:");
        
        MongoProvider.save(command, repositoryType, p);
    }
    
}
