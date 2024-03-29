/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ru.sfedu.Constants;

import ru.sfedu.model.*;
import ru.sfedu.util.ConfigurationUtilProperties;
import ru.sfedu.util.FileUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataProviderCsvTest {
    
    private static IDataProvider dp;
    
    @BeforeAll
    public static void setUpClass() {
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
    }
    
    @AfterAll
    public static void tearDownClass() {
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_CLIENT).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_COMPANY).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_EMPLOYEE).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_RESUME).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_SEPARATE_QUAL).concat(Constants.CSV_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)).concat(Constants.TITLE_TABLE_VACANCY).concat(Constants.CSV_FILE_TYPE));
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.CSV_PATH_FOLDER)));
        
    }
    
    @Test
    @Order(1)
    void testSavePersonClient(){
        System.out.println("test SaveClient csv");
        
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("nameClient");
        client.setSurname("nameSurname");
        client.setMiddleName("middleNameClient");
        client.setAge(32);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("my.rs@mail.ru");
        client.setPassword("pipipipi");
        client.setAddress("address zorge 28/2");
        
        Result result = dp.savePerson(client);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(3)
    void testSavePersonEmployee(){
        System.out.println("test saveEmployee csv");
        
        Company company = new Company();
        company.setTitle("company test save employee");
        company.setDescription("csv test save");
        
        Employee employee = new Employee();
        employee.setTypePerson(TypePerson.EmployeeType);
        employee.setCompany(company);  
        
        employee.setName("nameEmployee");
        employee.setSurname("surnameEmployee");
        employee.setMiddleName("middleNameEmployee");
        employee.setAge(33);
        employee.setBirthday("12-06-2003");
        employee.setPhone("89964095446");
        employee.setEmail("mseleznev@sfedu.ru");
        
        employee.setSalary(350000);
        employee.setPosition("head of yandex");
        employee.setIsWorking(false);
        
        Result result = new Result();
        
        result = dp.savePerson(employee);
        
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(4)
    void testSaveResume(){
        System.out.println("test saveResume csv");
        
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        client.setId(1);
        client.setName("nameClient");
        client.setSurname("nameSurname");
        client.setMiddleName("middleNameClient");
        client.setAge(32);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("my.rs@mail.ru");
        client.setPassword("pipipipi");
        client.setAddress("address zorge 28/2");
        
        Resume resume = new Resume();
        
        resume.setClient(client);
        resume.setCity("rostov");
        resume.setProfession("developer");
        
        Result result = dp.saveResume(resume);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(2)
    void testSaveCompany(){
        System.out.println("test SaveCompany csv");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save company");
        company.setDescription("csv test save");
        
        Result result = dp.saveCompany(company);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(5)
    void testSaveVacancy(){
        System.out.println("test SaveVacancy csv");
        
        Company c = new Company();
        c.setId(1);
        c.setTitle("Arena Data");
        c.setDescription("Description");
        
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompany(c);
        vacancy.setTitle("java");
        vacancy.setSpecialization("java");
        vacancy.setOnline(false);
        vacancy.setSkills("OOP");
        vacancy.setSalary(35000);
        vacancy.setCity("Rostov");
        vacancy.setAddress("Center of Rostov");
        vacancy.setExperience("1 years");
        
        Result result = dp.saveVacancy(vacancy);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(6)
    void testSaveSeparateQual(){
        System.out.println("test SaveSeparateQual csv");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save employee");
        company.setDescription("csv test save");
        
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setCompany(company);
        separateQual.setQuality(7);
        separateQual.setDescription("desc");
        
        Result result = dp.saveSeparateQual(separateQual);
       
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(7)
    void testGetClientPositive(){
        System.out.println("test GetClientById positive csv");
        try{
            int id = 1;
            Client client = dp.getClient(id);
            System.out.println(client);
            assertEquals(id, client.getId());
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(8)
    void testGetClientNegative(){
        System.out.println("test GetClientById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getClient(id));
            fail("the test failed");
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
        
    @Test
    @Order(9)
    void testGetResumePositive(){
        System.out.println("test getResumeById positive csv");
        try{
            int id = 1;
            Resume resume = dp.getResume(id); 
            System.out.println(resume);
            System.out.println(resume.getClient());
            assertEquals(id, resume.getId());
        } catch(NullPointerException ex){
            fail("the test failed");
        }
    }
    
    @Test
    @Order(10)
    void testGetResumeNegative(){
        System.out.println("test getResumeById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getResume(id));
            fail("the test failed");
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(11)
    void testGetCompanyPositive(){
        System.out.println("test getCompanyById positive csv");
        try{
            int id = 1;
            Company company = dp.getCompany(id);
            System.out.println(company);
            assertEquals(id, company.getId());
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(12)
    void testGetCompanyNegative(){
        System.out.println("test getCompanyById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getCompany(id));
            fail("the test failed");
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(13)
    void testGetVacancyPositive(){
        System.out.println("test getVacancyById positive csv");
        try{
            int id = 1;
            Vacancy v = dp.getVacancy(id); 
            System.out.println(v);
            System.out.println(v.getCompany() + " " + v.getCompany().getDescription());
            
            assertEquals(id, v.getId());
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
            fail("the test failed");
        }
    }
    
    @Test
    @Order(14)
    void testGetVacancyNegative(){
        System.out.println("test getVacancyById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getVacancy(id));
            fail("the test failed");
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(15)
    void testGetEmployeePositive(){
        System.out.println("test getEmployeeById positive csv");
        try{
            int id = 1;
            Employee emp = dp.getEmployee(id);
            System.out.println(emp);
            assertEquals(id, emp.getId());
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(16)
    void testGetEmployeeNegative(){
        System.out.println("test getEmployeeById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getEmployee(id));
            fail("the test failed");
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(17)
    void testGetSeparateQualPositive(){
        System.out.println("test getSeparateQualById positive csv");
        try{
            int id = 1;
            SeparateQual sp = dp.getSeparateQual(id);
            System.out.println(sp);
            assertEquals(id, sp.getId());
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(18)
    void testGetSeparateQualNigga(){
        System.out.println("test getSeparateQualById negative csv");
        try{
            int id = -1;
            System.out.println(dp.getSeparateQual(id));
            fail("the test failed");
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(19)
    public void testGetAllClients(){
        System.out.println("test GetAllClients csv");
        
        try{
            dp.getAllClients().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(20)
    public void testGetAllResumes(){
        System.out.println("test GetAllResumes csv");
        
        try{
            dp.getAllResumes().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(21)
    public void testGetAllCompanies(){
        System.out.println("test GetAllCompanies csv");
        
        try{
            dp.getAllCompanies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(22)
    public void testGetAllVacancies(){
        System.out.println("test GetAllVacancies csv");
        
        try{
            dp.getAllVacancies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(23)
    public void testGetAllEmployees(){
        System.out.println("test GetAllEmployees csv");
        
        try{
            dp.getAllEmployees().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(24)
    public void testGetAllSeparateQuals(){
        System.out.println("test GetAllSeparateQuals csv");
        
        try{
            dp.getAllSeparateQuals().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(25)
    public void testUpdateClient() {
        System.out.println("test updateClient csv");
        Client client = new Client();
        int id = 1;
        client.setId(id);
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("plplpl");
        client.setSurname("MIMIMIMI");
        client.setAge(20);
        
        client.setEmail("a");
        client.setPhone("756");
        client.setAddress("zorrr");
        client.setPassword("ppiipi");
        
        Result result = new Result();
        
        result = dp.updatePerson(client);
        
        System.out.println(result);
    }
    
    @Test
    @Order(26)
    public void testUpdatedEmployee() {
        System.out.println("test UpdatedEmployee csv");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test update employee");
        company.setDescription("csv update save");
        
        Employee employee = new Employee();
        
        employee.setId(1);
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("TEST");
        employee.setSurname("selsel");
        employee.setAge(20);
        
        employee.setCompany(company);
        employee.setSalary(99);
        employee.setIsWorking(false);
        employee.setPosition("senior");
        
        Result result = new Result();
        
        result = dp.updatePerson(employee);
        System.out.println(result);
    }
    
    @Test
    @Order(27)
    public void testUpdateResume() {
        System.out.println("test UpdateResume csv");
        
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        client.setId(1);
        client.setName("nameClient");
        client.setSurname("nameSurname");
        client.setMiddleName("middleNameClient");
        client.setAge(32);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("my.rs@mail.ru");
        client.setPassword("pipipipi");
        client.setAddress("address zorge 28/2");
        
        Resume resume = new Resume();
        
        resume.setId(1);
        resume.setClient(client);
        resume.setCity("RRRRRRRRR");
        resume.setProfession("developerTEST");
        
        Result result = new Result();
    
        result = dp.updateResume(resume);
        
        System.out.println(result);
    }
    
    @Test
    @Order(28)
    public void testUpdateCompany() {
        System.out.println("test UpdateCompany csv");
        Company company = new Company();
        
        company.setId(1);
        company.setTitle("DATAAA");
        
        Result result = new Result();
    
        result = dp.updateCompany(company);
        
        System.out.println(result);
    }
    
    @Test
    @Order(29)
    public void testUpdateVacancy() {
//        System.out.println("test UpdateVacancy csv");
//        Vacancy vacancy = new Vacancy();
//        
//        vacancy.setId(1);
//        vacancy.setCompanyId(1);
//        vacancy.setTitle("JAAAAAAAVAAAAAAAa");
//        vacancy.setSalary(11);
//        
//        Result result = new Result();
//        
//        result = dp.updateVacancy(vacancy);
//        
//        System.out.println(result);
    }
    
    @Test
    @Order(30)
    public void testUpdateSeparateQual() {
        System.out.println("test UpdateSeparateQual csv");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test update separateQual");
        company.setDescription("csv update save");
        
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setId(1);
        separateQual.setCompany(company);
        separateQual.setQuality(10);
        separateQual.setDescription("nice");
        
        Result result = new Result();
    
        result = dp.updateSeparateQual(separateQual);
        
        System.out.println(result);
    }
    
    @Test
    @Order(32)
    public void testDeleteClient() {
        System.out.println("test DeleteClient csv");
        int id = 1;
        Result result = dp.deletePerson(id, TypePerson.ClientType);
        System.out.println(result);
    }
    
    @Test
    @Order(35)
    public void testDeleteEmployee() {
        System.out.println("test DeleteEmployee csv");
        int id = 1;
        Result result = dp.deletePerson(id, TypePerson.EmployeeType);
        System.out.println(result);
    }
    
    @Test
    @Order(31)
    public void testDeleteResume() {
        System.out.println("test DeleteResume csv");
        int id = 1;
        Result result = dp.deleteResume(id);
        System.out.println(result);
    }
    
    @Test
    @Order(36)
    public void testDeleteCompany() {
        System.out.println("test DeleteCompany csv");
        int id = 1;
        Result result = dp.deleteCompany(id);
        System.out.println(result);
    }
    
    @Test
    @Order(34)
    public void testDeleteVacancy() {
        System.out.println("test DeleteVacancy csv");
        int id = 1;
        Result result = dp.deleteVacancy(id);
        System.out.println(result);
    }
    
    @Test
    @Order(33)
    public void testDeleteSeparateQual() {
        System.out.println("test DeleteSeparateQual csv");
        int id = 1;
        Result result = dp.deleteSeparateQual(id);
        System.out.println(result);
    }
    
    //tests of use case diagramms
    
    @Test
    public void testCheckQualityPositive(){
        System.out.println("testCheckQualityPositive");
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        for(int i = 0; i <= 10; i++){
            assertEquals(true, dp.checkQuality(i));
        }
    }
    
    @Test
    public void testCheckQualityNegative(){
        System.out.println("testCheckQualityNegative");
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        assertEquals(false, dp.checkQuality(-1));
        assertEquals(false, dp.checkQuality(11));
        
    }
    
    @Test
    @Order(37)
    public void testcheckDealTogetherPositive(){
        tearDownClass();
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        System.out.println("testcheckDealTogetherPositive");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save company");
        company.setDescription("csv test save");
        
        Employee employee = new Employee();
        employee.setTypePerson(TypePerson.EmployeeType);
        employee.setCompany(company);
        employee.setId(1);
        
        employee.setName("nameEmployee");
        employee.setSurname("surnameEmployee");
        employee.setMiddleName("middleNameEmployee");
        employee.setAge(33);
        employee.setBirthday("12-06-2003");
        employee.setPhone("89964095446");
        employee.setEmail("mseleznev@sfedu.ru");
        
        employee.setSalary(350000);
        employee.setPosition("head of yandex");
        employee.setIsWorking(false);
        
        System.out.println("save company");
        dp.saveCompany(company);
        System.out.println("save employee");
        dp.savePerson(employee);
        
        System.out.println("checking");
        int idEmployee = 1;
        int idCompany = 1;
        assertEquals(true, dp.checkDealTogether(idEmployee, idCompany));
        
        tearDownClass();
    }
    
    @Test
    @Order(38)
    public void testcheckDealTogetherNegative(){
        tearDownClass();
        System.out.println("testCheckQualityNegative");
        assertEquals(false, dp.checkDealTogether(1, 1));
    }
    
    @Test
    @Order(39)
    public void testGiveAssessmentPositive(){
        tearDownClass();
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        System.out.println("testcheckDealTogetherPositive");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save company");
        company.setDescription("csv test save");
        
        Employee employee = new Employee();
        employee.setTypePerson(TypePerson.EmployeeType);
        employee.setCompany(company);  
        employee.setId(1);  
        
        employee.setName("nameEmployee");
        employee.setSurname("surnameEmployee");
        employee.setMiddleName("middleNameEmployee");
        employee.setAge(33);
        employee.setBirthday("12-06-2003");
        employee.setPhone("89964095446");
        employee.setEmail("mseleznev@sfedu.ru");
        
        employee.setSalary(350000);
        employee.setPosition("head of yandex");
        employee.setIsWorking(false);
        
        System.out.println("save company");
        dp.saveCompany(company);
        System.out.println("save employee");
        dp.savePerson(employee);
        
        System.out.println("checking");
        int idEmployee = 1;
        int idCompany = 1;
        int quality = 3;
        String description = "probably";
        
        Result result = dp.giveAssessment(idEmployee, idCompany, quality, description);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
        
        tearDownClass();
    }
    
    @Test
    @Order(40)
    public void testGiveAssessmentNegative(){
        tearDownClass();
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        System.out.println("testGiveAssessmentNegative");
        
        System.out.println("checking");
        int idEmployee = 1;
        int idCompany = 1;
        int quality = 3;
        String description = "probably";
        
        Result result = dp.giveAssessment(idEmployee, idCompany, quality, description);
        assertEquals(Constants.CODE_ERROR, result.getCode());
        
//        tearDownClass();
    }
    
    @Test
    @Order(41)
    public void testcalculateAssessmentFALSEPositive(){
        tearDownClass();
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        System.out.println("testcalculateAssessmentFALSEPositive");
        
        Company company = new Company();
        int idCompany = 1;
        company.setTitle("company test save company");
        company.setId(1);
        company.setDescription("csv test save");
        
        dp.saveCompany(company);
        
        for(int i = 0; i < 3; i++){
            SeparateQual separateQual = new SeparateQual();
        
            separateQual.setCompany(company);
            separateQual.setQuality(3+i);
            separateQual.setDescription("desc");
            dp.saveSeparateQual(separateQual);
        }
        
        Result result = dp.calculateAssessment(1, false);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(42)
    public void testcalculateAssessmentFALSENegative(){
        tearDownClass();
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        System.out.println("testcalculateAssessmentFALSENegative");
        
        Result result = dp.calculateAssessment(1, false);
        assertEquals(Constants.CODE_ERROR, result.getCode());
    }
    
    @Test
    @Order(43)
    public void testcalculateAssessmentTRUEPositive(){
        tearDownClass();
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        System.out.println("testcalculateAssessmentTRUEPositive");
        
        for(int i = 1; i <= 3; i++){
            Company company = new Company();
            
            company.setTitle("company test save company");
            company.setDescription("csv test save");
            company.setId(i);

            dp.saveCompany(company);

            for(int j = 0; j < 3; j++){
                SeparateQual separateQual = new SeparateQual();

                separateQual.setCompany(company);
                separateQual.setQuality(1+i+j);
                separateQual.setDescription("desc");
                dp.saveSeparateQual(separateQual);
            }
        }
        
        int idCompany = 3;
        Result result = dp.calculateAssessment(idCompany, true);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(44)
    public void testcalculateAssessmentTRUENegative(){
        System.out.println("testcalculateAssessmentTRUENegative");
        tearDownClass();
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        Result result = dp.calculateAssessment(1, true);
        assertEquals(Constants.CODE_ERROR, result.getCode());
    }
    
    @Test
    @Order(45)
    public void testCalculateAssessmentWithOthers(){
        tearDownClass();
        System.out.println("testCalculateAssessmentWithOthers");
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        for(int i = 1; i <= 3; i++){
            Company company = new Company();
            
            company.setTitle("company test save company");
            company.setDescription("csv test save");
            company.setId(i);

            dp.saveCompany(company);

            for(int j = 0; j < 3; j++){
                SeparateQual separateQual = new SeparateQual();

                separateQual.setCompany(company);
                separateQual.setQuality(1+i+j);
                separateQual.setDescription("desc");
                dp.saveSeparateQual(separateQual);
            }
        }
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("title");
        company.setDescription("desc");
        
        ResultAnalisys resultAnalisys = new ResultAnalisys(0.0, company);
        
        Result result = dp.calculateAssessmentWithOthers(resultAnalisys);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(46)
    public void testHireEmployeePositiveFALSE(){
        tearDownClass();
        System.out.println("testHireEmployeePositiveFALSE");
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        //client
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        client.setId(1);
        client.setName("nameClient");
        client.setSurname("nameSurname");
        client.setMiddleName("middleNameClient");
        client.setAge(32);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("my.rs@mail.ru");
        client.setPassword("pipipipi");
        client.setAddress("address zorge 28/2");
        
        dp.savePerson(client);
        
        //resume
        Resume resume = new Resume();
        resume.setId(1);
        resume.setClient(client);
        resume.setCity("rostov");
        resume.setProfession("developer");
        resume.setSkills("OOP, SOAP");
        resume.setEducation("3 years graduation");
        resume.setExperience("3 years as manager");
        resume.setSex(true);
        resume.setWorkPermit(true);
        resume.setCitizenship("Russian");
        
        dp.saveResume(resume);
        
        //company
        Company company = new Company();
        company.setId(1);
        company.setTitle("title");
        company.setDescription("desc");
        
        dp.saveCompany(company);
        
        //vacancy
        Vacancy vacancy = new Vacancy();
        
        vacancy.setId(1);
        vacancy.setCompany(company);
        vacancy.setTitle("java");
        vacancy.setSpecialization("java");
        vacancy.setOnline(false);
        vacancy.setSkills("OOP");
        vacancy.setSalary(35000);
        vacancy.setCity("Rostov");
        vacancy.setAddress("Center of Rostov");
        vacancy.setExperience("1 years");
        
        dp.saveVacancy(vacancy);
    
        int idResume = 1;
        int idVacancy = 1;
        Result result = dp.hireEmployee(idResume, idVacancy, false);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(47)
    public void testHireEmployeeNegativeFALSE(){
        tearDownClass();
        System.out.println("testHireEmployeeNegativeFALSE");
        dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);
        
        int idResume = 1;
        int idVacancy = 1;
        Result result = dp.hireEmployee(idResume, idVacancy, false);
        assertEquals(Constants.CODE_ERROR, result.getCode());
    }
    
    @Test
    @Order(48)
    public void testSendHireMessage(){
        System.out.println("testSendHireMessage");
        
        String email = "mseleznev@sfedu.ru";
        
        //company
        Company company = new Company();
        company.setId(1);
        company.setTitle("title");
        company.setDescription("desc");
        
        //vacancy
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1);
        vacancy.setCompany(company);
        vacancy.setTitle("java");
        vacancy.setSpecialization("java");
        vacancy.setOnline(false);
        vacancy.setSkills("OOP");
        vacancy.setSalary(35000);
        vacancy.setCity("Rostov");
        vacancy.setAddress("Center of Rostov");
        vacancy.setExperience("1 years");
        
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);

        Result result = dp.sendHireMessage(email, vacancy);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(49)
    public void testSendTestMessage(){
        System.out.println("testSendHireMessage");
        
        String email = "mseleznev@sfedu.ru";
        
        //company
        Company company = new Company();
        company.setId(1);
        company.setTitle("title");
        company.setDescription("desc");
        
        //vacancy
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompany(company);
        vacancy.setId(1);
        vacancy.setTitle("java");
        vacancy.setSpecialization("java");
        vacancy.setOnline(false);
        vacancy.setSkills("OOP");
        vacancy.setSalary(35000);
        vacancy.setCity("Rostov");
        vacancy.setAddress("Center of Rostov");
        vacancy.setExperience("1 years");
        
        IDataProvider dp = new DataProviderCsv(Constants.TEST_MAIN_FOLDER_PATH);

        Result result = dp.sendTestMessage(email, vacancy);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
}
