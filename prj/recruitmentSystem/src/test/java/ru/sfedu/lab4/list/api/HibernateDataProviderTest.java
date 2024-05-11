package ru.sfedu.lab4.list.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import ru.sfedu.lab4.list.model.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HibernateDataProviderTest {
    
    private static final Logger log = LogManager.getLogger(HibernateDataProviderTest.class.getName());
    
    private static HibernateDataProvider dp = new HibernateDataProvider();
    
    @Order(1)
    @Test
    public void testSaveClientList(){
        log.debug("testSaveClientList [1]: test save client");
        
        log.debug("testSaveClientList [2]: create client");
        Client client = new Client();
        
        //person fields
        client.setName("Mike");
        client.setSurname("Seleznev");
        client.setMiddleName("Mikhal");
        client.setAge(20);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("mseleznev@sfedu.ru");
        client.setTypePerson(TypePerson.EmployeeType);
        
        //client fields
        client.setPassword("pipi");
        client.setAddress("Zorge 28/2");
        
        log.debug("testSaveClientList [3]: client was created, client = {}", client);
        
        
        log.debug("testSaveClientList [4]: create resume");
        
        //create resumes
        List<Resume> resumes = new ArrayList<>();
        Resume resume1 = new Resume();
        resume1.setId(1);
        resume1.setCity("rostov");
        resume1.setProfession("developer");
        resume1.setSkills("OOP, SOAP");
        resume1.setEducation("3 years graduation");
        resume1.setExperience("3 years as manager");
        resume1.setSex(true);
        resume1.setWorkPermit(true);
        resume1.setCitizenship("Russian");
        
        Resume resume2 = new Resume();
        resume2.setId(2);
        resume2.setCity("rostov");
        resume2.setProfession("developer");
        resume2.setSkills("OOP, SOAP");
        resume2.setEducation("3 years graduation");
        resume2.setExperience("3 years as manager");
        resume2.setSex(true);
        resume2.setWorkPermit(true);
        resume2.setCitizenship("Russian");
        
        log.debug("testSaveClientList [5]: resumes were created, resume1 = {}, resume2 = {}", resume1, resume2);
        
        resumes.add(resume1);
        resumes.add(resume2);
    
        client.setResumes(resumes);
        
        log.debug("testSaveClientList [6]: resumes added to client");
        
        try{
            log.debug("testSaveClientList [7]: saving client, client = {}", client);
            dp.saveRecord(client);
            dp.saveRecord(client);
            log.debug("testSaveClientList [8]: client saved succesful");
        } catch(Exception ex){
            log.debug("testSaveClientList [9]: error = {}", ex.getMessage());
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


            log.debug("testUpdateClient [4]: get resumes");

            client.getResumes().stream()
                    .forEach((resume) -> {
                        resume.setCity("CHANGE");
                        resume.setProfession("CHANGE");
                        resume.setSkills("OOP, CHANGE");
                        resume.setEducation("3 CHANGE graduation");
                        resume.setExperience("3 CHANGE as manager");
                        resume.setSex(true);
                        resume.setWorkPermit(true);
                        resume.setCitizenship("CHANGE");
                    });

            log.debug("testUpdateClient [7]: saving client, client = {}", client);
            dp.updateRecord(client);
            log.debug("testUpdateClient [8]: client saved succesful");

        } catch(Exception ex) {
            log.debug("testUpdateClient [9]: error = {}", ex.getMessage());
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
            client.getResumes().forEach(System.out::println);

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
        Company company = new Company();

        company.setTitle("Anarisuto");
        company.setDescription("DATA ENGINEERS");

        log.debug("testSaveCompany [2]: create Vacancy instanceses");
        //create vacancies
        Vacancy vacancy1 = new Vacancy();
        vacancy1.setId(1);
        vacancy1.setTitle("java");
        vacancy1.setSpecialization("java");
        vacancy1.setOnline(false);
        vacancy1.setSkills("OOP");
        vacancy1.setSalary(35000);
        vacancy1.setCity("Rostov");
        vacancy1.setAddress("Center of Rostov");
        vacancy1.setExperience("1 years");

        Vacancy vacancy2 = new Vacancy();

        vacancy2.setId(2);
        vacancy2.setTitle("jav2a");
        vacancy2.setSpecialization("jav2a");
        vacancy2.setOnline(false);
        vacancy2.setSkills("OO2P");
        vacancy2.setSalary(350200);
        vacancy2.setCity("Rost2ov");
        vacancy2.setAddress("Center 2of Rostov");
        vacancy2.setExperience("1 ye2ars");

        //create list of vacancies
        List<Vacancy> vacancies = new ArrayList<>();
        vacancies.add(vacancy1);
        vacancies.add(vacancy2);

        company.setVacancies(vacancies);

        log.debug("testSaveCompany [3]: create Employee instanceses");
        //create Employee instanceses
        Employee employee1 = new Employee();
        employee1.setTypePerson(TypePerson.EmployeeType);

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

        Employee employee2 = new Employee();
        employee2.setTypePerson(TypePerson.EmployeeType);

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

        //create list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        company.setEmployees(employees);

        log.debug("testSaveCompany [4]: create SeparateQual instanceses");

        //create SeparateQual instanceses
        SeparateQual separateQual1 = new SeparateQual();

        separateQual1.setId(1);
        separateQual1.setQuality(7);
        separateQual1.setDescription("desc");

        SeparateQual separateQual2 = new SeparateQual();

        separateQual2.setId(2);
        separateQual2.setQuality(7);
        separateQual2.setDescription("de2sc");

        //create list of employees
        List<SeparateQual> separateQuals = new ArrayList<>();
        separateQuals.add(separateQual1);
        separateQuals.add(separateQual2);

        company.setSeparateQuals(separateQuals);

        try{
            log.debug("testSaveCompany [5]: saving company, company = {}", company);
            dp.saveRecord(company);
            log.debug("testSaveCompany [6]: company saved succesful");
        } catch(Exception ex){
            log.debug("testSaveCompany [7]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(6)
    @Test
    public void testUpdateCompany(){
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


            log.debug("testUpdateClient [4]: get resumes");

            client.getResumes().stream()
                    .forEach((resume) -> {
                        resume.setCity("CHANGE");
                        resume.setProfession("CHANGE");
                        resume.setSkills("OOP, CHANGE");
                        resume.setEducation("3 CHANGE graduation");
                        resume.setExperience("3 CHANGE as manager");
                        resume.setSex(true);
                        resume.setWorkPermit(true);
                        resume.setCitizenship("CHANGE");
                    });

            log.debug("testUpdateClient [7]: saving client, client = {}", client);
            dp.updateRecord(client);
            log.debug("testUpdateClient [8]: client saved succesful");

        } catch(Exception ex) {
            log.debug("testUpdateClient [9]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(7)
    @Test
    public void testGetCompany(){
        log.debug("testGetClient [1]: test update client");
        try{
            Client client = (Client) dp.getRecord(Client.class, "1");
            log.debug("testGetClient [2]: client was got succesful, client = {}", client);

            log.debug("testGetClient [3]: resumes of the client: ");
            client.getResumes().forEach(System.out::println);

        } catch(Exception ex){
            log.debug("testUpdateClient [4]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(8)
    @Test
    public void testDeleteCompany(){
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
