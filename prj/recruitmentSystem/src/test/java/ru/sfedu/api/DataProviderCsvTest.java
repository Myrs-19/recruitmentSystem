/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ru.sfedu.model.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
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
    @Order(2)
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
    @Order(3)
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
    @Order(4)
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
    @Order(5)
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
    @Order(6)
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
    @Order(7)
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
    @Order(8)
    public void testGetRecordPerson() {
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
    @Order(9)
    public void testGetRecordUser() {
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
    @Order(10)
    public void testGetRecordResume() {
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
    @Order(11)
    public void testGetRecordCompany() {
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
    @Order(12)
    public void testGetRecordVacancy() {
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
    @Order(13)
    public void testGetRecordEmployee() {
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
    @Order(14)
    public void testGetRecordSeparateQual() {
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
    
    @Test
    @Order(15)
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
    
    @Test
    @Order(16)
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
    
    @Test
    @Order(17)
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
    
    @Test
    @Order(18)
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
    
    @Test
    @Order(19)
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
    
    @Test
    @Order(20)
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
    
    @Test
    @Order(21)
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
    @Order(22)
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
            fail("testUpdateRecordPerson: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(23)
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
            fail("testUpdateRecordUser: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(24)
    public void testUpdateRecordResume(){
        System.out.println("test UpdateRecord Resume");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            Resume r = new Resume();
            r.setId("0");
            r.setUserId("0");
            r.setProfession("prrr");
            dataProvider.updateRecord(r);
            
        } catch(Exception ex){
            fail("testUpdateRecordResume: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(25)
    public void testUpdateRecordCompany(){
        System.out.println("test UpdateRecord Company");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            Company c = new Company();
            c.setId("0");
            c.setUserId("0");
            c.setTitle("titleupdated");
            c.setDescription("descriptionudated");
            dataProvider.updateRecord(c);
            
        } catch(Exception ex){
            fail("testUpdateRecordCompany: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(26)
    public void testUpdateRecordVacancy(){
        System.out.println("test UpdateRecord Vacancy");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            Vacancy v = new Vacancy();
            v.setId("0");
            v.setCompanyId("0");
            v.setTitle("title");
            v.setSalary("1001 рублей");
            dataProvider.updateRecord(v);
            
        } catch(Exception ex){
            fail("testUpdateRecordVacancy: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(27)
    public void testUpdateRecordEmployee(){
        System.out.println("test UpdateRecord Employee");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            Employee emp = new Employee();
            emp.setId("0");
            emp.setCompanyId("0");
            emp.setSalary("1001 рублей");
            emp.setIsWorking("0");
            dataProvider.updateRecord(emp);
            
        } catch(Exception ex){
            fail("testUpdateRecordEmployee: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(28)
    public void testUpdateRecordSeparateQual(){
        System.out.println("test UpdateRecord SeparateQual");
        try{
            IDataProvider dataProvider = new DataProviderCsv();
            SeparateQual sq = new SeparateQual();
            sq.setId("0");
            sq.setCompanyId("0");
            sq.setEmployeeId("0");
            sq.setQuality("3");
            sq.setDescription("very bad");
            dataProvider.updateRecord(sq);
            
        } catch(Exception ex){
            fail("testUpdateRecordSeparateQual: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(29)
    public void testDeleteRecordPerson() {
        try{
            System.out.println("test DeleteRecord Person");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("1", Person.class);
            
        } catch (Exception ex){
            fail("testDeleteRecordPerson: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(30)
    public void testDeleteRecordUser() {
        try{
            System.out.println("test DeleteRecord User");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("1", User.class);
            
        } catch (Exception ex){
            fail("testDeleteRecordUser: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(31)
    public void testDeleteRecordResume() {
        try{
            System.out.println("test DeleteRecord Resume");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("1", Resume.class);
            
        } catch (Exception ex){
            fail("testDeleteRecordResume: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(32)
    public void testDeleteRecordCompany() {
        try{
            System.out.println("test DeleteRecord Company");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("1", Company.class);
            
        } catch (Exception ex){
            fail("testDeleteRecordCompany: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(33)
    public void testDeleteRecordVacancy() {
        try{
            System.out.println("test DeleteRecord Vacancy");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("1", Vacancy.class);
            
        } catch (Exception ex){
            fail("testDeleteRecordVacancy: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(34)
    public void testDeleteRecordEmployee() {
        try{
            System.out.println("test DeleteRecord Employee");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("1", Employee.class);
            
        } catch (Exception ex){
            fail("testDeleteRecordEmployee: " + ex.getMessage());
        }
    }
    
    @Test
    @Order(35)
    public void testDeleteRecordSeparateQual() {
        try{
            System.out.println("test DeleteRecord SeparateQual");
            DataProviderCsv dataProvider = new DataProviderCsv();
            dataProvider.deleteRecordById("1", SeparateQual.class);
            
        } catch (Exception ex){
            fail("testDeleteRecordPerson: " + ex.getMessage());
        }
    }
}
