package ru.sfedu.lab4.map.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import ru.sfedu.lab4.map.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HibernateDataProviderTest {
    
    private static final Logger log = LogManager.getLogger(HibernateDataProviderTest.class.getName());
    
    private static HibernateDataProvider dp = new HibernateDataProvider();
    
    @Order(1)
    @Test
    public void testSaveClientMap(){
        log.debug("testSaveClientMap [1]: test save client");
        
        log.debug("testSaveClientMap [2]: create client");
        Client client = new Client();
        
        //person fields
        client.setName("Mike");
        client.setSurname("Seleznev");
        client.setMiddleName("Mikhal");
        client.setAge(20);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("mseleznev@sfedu.ru");
        client.setTypePerson(TypePerson.ClientType);
        
        //client fields
        client.setPassword("pipi");
        client.setAddress("Zorge 28/2");
        
        log.debug("testSaveClientMap [3]: client was created, client = {}", client);
        
        
        log.debug("testSaveClientMap [4]: create resume");
        
        //create resumes
        Map<String, Resume> resumes = new HashMap<>();
        Resume resume1 = new Resume();
        resume1.setId(1);
        resume1.setCity("1");
        resume1.setProfession("1");
        resume1.setSkills("OOP, SOAP");
        resume1.setEducation("3 years graduation");
        resume1.setExperience("3 years as manager");
        resume1.setSex(true);
        resume1.setWorkPermit(true);
        resume1.setCitizenship("1");
        
        Resume resume2 = new Resume();
        resume2.setId(2);
        resume2.setCity("2");
        resume2.setProfession("2");
        resume2.setSkills("OOP, SOAP");
        resume2.setEducation("3 years graduation");
        resume2.setExperience("3 years as manager");
        resume2.setSex(true);
        resume2.setWorkPermit(true);
        resume2.setCitizenship("2");
        
        log.debug("testSaveClientMap [5]: resumes were created, resume1 = {}, resume2 = {}", resume1, resume2);

        resumes.put("1", resume1);
        resumes.put("2", resume2);
    
        client.setResumes(resumes);
        
        log.debug("testSaveClientMap [6]: resumes added to client");
        
        try{
            log.debug("testSaveClientMap [7]: saving client, client = {}", client);
            dp.saveRecord(client);
            log.debug("testSaveClientMap [8]: client saved succesful");
        } catch(Exception ex){
            log.debug("testSaveClientMap [9]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }
    
    @Order(2)
    @Test
    public void testUpdateClient(){
        log.debug("testUpdateClient [1]: test update client");
        
        log.debug("testUpdateClient [2]: get client");
        try {
            //Client client = new Client();
            Client client = (Client) dp.getRecord(Client.class, "1");

            //person fields
            //client.setId(1);
            client.setName("CHANGE");
            client.setSurname("CHANGE");
            client.setMiddleName("CHANGE");
            client.setAge(20);
            client.setBirthday("12-06-2003");
            client.setPhone("CHANGE");
            client.setEmail("mseleznev@sfedu.ru");
            client.setTypePerson(TypePerson.ClientType);

            //client fields
            client.setPassword("pipi");
            client.setAddress("Zorge 28/2");

            log.debug("testUpdateClient [3]: client was created, client = {}", client);

            log.debug("testUpdateClient [4]: saving client, client = {}", client);
            dp.updateRecord(client);
            log.debug("testUpdateClient [5]: client saved succesful");

        } catch(Exception ex) {
            log.debug("testUpdateClient [6]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }
    
    @Order(3)
    @Test
    public void testGetClient(){
        log.debug("testGetClient [1]: test update client");
        try{
            Client client = (Client) dp.getRecord(Client.class, "1");
            log.debug("testGetClient [2]: client was got succesful, client = {}", client);
            
            log.debug("testGetClient [3]: resumes of the client: ");
            client.getResumes().values().forEach(System.out::println);

        } catch(Exception ex){
            log.debug("testUpdateClient [4]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }
    
    @Order(4)
    @Test
    public void testDeleteClient(){
        try{
            log.debug("testDeleteClient [1]: test delete client");
            dp.deleteRecord(dp.getRecord(Client.class, "1"));
            log.debug("testDeleteClient [1]: client was deleted succesful");
            
        } catch(Exception ex){
            log.debug("testDeleteClient [2]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }
}
