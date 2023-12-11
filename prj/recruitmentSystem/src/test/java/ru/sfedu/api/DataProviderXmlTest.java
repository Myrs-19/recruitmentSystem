/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.sfedu.Constants;
import ru.sfedu.model.Company;
import ru.sfedu.model.Employee;
import ru.sfedu.model.Person;
import ru.sfedu.model.Result;
import ru.sfedu.model.Resume;
import ru.sfedu.model.SeparateQual;
import ru.sfedu.model.TypePerson;
import ru.sfedu.model.User;
import ru.sfedu.model.Vacancy;

/**
 *
 * @author mike
 */
public class DataProviderXmlTest {
    
    public DataProviderXmlTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testInitDataProviderXml(){
        IDataProvider dp = new DataProviderXml();
    }
    
    /**
     * Test of savePerson method, of class DataProviderXml.
     */
    @Test
    public void testSaveUser() {
        System.out.println("test saveUser xml");
        User user = new User();
        
        user.setTypePerson(TypePerson.UserType);
        
        user.setName("plplpl");
        user.setSurname("selsel");
        user.setAge("20");
        
        user.setEmail("a");
        user.setPhone("756");
        user.setAddress("zorrr");
        user.setPassword("ppiipi");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.savePerson(user);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }
    
    @Test
    public void testSaveEmployee() {
        System.out.println("test saveEmployee xml");
        Employee employee = new Employee();
        
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("plplpl");
        employee.setSurname("selsel");
        employee.setAge("20");
        
        employee.setCompanyId("0");
        employee.setStartWorkDate("12-06-2003");
        employee.setSalary("99");
        employee.setIsWorking("0");
        employee.setPosition("middle");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.savePerson(employee);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of saveResume method, of class DataProviderXml.
     */
    @Test
    public void testSaveResume() {
        System.out.println("test saveResume xml");
        Resume resume = new Resume();
        
        resume.setUserId("0");
        resume.setCity("rostov");
        resume.setProfession("developer");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.saveResume(resume);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of saveCompany method, of class DataProviderXml.
     */
    @Test
    public void testSaveCompany() {
        System.out.println("test saveCompany xml");
        Company company = new Company();
        
        company.setUserId("0");
        company.setTitle("arenadata");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.saveCompany(company);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of saveVacancy method, of class DataProviderXml.
     */
    @Test
    public void testSaveVacancy() {
        System.out.println("test SaveVacancy xml");
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompanyId("0");
        vacancy.setTitle("java");
        vacancy.setSalary("8797");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.saveVacancy(vacancy);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of saveSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testSaveSeparateQual() {
        System.out.println("test SaveSeparateQual xml");
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setCompanyId("0");
        separateQual.setEmployeeId("0");
        separateQual.setQuality("7");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.saveSeparateQual(separateQual);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of getUser method, of class DataProviderXml.
     */
    @Test
    public void testGetUser() {
        System.out.println("test GetUser xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        try{
            User user = dp.getUser(id);
            System.out.println(user);
        } catch(Exception ex){
            System.out.println("Пользователя с таким id еще нет, id = " + id);
        }
    }

    /**
     * Test of getResume method, of class DataProviderXml.
     */
    @Test
    public void testGetResume() {
        System.out.println("test GetResume xml");
        String id = "-1";
        IDataProvider dp = new DataProviderXml();
        try{
            Resume resume = dp.getResume(id);
            System.out.println(resume);
        } catch(Exception ex){
            System.out.println("резюме с таким id еще нет, id = " + id);
        }
    }

    /**
     * Test of getCompany method, of class DataProviderXml.
     */
    @Test
    public void testGetCompany() {
        System.out.println("test GetCompany xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        try{
            Company company = dp.getCompany(id);
            System.out.println(company);
        } catch(Exception ex){
            System.out.println("компании с таким id еще нет, id = " + id);
        }
    }

    /**
     * Test of getVacancy method, of class DataProviderXml.
     */
    @Test
    public void testGetVacancy() {
        System.out.println("test GetVacancy xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        try{
            Vacancy vacancy = dp.getVacancy(id);
            System.out.println(vacancy);
        } catch(Exception ex){
            System.out.println("вакансии с таким id еще нет, id = " + id);
        }
    }

    /**
     * Test of getEmployee method, of class DataProviderXml.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("test GetEmployee xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        try{
            Employee employee = dp.getEmployee(id);
            System.out.println(employee);
        } catch(Exception ex){
            System.out.println("работника с таким id еще нет, id = " + id);
        }
    }

    /**
     * Test of getSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testGetSeparateQual() {
        System.out.println("test GetSeparateQual xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        try{
            SeparateQual separateQual = dp.getSeparateQual(id);
            System.out.println(separateQual);
        } catch(Exception ex){
            System.out.println("оценки с таким id еще нет, id = " + id);
        }
    }

    /**
     * Test of getAllUsers method, of class DataProviderXml.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("test GetAllUsers xml");
        IDataProvider dp = new DataProviderXml();
        try{
            dp.getAllUsers().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println("ни один пользователь не был добавлен");
        }
    }

    /**
     * Test of getAllResumes method, of class DataProviderXml.
     */
    @Test
    public void testGetAllResumes() {
        System.out.println("test GetAllResumes xml");
        IDataProvider dp = new DataProviderXml();
        try{
            dp.getAllResumes().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println("ни одно резюме не было добавлено");
        }
    }

    /**
     * Test of getAllCompanies method, of class DataProviderXml.
     */
    @Test
    public void testGetAllCompanies() {
        System.out.println("test GetAllCompanies xml");
        IDataProvider dp = new DataProviderXml();
        try{
            dp.getAllCompanies().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println("ни одна компания не была добавлена");
        }
    }

    /**
     * Test of getAllVacancies method, of class DataProviderXml.
     */
    @Test
    public void testGetAllVacancies() {
        System.out.println("test GetAllVacancies xml");
        IDataProvider dp = new DataProviderXml();
        try{
            dp.getAllVacancies().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println("ни одна вакансия не была добавлена");
        }
    }

    /**
     * Test of getAllEmployees method, of class DataProviderXml.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("test GetAllEmployees xml");
        IDataProvider dp = new DataProviderXml();
        try{
            dp.getAllEmployees().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println("ни один работник не был добавлен");
        }
    }

    /**
     * Test of getAllSeparateQuals method, of class DataProviderXml.
     */
    @Test
    public void testGetAllSeparateQuals() {
        System.out.println("test GetAllSeparateQuals xml");
        IDataProvider dp = new DataProviderXml();
        try{
            dp.getAllSeparateQuals().stream()
                    .forEach(System.out::println);
        } catch(Exception ex){
            System.out.println("ни одна оценка не была добавлена");
        }
    }

    /**
     * Test of updatePerson method, of class DataProviderXml.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("test updateUser xml");
        User user = new User();
        String id = "0";
        user.setId(id);
        user.setTypePerson(TypePerson.UserType);
        
        user.setName("plplpl");
        user.setSurname("MIMIMIMI");
        user.setAge("20");
        
        user.setEmail("a");
        user.setPhone("756");
        user.setAddress("zorrr");
        user.setPassword("ppiipi");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updatePerson(user);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    @Test
    public void testUpdatedEmployee() {
        System.out.println("test UpdatedEmployee xml");
        Employee employee = new Employee();
        
        employee.setId("0");
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("aaaaaaa");
        employee.setSurname("selsel");
        employee.setAge("20");
        
        employee.setCompanyId("0");
        employee.setStartWorkDate("12-06-2003");
        employee.setSalary("99");
        employee.setIsWorking("0");
        employee.setPosition("middle");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updatePerson(employee);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }
    
    /**
     * Test of updateResume method, of class DataProviderXml.
     */
    @Test
    public void testUpdateResume() {
        System.out.println("test UpdateResume xml");
        Resume resume = new Resume();
        
        resume.setId("-1");
        resume.setUserId("0");
        resume.setCity("RRRRRRRRR");
        resume.setProfession("developer");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updateResume(resume);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of updateCompany method, of class DataProviderXml.
     */
    @Test
    public void testUpdateCompany() {
        System.out.println("test UpdateCompany xml");
        Company company = new Company();
        
        company.setId("0");
        company.setUserId("0");
        company.setTitle("DATAAA");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updateCompany(company);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of updateVacancy method, of class DataProviderXml.
     */
    @Test
    public void testUpdateVacancy() {
        System.out.println("test UpdateVacancy xml");
        Vacancy vacancy = new Vacancy();
        
        vacancy.setId("0");
        vacancy.setCompanyId("0");
        vacancy.setTitle("JAAAAAAAVAAAAAAAa");
        vacancy.setSalary("11");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updateVacancy(vacancy);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of updateSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testUpdateSeparateQual() {
        System.out.println("test UpdateSeparateQual xml");
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setId("0");
        separateQual.setCompanyId("0");
        separateQual.setEmployeeId("0");
        separateQual.setQuality("7");
        separateQual.setDescription("nice");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updateSeparateQual(separateQual);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());     
    }

    /**
     * Test of deletePerson method, of class DataProviderXml.
     */
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        String id = "";
        TypePerson typePerson = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.deletePerson(id, typePerson);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteResume method, of class DataProviderXml.
     */
    @Test
    public void testDeleteResume() {
        System.out.println("deleteResume");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.deleteResume(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCompany method, of class DataProviderXml.
     */
    @Test
    public void testDeleteCompany() {
        System.out.println("deleteCompany");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.deleteCompany(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteVacancy method, of class DataProviderXml.
     */
    @Test
    public void testDeleteVacancy() {
        System.out.println("deleteVacancy");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.deleteVacancy(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testDeleteSeparateQual() {
        System.out.println("deleteSeparateQual");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.deleteSeparateQual(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
