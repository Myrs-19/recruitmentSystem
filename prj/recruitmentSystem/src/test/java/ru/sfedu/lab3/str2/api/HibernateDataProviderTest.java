package ru.sfedu.lab3.str2.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import ru.sfedu.lab3.str2.model.Client;
import ru.sfedu.lab3.str2.model.Company;
import ru.sfedu.lab3.str2.model.Employee;
import ru.sfedu.lab3.str2.model.TypePerson;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HibernateDataProviderTest {
    
    private static final Logger log = LogManager.getLogger(HibernateDataProviderTest.class.getName());
    
    private static HibernateDataProvider dp = new HibernateDataProvider();
    
    @Order(1)
    @Test
    public void testSaveClient(){
        log.debug("testSaveClient [1]: test save client");
        
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
        
        log.debug("testSaveClient [2]: filled object, client = {}", client);
        
        try{
            log.debug("testSaveClient [3]: save client");
            
            dp.saveRecord(client);
            
            log.debug("testSaveClient [4]: client has been saved");
        } catch(Exception ex){
            log.error("testSaveClient [4]: error = {}", ex.getMessage());
            
            fail(ex.getMessage());
        }
    }
    
    @Order(2)
    @Test
    public void testUpdateClient(){
        log.debug("testUpdateClient [1]: test update client");
        
        Client client = new Client();
        
        //update - is not MERGE
        
        //person fields
        client.setId(1);
        client.setName("Mikhail");
        client.setSurname("Seleznev");
        client.setMiddleName("Mikhal");
        client.setAge(20);
        client.setBirthday("12-06-2098");
        client.setPhone("89996940159");
        client.setEmail("mseleznev@ruru.ru");
        client.setTypePerson(TypePerson.ClientType);
        
        //client fields
        client.setPassword("pipi");
        client.setAddress("Zorge 655 55/2");
        
        log.debug("testUpdateClient [2]: filled object, client = {}", client);
        
        try{
            log.debug("testUpdateClient [3]: update client");
            
            dp.updateRecord(client);
            
            log.debug("testUpdateClient [4]: client has been updated");
        } catch(Exception ex){
            log.error("testUpdateClient [4]: error = {}", ex.getMessage());
            
            fail(ex.getMessage());
        }
    }
    
    @Order(3)
    @Test
    public void testGetClient(){
        try{
            log.debug("testGetClient [1]: test get client");
            
            Client client = (Client) dp.getRecord(Client.class, "1");
            
            log.debug("testGetClient [2]: client has been got, client = {}", client);
        
            assertEquals(client.getId(), 1);
        } catch(Exception ex){
            log.error("testGetClient [3]: error = {}", ex.getMessage());
            
            fail(ex.getMessage());
        }
    }

    @Order(4)
    @Test
    public void testDeleteClient(){
        try{
            log.debug("testDeleteClient [1]: test delete client");
            
            Client client = (Client) dp.getRecord(Client.class, "1");
            
            dp.deleteRecord(client);
            
            log.debug("testDeleteClient [2]: client has been deleted, client = {}", client);
        
//            System.out.println(dp.getRecord(Client.class, "1"));
            
//            assertEquals(client.getId(), 1);
        } catch(Exception ex){
            log.error("testDeleteClient [3]: error = {}", ex.getMessage());
            
            fail(ex.getMessage());
        }
    }
    
    
    @Order(5)
    @Test
    public void testSaveEmployee(){
        log.debug("testSaveEmployee [1]: test save employee");
        
        Employee employee = new Employee();
        
        //person fields
        employee.setName("Mike");
        employee.setSurname("Seleznev");
        employee.setMiddleName("Mikhal");
        employee.setAge(20);
        employee.setBirthday("12-06-2003");
        employee.setPhone("89996940159");
        employee.setEmail("mseleznev@sfedu.ru");
        employee.setTypePerson(TypePerson.ClientType);
        
        //employee fields
        
        Company company = new Company();
        
        company.setDescription("IT");
        company.setId(1);
        company.setTitle("Anarisuto");
        
        
        employee.setCompany(company);
        employee.setSalary(20000);
        employee.setPosition("Developer");
        employee.setIsWorking(true);
        
        log.debug("testSaveEmployee [2]: filled object, employee = {}", employee);
        
        try{
            log.debug("testSaveEmployee [3]: save employee");
            
            dp.saveRecord(employee);
            
            log.debug("testSaveEmployee [4]: employee has been saved");
        } catch(Exception ex){
            log.error("testSaveEmployee [4]: error = {}", ex.getMessage());
            
            fail(ex.getMessage());
        }
    }
    
    @Order(6)
    @Test
    public void testUpdateEmployee(){
        log.debug("testUpdateEmployee [1]: test update employee");
        
        Employee employee = new Employee();
        
        //person fields
        employee.setId(1);
        employee.setName("Mike");
        employee.setSurname("MIMIMIMI");
        employee.setMiddleName("Mikhal");
        employee.setAge(202);
        employee.setBirthday("12-06-2003");
        employee.setPhone("89996940159");
        employee.setEmail("mseleznev@sfedu.ru");
        employee.setTypePerson(TypePerson.ClientType);
        
        //employee fields
        
        Company company = new Company();
        
        company.setDescription("IT");
        company.setId(1);
        company.setTitle("Anarisuto");
        
        
        employee.setCompany(company);
        employee.setSalary(20000);
        employee.setPosition("ANALITIK");
        employee.setIsWorking(true);
        
        log.debug("testUpdateEmployee [2]: filled object, employee = {}", employee);
        
        try{
            log.debug("testUpdateEmployee [3]: update employee");
            
            dp.updateRecord(employee);
            
            log.debug("testUpdateEmployee [4]: employee has been updated");
        } catch(Exception ex){
            log.error("testUpdateEmployee [4]: error = {}", ex.getMessage());
            
            fail(ex.getMessage());
        }
    }
    
    @Order(7)
    @Test
    public void testGetEmployee(){
        try{
            log.debug("testGetEmployee [1]: test get employee");
            
            Employee employee = (Employee) dp.getRecord(Employee.class, "1");
            
            log.debug("testGetEmployee [2]: employee has been got, client = {}", employee);
        
            assertEquals(employee.getId(), 1);
        } catch(Exception ex){
            log.error("testGetEmployee [3]: error = {}", ex.getMessage());
            
            fail(ex.getMessage());
        }
    }

    @Order(8)
    @Test
    public void testDeleteEmployee(){
        try{
            log.debug("testDeleteEmployee [1]: test delete employee");
            
            Employee employee = (Employee) dp.getRecord(Employee.class, "1");
            
            dp.deleteRecord(employee);
            
            log.debug("testDeleteEmployee [2]: employee has been deleted, employee = {}", employee);
        
//            System.out.println(dp.getRecord(Client.class, "1"));
            
//            assertEquals(client.getId(), 1);
        } catch(Exception ex){
            log.error("testDeleteEmployee [3]: error = {}", ex.getMessage());
            
            fail(ex.getMessage());
        }
    }
    
}
