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
import org.junit.jupiter.api.RepeatedTest;
import ru.sfedu.Constants;
import ru.sfedu.model.Company;
import ru.sfedu.model.Employee;
import ru.sfedu.model.Person;
import ru.sfedu.model.Result;
import ru.sfedu.model.Resume;
import ru.sfedu.model.SeparateQual;
import ru.sfedu.model.TypePerson;
import ru.sfedu.model.Client;
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
    public void testSaveClient() {
        
        System.out.println("test saveClient xml");
        Client client = new Client();
        
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("plplpl");
        client.setSurname("selsel");
        client.setAge("20");
        
        client.setEmail("a");
        client.setPhone("756");
        client.setAddress("zorrr");
        client.setPassword("ppiipi");
        
        Result result = new Result();
        try{
            IDataProvider dp = new DataProviderXml();
            result = dp.savePerson(client);
            assertEquals(Constants.CODE_SUCCESS, result.getCode());     
        } catch(Exception ex){
            System.out.println(result.getMessage());
        }
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
        employee.setIsWorking(false);
        employee.setPosition("middle");
        
        Result result = new Result();
        try{
            IDataProvider dp = new DataProviderXml();
            result = dp.savePerson(employee);
            assertEquals(Constants.CODE_SUCCESS, result.getCode());     
        } catch(Exception ex){
            System.out.println(result.getMessage());
        }
    }

    /**
     * Test of saveResume method, of class DataProviderXml.
     */
    @Test
    public void testSaveResume() {
        System.out.println("test saveResume xml");
        Resume resume = new Resume();
        
        resume.setClientId("1");
        resume.setCity("rostov");
        resume.setProfession("developer");
        
        Result result = new Result();
        
        try{
            IDataProvider dp = new DataProviderXml();
            result = dp.saveResume(resume);
            assertEquals(Constants.CODE_SUCCESS, result.getCode());     
        } catch(Exception ex){
            System.out.println(result.getMessage());
        }
    }

    /**
     * Test of saveCompany method, of class DataProviderXml.
     */
    @Test
    public void testSaveCompany() {
        System.out.println("test saveCompany xml");
        Company company = new Company();
        
        company.setTitle("arenadata");
        
        Result result = new Result();
        
        try{
            IDataProvider dp = new DataProviderXml();
            result = dp.saveCompany(company);
            assertEquals(Constants.CODE_SUCCESS, result.getCode());     
        } catch(Exception ex){
            System.out.println(result.getMessage());
        }
    }

    /**
     * Test of saveVacancy method, of class DataProviderXml.
     */
    @Test
    public void testSaveVacancy() {
        System.out.println("test SaveVacancy xml");
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompanyId(1);
        vacancy.setTitle("java");
        vacancy.setSalary(8797);
        
        Result result = new Result();
        try{
            IDataProvider dp = new DataProviderXml();
            result = dp.saveVacancy(vacancy);
            assertEquals(Constants.CODE_SUCCESS, result.getCode());     
        } catch(Exception ex){
            System.out.println(result.getMessage());
        }
    }
    /**
     * Test of saveSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testSaveSeparateQual() {
        System.out.println("test SaveSeparateQual xml");
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setCompanyId(1);
        separateQual.setEmployeeId(1);
        separateQual.setQuality(7);
        
        Result result = new Result();
        try{    
            IDataProvider dp = new DataProviderXml();
            result = dp.saveSeparateQual(separateQual);
            assertEquals(Constants.CODE_SUCCESS, result.getCode());     
        } catch(Exception ex){
            System.out.println(result.getMessage());
        }
    }

    /**
     * Test of getClient method, of class DataProviderXml.
     */
    @Test
    public void testGetClientPositive() {
        System.out.println("test GetClient xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        try{
            Client client = dp.getClient(id);
            System.out.println(client);
        } catch(Exception ex){
            System.out.println("Пользователя с таким id еще нет, id = " + id);
        }
    }
    
    @Test
    public void testGetClientNegative() {
        System.out.println("test GetClient xml");
        String id = "-1";
        IDataProvider dp = new DataProviderXml();
        try{
            Client client = dp.getClient(id);
            System.out.println(client);
        } catch(Exception ex){
            System.out.println("Пользователя с таким id еще нет, id = " + id);
        }
    }

    /**
     * Test of getResume method, of class DataProviderXml.
     */
    @Test
    public void testGetResumePositive() {
        System.out.println("test GetResume xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        try{
            Resume resume = dp.getResume(id);
            System.out.println(resume);
        } catch(Exception ex){
            System.out.println("резюме с таким id еще нет, id = " + id);
        }
    }
    
    @Test
    public void testGetResumeNegative() {
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
    public void testGetCompanyPositive() {
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
    
    @Test
    public void testGetCompanyNegative() {
        System.out.println("test GetCompany xml");
        String id = "-1";
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
    public void testGetVacancyPositive() {
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

    @Test
    public void testGetVacancyNegative() {
        System.out.println("test GetVacancy xml");
        String id = "-1";
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
    public void testGetEmployeePositive() {
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
    
    @Test
    public void testGetEmployeeNegative() {
        System.out.println("test GetEmployee xml");
        String id = "-1";
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
    public void testGetSeparateQualPositive() {
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
    
    @Test
    public void testGetSeparateQualNegative() {
        System.out.println("test GetSeparateQual xml");
        String id = "-1";
        IDataProvider dp = new DataProviderXml();
        try{
            SeparateQual separateQual = dp.getSeparateQual(id);
            System.out.println(separateQual);
        } catch(Exception ex){
            System.out.println("оценки с таким id еще нет, id = " + id);
        }
    }

    /**
     * Test of getAllClients method, of class DataProviderXml.
     */
    @Test
    public void testGetAllClients() {
        System.out.println("test GetAllClients xml");
        IDataProvider dp = new DataProviderXml();
        try{
            dp.getAllClients().stream()
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
    public void testUpdateClient() {
        System.out.println("test updateClient xml");
        Client client = new Client();
        String id = "0";
        client.setId(id);
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("plplpl");
        client.setSurname("MIMIMIMI");
        client.setAge("20");
        
        client.setEmail("a");
        client.setPhone("756");
        client.setAddress("zorrr");
        client.setPassword("ppiipi");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updatePerson(client);
        
        System.out.println(result);
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
        employee.setIsWorking(false);
        employee.setPosition("middle");
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updatePerson(employee);
        System.out.println(result);
    }
    
    /**
     * Test of updateResume method, of class DataProviderXml.
     */
    @Test
    public void testUpdateResume() {
        System.out.println("test UpdateResume xml");
        Resume resume = new Resume();
        
        resume.setId("-1");
        resume.setClientId("0");
        resume.setCity("RRRRRRRRR");
        resume.setProfession("developer");
        
        Result result = new Result();
    
        IDataProvider dp = new DataProviderXml();
        result = dp.updateResume(resume);
        
        System.out.println(result);
    }

    /**
     * Test of updateCompany method, of class DataProviderXml.
     */
    @Test
    public void testUpdateCompany() {
        System.out.println("test UpdateCompany xml");
        Company company = new Company();
        
        company.setId("0");
        company.setTitle("DATAAA");
        
        Result result = new Result();
    
        IDataProvider dp = new DataProviderXml();
        result = dp.updateCompany(company);
        
        System.out.println(result);
    }

    /**
     * Test of updateVacancy method, of class DataProviderXml.
     */
    @Test
    public void testUpdateVacancy() {
        System.out.println("test UpdateVacancy xml");
        Vacancy vacancy = new Vacancy();
        
        vacancy.setId("0");
        vacancy.setCompanyId(1);
        vacancy.setTitle("JAAAAAAAVAAAAAAAa");
        vacancy.setSalary(11);
        
        Result result = new Result();
        
        IDataProvider dp = new DataProviderXml();
        result = dp.updateVacancy(vacancy);
        
        System.out.println(result);
    }
    /**
     * Test of updateSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testUpdateSeparateQual() {
        System.out.println("test UpdateSeparateQual xml");
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setId("1");
        separateQual.setCompanyId(1);
        separateQual.setEmployeeId(1);
        separateQual.setQuality(7);
        separateQual.setDescription("nice");
        
        Result result = new Result();
    
        IDataProvider dp = new DataProviderXml();
        result = dp.updateSeparateQual(separateQual);
        
        System.out.println(result);
    }

    /**
     * Test of deletePerson method, of class DataProviderXml.
     */
    @Test
    public void testDeleteClient() {
        System.out.println("test DeleteClient xml");
        String id = "-1";
        IDataProvider dp = new DataProviderXml();
        Result result = dp.deletePerson(id, TypePerson.ClientType);
        System.out.println(result);
    }

    @Test
    public void testDeleteEmployee() {
        System.out.println("test DeleteEmployee xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        Result result = dp.deletePerson(id, TypePerson.EmployeeType);
        System.out.println(result);
    }
    /**
     * Test of deleteResume method, of class DataProviderXml.
     */
    @Test
    public void testDeleteResume() {
        System.out.println("test DeleteResume xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        Result result = dp.deleteResume(id);
        System.out.println(result);
    }

    /**
     * Test of deleteCompany method, of class DataProviderXml.
     */
    @Test
    public void testDeleteCompany() {
        System.out.println("test DeleteCompany xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        Result result = dp.deleteCompany(id);
        System.out.println(result);
    }

    /**
     * Test of deleteVacancy method, of class DataProviderXml.
     */
    @Test
    public void testDeleteVacancy() {
        System.out.println("test DeleteVacancy xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        Result result = dp.deleteVacancy(id);
        System.out.println(result);
    }

    /**
     * Test of deleteSeparateQual method, of class DataProviderXml.
     */
    @Test
    public void testDeleteSeparateQual() {
        System.out.println("test DeleteSeparateQual xml");
        String id = "0";
        IDataProvider dp = new DataProviderXml();
        Result result = dp.deleteSeparateQual(id);
        System.out.println(result);
    }
    
}
