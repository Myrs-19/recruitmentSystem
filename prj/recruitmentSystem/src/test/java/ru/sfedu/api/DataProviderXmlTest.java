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

    /**
     * Test of saveResume method, of class DataProviderXml.
     */
    @Test
    public void testSaveResume() {
        System.out.println("saveResume");
        Resume resume = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.saveResume(resume);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCompany method, of class DataProviderXml.
     */
    @Test
    public void testSaveCompany() {
        System.out.println("saveCompany");
        Company company = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.saveCompany(company);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveVacancy method, of class DataProviderXml.
     */
    @Test
    public void testSaveVacancy() {
        System.out.println("saveVacancy");
        Vacancy vacancy = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.saveVacancy(vacancy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testSaveSeparateQual() {
        System.out.println("saveSeparateQual");
        SeparateQual separateQual = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.saveSeparateQual(separateQual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class DataProviderXml.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        User expResult = null;
        User result = instance.getUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResume method, of class DataProviderXml.
     */
    @Test
    public void testGetResume() {
        System.out.println("getResume");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        Resume expResult = null;
        Resume result = instance.getResume(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompany method, of class DataProviderXml.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        Company expResult = null;
        Company result = instance.getCompany(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVacancy method, of class DataProviderXml.
     */
    @Test
    public void testGetVacancy() {
        System.out.println("getVacancy");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        Vacancy expResult = null;
        Vacancy result = instance.getVacancy(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class DataProviderXml.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        Employee expResult = null;
        Employee result = instance.getEmployee(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testGetSeparateQual() {
        System.out.println("getSeparateQual");
        String id = "";
        DataProviderXml instance = new DataProviderXml();
        SeparateQual expResult = null;
        SeparateQual result = instance.getSeparateQual(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class DataProviderXml.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        DataProviderXml instance = new DataProviderXml();
        List<User> expResult = null;
        List<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllResumes method, of class DataProviderXml.
     */
    @Test
    public void testGetAllResumes() {
        System.out.println("getAllResumes");
        DataProviderXml instance = new DataProviderXml();
        List<Resume> expResult = null;
        List<Resume> result = instance.getAllResumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCompanies method, of class DataProviderXml.
     */
    @Test
    public void testGetAllCompanies() {
        System.out.println("getAllCompanies");
        DataProviderXml instance = new DataProviderXml();
        List<Company> expResult = null;
        List<Company> result = instance.getAllCompanies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllVacancies method, of class DataProviderXml.
     */
    @Test
    public void testGetAllVacancies() {
        System.out.println("getAllVacancies");
        DataProviderXml instance = new DataProviderXml();
        List<Vacancy> expResult = null;
        List<Vacancy> result = instance.getAllVacancies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEmployees method, of class DataProviderXml.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("getAllEmployees");
        DataProviderXml instance = new DataProviderXml();
        List<Employee> expResult = null;
        List<Employee> result = instance.getAllEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSeparateQuals method, of class DataProviderXml.
     */
    @Test
    public void testGetAllSeparateQuals() {
        System.out.println("getAllSeparateQuals");
        DataProviderXml instance = new DataProviderXml();
        List<SeparateQual> expResult = null;
        List<SeparateQual> result = instance.getAllSeparateQuals();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePerson method, of class DataProviderXml.
     */
    @Test
    public void testUpdatePerson() {
        System.out.println("updatePerson");
        Person person = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.updatePerson(person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateResume method, of class DataProviderXml.
     */
    @Test
    public void testUpdateResume() {
        System.out.println("updateResume");
        Resume resume = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.updateResume(resume);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCompany method, of class DataProviderXml.
     */
    @Test
    public void testUpdateCompany() {
        System.out.println("updateCompany");
        Company company = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.updateCompany(company);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVacancy method, of class DataProviderXml.
     */
    @Test
    public void testUpdateVacancy() {
        System.out.println("updateVacancy");
        Vacancy vacancy = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.updateVacancy(vacancy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testUpdateSeparateQual() {
        System.out.println("updateSeparateQual");
        SeparateQual separateQual = null;
        DataProviderXml instance = new DataProviderXml();
        Result expResult = null;
        Result result = instance.updateSeparateQual(separateQual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
