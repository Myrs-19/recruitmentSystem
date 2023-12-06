/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import ru.sfedu.model.*;
/**
 *
 * @author mike
 */
public class DataProviderCsvTest {
    
    @Test
    public void testDataProviderCsv(){
        System.out.println("test DataProviderCsv");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
        } catch(Exception ex){
            fail("Error creating object of DataProviderCsv class");
        }
    }

    @Test
    public void testSaveRecordsPerson(){
        System.out.println("test SaveRecordsPerson");
        try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                Person p = new Person();
                p.setName("mike" + i);
                p.setSurname("sel" + i);
                p.setMiddleName("mike" + i);
                p.setAge("2" + i);
                p.setBirthday("200" + i);
                dataProvider.saveRecord(p);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordsUser(){
        System.out.println("test SaveRecordsUser");
        try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                User u = new User();
                u.setAge("2" + i);
                u.setBirthday("birthday");
                u.setMiddleName("middile name");
                u.setName("name" + i);
                u.setSurname("surname");
                u.setPassword("pass");
                u.setPhone("phone");
                u.setEmail("email");
                u.setAddress("add");
                dataProvider.saveRecord(u);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordsResume(){
        System.out.println("test SaveRecordsResume");
        try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                Resume r = new Resume();
                r.setUserId("0");
                r.setProfession("prof" + i);
                r.setCity("city");
                r.setSkills("skills");
                r.setEducation("education" + i);
                r.setExperience("experience");
                r.setSex("sex");
                r.setWorkPermit("workPermit");
                r.setCitizenship("citizenship");
                dataProvider.saveRecord(r);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordsCompany(){
        System.out.println("test SaveRecordsCompany");
        try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                Company c = new Company();
                c.setUserId("0");
                c.setTitle("title");
                c.setDescription("description");
                dataProvider.saveRecord(c);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordsVacancy(){
        System.out.println("test SaveRecordsVacancy");
        try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                Vacancy v = new Vacancy();
                v.setCompanyId("0");
                v.setTitle("title");
                v.setSpecialization("specialization");
                v.setOnline("online");
                v.setSkills("skills");
                v.setSalary("salary");
                v.setCity("city");
                v.setAddress("address");
                v.setExperience("experience");
                dataProvider.saveRecord(v);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordsEmployee(){
        System.out.println("test SaveRecordsEmployee");
        try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                Employee e = new Employee();
                e.setAge("3" + i);
                e.setBirthday("birthday");
                e.setMiddleName("middile name");
                e.setName("name" + i);
                e.setSurname("surname");
                e.setCompanyId("0");
                e.setIsWorking("1");
                e.setPosition("position");
                e.setSalary("1000 рублей");
                e.setStartWorkDate("12-12-2012");
                
                dataProvider.saveRecord(e);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSaveRecordsSeparateQual(){
        System.out.println("test SaveRecordsSeparateQual");
        try{
            DataProviderCsv dataProvider = new DataProviderCsv();

            for(int i = 0; i < 3; i++){
                SeparateQual sq = new SeparateQual();
                sq.setCompanyId("0");
                sq.setDescription("desc");
                sq.setEmployeeId("0");
                sq.setQuality("10");
                dataProvider.saveRecord(sq);
            }
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    
    /**
     * Test of getRecordByID method, of class DataProviderCsv.
     */
    @Test
    public void testGetRecordByIDPerson() {
        try{
            String id = "0";
            System.out.println("test GetRecordByID Person, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            Person p = (Person) dataProvider.getRecordByID(id, Person.class);
            
            Assertions.assertEquals(id, p.getId());
        } catch (Exception ex){
            fail("Person: " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetRecordByIDUser() {
        try{
            String id = "0";
            System.out.println("test GetRecordByID User, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            User u = (User) dataProvider.getRecordByID(id, User.class);
            
            Assertions.assertEquals(id, u.getId());
        } catch (Exception ex){
            fail("User: " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetRecordByIDResume() {
        try{
            String id = "0";
            System.out.println("test GetRecordByID Resume, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            Resume r = (Resume) dataProvider.getRecordByID(id, Resume.class);
            
            Assertions.assertEquals(id, r.getId());
        } catch (Exception ex){
            fail("Resume: " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetRecordByIDCompany() {
        try{
            String id = "0";
            System.out.println("test GetRecordByID Company, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            Company c = (Company) dataProvider.getRecordByID(id, Company.class);
            
            Assertions.assertEquals(id, c.getId());
        } catch (Exception ex){
            fail("Company: " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetRecordByIDVacancy() {
        try{
            String id = "0";
            System.out.println("test GetRecordByID Vacancy, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            Vacancy v = (Vacancy) dataProvider.getRecordByID(id, Vacancy.class);
            
            Assertions.assertEquals(id, v.getId());
        } catch (Exception ex){
            fail("Vacancy: " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetRecordByIDEmployee() {
        try{
            String id = "0";
            System.out.println("test GetRecordByID Employee, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            Employee emp = (Employee) dataProvider.getRecordByID(id, Employee.class);
            
            Assertions.assertEquals(id, emp.getId());
        } catch (Exception ex){
            fail("Person: " + ex.getMessage());
        }
    }
    
    @Test
    public void testGetRecordByIDSeparateQual() {
        try{
            String id = "0";
            System.out.println("test GetRecordByID SeparateQual, id = " + id);
            
            IDataProvider dataProvider = new DataProviderCsv();
            SeparateQual sq = (SeparateQual) dataProvider.getRecordByID(id, SeparateQual.class);
            
            Assertions.assertEquals(id, sq.getId());
        } catch (Exception ex){
            fail("SeparateQual: " + ex.getMessage());
        }
    }
    


    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordPerson() {
        System.out.println("test GetAllRecord Person");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<Person> persons = dataProvider.getAllRecord(Person.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordPerson" + ex.getMessage());
        }
    }
    
    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordUser() {
        System.out.println("test GetAllRecord User");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<User> persons = dataProvider.getAllRecord(User.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordUser: " + ex.getMessage());
        }
    }
    
    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordResume() {
        System.out.println("test GetAllRecord Resume");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<Resume> persons = dataProvider.getAllRecord(Resume.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordResume: " + ex.getMessage());
        }
    }
    
    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordCompany() {
        System.out.println("test GetAllRecordPerson");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<Company> persons = dataProvider.getAllRecord(Company.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordCompany: " + ex.getMessage());
        }
    }
    
    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordVacancy() {
        System.out.println("test GetAllRecordPerson");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<Vacancy> persons = dataProvider.getAllRecord(Vacancy.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordVacancy: " + ex.getMessage());
        }
    }
    
    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordEmployee() {
        System.out.println("test GetAllRecordEmployee");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<Employee> persons = dataProvider.getAllRecord(Employee.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordEmployee: " + ex.getMessage());
        }
    }
    
    /**
     * Test of getAllRecord method, of class DataProviderCsv.
     */
    @Test
    public void testGetAllRecordSeparateQual() {
        System.out.println("test GetAllRecord SeparateQual");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            List<SeparateQual> persons = dataProvider.getAllRecord(SeparateQual.class);
            persons.forEach(it -> System.out.println(it));
        } catch (Exception ex){
            fail("testGetAllRecordSeparateQual: " + ex.getMessage());
        }
    }
    
    @Test
    public void testUpdateRecordPerson(){
        System.out.println("test UpdateRecord Person");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            Person p = new Person();
            p.setId("0");
            p.setName("nameUpdated");
            p.setSurname("surnameupdate");
            p.setMiddleName("middleNameupdated");
            p.setAge("99");
            p.setBirthday("20-20-2020");
            dataProvider.updateRecord(p);
            
        } catch(Exception ex){
            fail("testUpdateRecordPerson" + ex.getMessage());
        }
    }
    
    @Test
    public void testUpdateRecordUser(){
        System.out.println("test UpdateRecord User");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            User u = new User();
            u.setId("0");
            u.setName("nameUpdated");
            u.setSurname("surnameupdate");
            u.setMiddleName("middleNameupdated");
            u.setAge("99");
            u.setBirthday("20-20-2020");
            u.setPassword("password");
            u.setPhone("696969");
            u.setEmail("my.rs@mail.ru");
            u.setAddress("addressupdate");
            dataProvider.updateRecord(u);
            
        } catch(Exception ex){
            fail("testUpdateRecordPerson" + ex.getMessage());
        }
    }
    
    @Test
    public void testDeleteRecordPerson() {
        try{
            System.out.println("test DeleteRecordPerson");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("3", Person.class);
            
        } catch (Exception ex){
            fail(ex.getMessage());
        }
    }
}
