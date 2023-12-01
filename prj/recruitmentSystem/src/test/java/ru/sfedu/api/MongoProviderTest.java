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

import ru.sfedu.model.*;

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
        
        p.setAge("99");
        p.setId("111");
        p.setName("name");
        
        MongoProvider.save(command, repositoryType, p);
    }
    
    @Test
    public void testSaveUpdatedPerson() {
        System.out.println("test SaveUpdatedPerson");
        
        CommandType command = CommandType.UPDATED;
        RepositoryType repositoryType = RepositoryType.CSV;
        Person p = new Person();
        
        p.setAge("99");
        p.setId("111");
        p.setName("MikeYes");
        
        MongoProvider.save(command, repositoryType, p);
    }
    
}
