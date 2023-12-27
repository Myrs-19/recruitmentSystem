/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ru.sfedu.api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import ru.sfedu.model.*;

import ru.sfedu.Constants;

import ru.sfedu.util.ConfigurationUtilProperties;
import ru.sfedu.util.FileUtil;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataProviderXmlTest {
    
    public DataProviderXmlTest() {
    }
    
    private static IDataProvider dp;
    
    @BeforeAll
    public static void setUpClass() {
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
    }
    
    @AfterAll
    public static void tearDownClass() {
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_CLIENT).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_COMPANY).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_EMPLOYEE).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_RESUME).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_SEPARATE_QUAL).concat(Constants.XML_FILE_TYPE));
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)).concat(Constants.TITLE_TABLE_VACANCY).concat(Constants.XML_FILE_TYPE));
        
        FileUtil.deleteFileOrFolderIfExists(Constants.TEST_MAIN_FOLDER_PATH.concat(ConfigurationUtilProperties.getConfigurationEntry(Constants.XML_PATH_FOLDER)));
        
    }
    
    @Test
    @Order(1)
    public void testSaveClient(){
        System.out.println("test SaveClient xml");
        
        Client client = new Client();
        
        client.setTypePerson(TypePerson.ClientType);
        
        client.setName("Mike");
        client.setSurname("Seleznev");
        client.setAge(33);
        
        client.setPassword("998989898");
        client.setAddress("zorge 28/2");
        
        Result result = dp.savePerson(client);
        System.out.println(result);
    }
    
    @Test
    @Order(2)
    public void testSaveCompany(){
        System.out.println("test SaveCompany xml");
        
        Company company = new Company();
        company.setTitle("arenadata");
        
        Result result = dp.saveCompany(company);
        System.out.println(result);
    }
    
    @Test
    @Order(3)
    public void testSaveEmployee() {
        System.out.println("test saveEmployee xml");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save employee");
        company.setDescription("xml test save");
        
        Employee employee = new Employee();
        
        employee.setTypePerson(TypePerson.EmployeeType);
        
        employee.setName("plplpl");
        employee.setSurname("selsel");
        employee.setAge(20);
        
        employee.setCompany(company);
        employee.setSalary(99);
        employee.setIsWorking(false);
        employee.setPosition("middle");
        
        Result result = new Result();
        
        result = dp.savePerson(employee);
        
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
    @Test
    @Order(4)
    public void testSaveResume() {
        System.out.println("test saveResume xml");
        
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
    @Order(5)
    public void testSaveVacancy() {
        System.out.println("test SaveVacancy xml");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save vacancy");
        company.setDescription("xml test save");
        
        Vacancy vacancy = new Vacancy();
        
        vacancy.setCompany(company);
        vacancy.setTitle("javaJJJXLM");
        vacancy.setSpecialization("java");
        vacancy.setOnline(false);
        vacancy.setSkills("OOP");
        vacancy.setSalary(35000);
        vacancy.setCity("Rostov");
        vacancy.setAddress("Center of Rostov");
        vacancy.setExperience("1 years");
        
        Result result = dp.saveVacancy(vacancy);
        System.out.println(result);
    }
    
    @Test
    @Order(6)
    public void testSaveSeparateQual() {
        System.out.println("test SaveSeparateQual xml");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test save separate qual");
        company.setDescription("xml test save");
        
        SeparateQual separateQual = new SeparateQual();
        
        separateQual.setCompany(company);
        separateQual.setQuality(7);
        
        Result result = dp.saveSeparateQual(separateQual);
       
        System.out.println(result);
    }
    
    @Test
    @Order(7)
    public void testGetClientByIdPositive(){
        System.out.println("test GetClientById positive xml");
        try{
            int id = 1;
            System.out.println(dp.getClient(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(8)
    public void testGetClientByIdNegative(){
       
        System.out.println("test GetClientById negative xml");
        try{
            int id = -1;
            System.out.println(dp.getClient(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(9)
    public void testGetResumeByIdPositive(){
        System.out.println("test getResumeById positive xml");
        try{
            int id = 1;
            Resume resume = dp.getResume(id); 
            
            System.out.println(resume); 
            System.out.println(resume.getClient()); 
            
            assertEquals(id, resume.getId());
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(10)
    public void testGetResumeByIdNegative(){
        System.out.println("test getResumeById negative xml");
        try{
            int id = -1;
            System.out.println(dp.getResume(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(11)
    public void testGetCompanyByIdPositive(){
        System.out.println("test getCompanyById positive xml");
        try{
            int id = 1;
            System.out.println(dp.getCompany(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(12)
    public void testGetCompanyByIdNegative(){
        System.out.println("test getCompanyById negative xml");
        try{
            int id = -1;
            System.out.println(dp.getCompany(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(13)
    public void testGetVacancyByIdPositive(){
        System.out.println("test getVacancyById positive xml");
        try{
            int id = 1;
            System.out.println(dp.getVacancy(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(14)
    public void testGetVacancyByIdNegative(){
        System.out.println("test getVacancyById negative xml");
        try{
            int id = -1;
            System.out.println(dp.getVacancy(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(15)
    public void testGetEmployeeByIdPositive(){
        System.out.println("test getEmployeeById positive xml");
        try{
            int id = 1;
            System.out.println(dp.getEmployee(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(16)
    public void testGetEmployeeByIdNegative(){
        System.out.println("test getEmployeeById negative xml");
        try{
            int id = -1;
            System.out.println(dp.getEmployee(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(17)
    public void testGetSeparateQualByIdPositive(){
        System.out.println("test getSeparateQualById positive xml");
        try{
            int id = 1;
            System.out.println(dp.getSeparateQual(id)); 
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(18)
    public void testGetSeparateQualByIdNegative(){
        System.out.println("test getSeparateQualById negative xml");
        try{
            int id = -1;
            System.out.println(dp.getSeparateQual(id));
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Test
    @Order(19)
    public void testGetAllClients(){
        System.out.println("test GetAllClients xml");
        
        try{
            dp.getAllClients().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(20)
    public void testGetAllResumes(){
        System.out.println("test GetAllResumes xml");
        
        try{
            dp.getAllResumes().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(21)
    public void testGetAllCompanies(){
        System.out.println("test GetAllCompanies xml");
        
        try{
            dp.getAllCompanies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(22)
    public void testGetAllVacancies(){
        System.out.println("test GetAllVacancies xml");
        
        try{
            dp.getAllVacancies().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(23)
    public void testGetAllEmployees(){
        System.out.println("test GetAllEmployees xml");
        
        try{
            dp.getAllEmployees().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(24)
    public void testGetAllSeparateQuals(){
        System.out.println("test GetAllSeparateQuals xml");
        
        try{
            dp.getAllSeparateQuals().forEach(System.out::println);
        } catch(NullPointerException ex){
            System.out.println("error = " + ex.getMessage());
        }
    }
    
    @Test
    @Order(25)
    public void testUpdateClient() {
        System.out.println("test updateClient xml");
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
        System.out.println("test UpdatedEmployee xml");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test update employee");
        company.setDescription("xml test update");
        
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
        System.out.println("test UpdateResume xml");
        
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
        System.out.println("test UpdateCompany xml");
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
        System.out.println("test UpdateVacancy xml");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test Update Vacancy");
        company.setDescription("xml test Update");
        
        Vacancy vacancy = new Vacancy();
        
        vacancy.setId(1);
        vacancy.setCompany(company);
        vacancy.setTitle("JAAAAAAAVAAAAAAAa");
        vacancy.setSalary(11);
        
        Result result = new Result();
        
        result = dp.updateVacancy(vacancy);
        
        System.out.println(result);
    }
    
    @Test
    @Order(30)
    public void testUpdateSeparateQual() {
        System.out.println("test UpdateSeparateQual xml");
        
        Company company = new Company();
        company.setId(1);
        company.setTitle("company test Update SeparateQual");
        company.setDescription("xml test Update");
        
        Employee employee = new Employee();
            
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
        System.out.println("test DeleteClient xml");
        int id = 1;
        Result result = dp.deletePerson(id, TypePerson.ClientType);
        System.out.println(result);
    }
    
    @Test
    @Order(35)
    public void testDeleteEmployee() {
        System.out.println("test DeleteEmployee xml");
        int id = 1;
        Result result = dp.deletePerson(id, TypePerson.EmployeeType);
        System.out.println(result);
    }
    
    @Test
    @Order(31)
    public void testDeleteResume() {
        System.out.println("test DeleteResume xml");
        int id = 1;
        Result result = dp.deleteResume(id);
        System.out.println(result);
    }
    
    @Test
    @Order(36)
    public void testDeleteCompany() {
        System.out.println("test DeleteCompany xml");
        int id = 1;
        Result result = dp.deleteCompany(id);
        System.out.println(result);
    }
    
    @Test
    @Order(34)
    public void testDeleteVacancy() {
        System.out.println("test DeleteVacancy xml");
        int id = 1;
        Result result = dp.deleteVacancy(id);
        System.out.println(result);
    }
    
    @Test
    @Order(33)
    public void testDeleteSeparateQual() {
        System.out.println("test DeleteSeparateQual xml");
        int id = 1;
        Result result = dp.deleteSeparateQual(id);
        System.out.println(result);
    }
    //tests of use case diagramms
    
    @Test
    public void testCheckQualityPositive(){
        System.out.println("testCheckQualityPositive");
        IDataProvider dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        for(int i = 0; i <= 10; i++){
            assertEquals(true, dp.checkQuality(i));
        }
    }
    
    @Test
    public void testCheckQualityNegative(){
        System.out.println("testCheckQualityNegative");
        IDataProvider dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        assertEquals(false, dp.checkQuality(-1));
        assertEquals(false, dp.checkQuality(11));
        
    }
    
    @Test
    @Order(37)
    public void testcheckDealTogetherPositive(){
        tearDownClass();
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
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
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
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
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
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
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
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
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        System.out.println("testcalculateAssessmentFALSENegative");
        
        Result result = dp.calculateAssessment(1, false);
        assertEquals(Constants.CODE_ERROR, result.getCode());
    }
    
    @Test
    @Order(43)
    public void testcalculateAssessmentTRUEPositive(){
        tearDownClass();
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
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
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
        Result result = dp.calculateAssessment(1, true);
        assertEquals(Constants.CODE_ERROR, result.getCode());
    }
    
    @Test
    @Order(45)
    public void testCalculateAssessmentWithOthers(){
        tearDownClass();
        System.out.println("testCalculateAssessmentWithOthers");
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
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
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
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
        dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);
        
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
        
        IDataProvider dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);

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
        
        IDataProvider dp = new DataProviderXml(Constants.TEST_MAIN_FOLDER_PATH);

        Result result = dp.sendTestMessage(email, vacancy);
        assertEquals(Constants.CODE_SUCCESS, result.getCode());
    }
    
}
