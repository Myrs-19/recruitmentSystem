package ru.sfedu.lab4.map.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import ru.sfedu.lab4.map.model.*;

import java.util.HashMap;
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

    @Order(5)
    @Test
    public void testSaveCompany(){
        log.debug("testSaveCompany [1]: test save a company, create Company instance");
         Company company = new  Company();

        company.setTitle("Anarisuto");
        company.setDescription("DATA ENGINEERS");

        log.debug("testSaveCompany [2]: create Vacancy instanceses");
        //create vacancies
         Vacancy vacancy1 = new  Vacancy();
        vacancy1.setId(1);
        vacancy1.setTitle("java");
        vacancy1.setSpecialization("java");
        vacancy1.setOnline(false);
        vacancy1.setSkills("OOP");
        vacancy1.setSalary(35000);
        vacancy1.setCity("Rostov");
        vacancy1.setAddress("Center of Rostov");
        vacancy1.setExperience("1 years");

         Vacancy vacancy2 = new  Vacancy();

        vacancy2.setId(2);
        vacancy2.setTitle("jav2a");
        vacancy2.setSpecialization("jav2a");
        vacancy2.setOnline(false);
        vacancy2.setSkills("OO2P");
        vacancy2.setSalary(350200);
        vacancy2.setCity("Rost2ov");
        vacancy2.setAddress("Center 2of Rostov");
        vacancy2.setExperience("1 ye2ars");

        //create hashmap of vacancies
        Map<String, Vacancy> vacancies = new HashMap<>();
        vacancies.put("1", vacancy1);
        vacancies.put("2", vacancy2);

        company.setVacancies(vacancies);

        log.debug("testSaveCompany [3]: create Employee instanceses");
        //create Employee instanceses
         Employee employee1 = new  Employee();
        employee1.setTypePerson( TypePerson.EmployeeType);

        //employee1.setId(1);
        employee1.setName("nameEmployee");
        employee1.setSurname("surnameEmployee");
        employee1.setMiddleName("middleNameEmployee");
        employee1.setAge(33);
        employee1.setBirthday("12-06-2003");
        employee1.setPhone("89964095446");
        employee1.setEmail("mseleznev@sfedu.ru");

        employee1.setSalary(350000);
        employee1.setPosition("head of yandex");
        employee1.setIsWorking(false);

         Employee employee2 = new  Employee();
        employee2.setTypePerson( TypePerson.EmployeeType);

        //employee2.setId(2);
        employee2.setName("nameEm2ployee");
        employee2.setSurname("surname2Employee");
        employee2.setMiddleName("middl2eNameEmployee");
        employee2.setAge(33);
        employee2.setBirthday("12-062-2003");
        employee2.setPhone("899640952446");
        employee2.setEmail("mseleznev@2sfedu.ru");

        employee2.setSalary(350000);
        employee2.setPosition("head of ya2ndex");
        employee2.setIsWorking(false);

        //create hashmap of employees
        Map<String, Employee> employees = new HashMap<>();
        employees.put("1", employee1);
        employees.put("2", employee2);

        company.setEmployees(employees);

        log.debug("testSaveCompany [4]: create SeparateQual instanceses");

        //create SeparateQual instanceses
         SeparateQual separateQual1 = new  SeparateQual();

        separateQual1.setId(1);
        separateQual1.setQuality(7);
        separateQual1.setDescription("desc");

         SeparateQual separateQual2 = new  SeparateQual();

        separateQual2.setId(2);
        separateQual2.setQuality(7);
        separateQual2.setDescription("de2sc");

        //create list of employees
        Map<String, SeparateQual> separateQuals = new HashMap<>();
        separateQuals.put("1", separateQual1);
        separateQuals.put("2", separateQual2);

        company.setSeparateQuals(separateQuals);

        employee1.setCompany(company);
        employee2.setCompany(company);

        try{
            log.debug("testSaveCompany [5]: saving company, company = {}", company);
            dp.saveRecord(company);

            dp.saveRecord(employee1);
            dp.saveRecord(employee2);
            log.debug("testSaveCompany [6]: company saved succesful");
        } catch(Exception ex){
            log.debug("testSaveCompany [7]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(6)
    @Test
    public void testUpdateCompany(){
        log.debug("testUpdateCompany [1]: test update company");
        try{
            log.debug("testUpdateCompany [2]: get company");
            Company company = (Company) dp.getRecord(Company.class, "1");
            log.debug("testUpdateCompany [3]: company = {}", company);

            log.debug("testUpdateCompany [4]: change employees of company");
            company.getEmployees().values().stream()
                    .forEach(
                            employee -> {
                                employee.setPosition("CHANGE");
                            }
                    );

            log.debug("testUpdateCompany [5]: change vacancies of company");
            company.getVacancies().values().stream()
                    .forEach(
                            vacancy -> {
                                vacancy.setSkills("CHANGE");
                            }
                    );

            log.debug("testUpdateCompany [6]: change separate quals of company");
            company.getSeparateQuals().values().stream()
                    .forEach(
                            (separateQual) -> {
                                separateQual.setDescription("CHANGE");
                            }
                    );

            log.debug("testUpdateCompany [7]: update company");
            dp.updateRecord(company);
        } catch(Exception ex){
            log.error("testUpdateCompany [8]: error = {}", ex.getMessage());
        }
    }

    @Order(7)
    @Test
    public void testGetCompany(){
        log.debug("testGetCompany [1]: test get company");
        try{
            Company company = (Company) dp.getRecord(Company.class, "1");
            log.debug("testGetCompany [2]: company was got succesful, company = {}", company);

            log.debug("testGetCompany [3]: vacancies: ");
            company.getVacancies().values().stream().forEach(System.out::println);

            log.debug("testGetCompany [4]: vacancies: ");
            company.getEmployees().values().stream().forEach(System.out::println);

            log.debug("testGetCompany [5]: vacancies: ");
            company.getSeparateQuals().values().stream().forEach(System.out::println);

            assertEquals(company.getId(), 1);
        } catch(Exception ex){
            log.debug("testGetCompany [6]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(8)
    @Test
    public void testDeleteCompany(){
        try{
            log.debug("testDeleteCompany [1]: test delete company");
            dp.deleteRecord(dp.getRecord(Company.class, "1"));
            log.debug("testDeleteCompany [1]: company was deleted succesful");

        } catch(Exception ex){
            log.debug("testDeleteCompany [2]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }
}
