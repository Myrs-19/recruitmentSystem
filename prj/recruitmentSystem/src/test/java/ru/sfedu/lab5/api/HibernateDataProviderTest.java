package ru.sfedu.lab5.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.sfedu.lab5.model.*;
import ru.sfedu.lab5.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HibernateDataProviderTest extends BaseHibernateDataProviderTest{
    private static final Logger log = LogManager.getLogger(HibernateDataProviderTest.class.getName());

    private static HibernateDataProvider dp = new HibernateDataProvider();

    @Order(1)
    @Test
    public void testSaveClient(){
        Client client = getClient();
        try{
            log.debug("testSaveClient [1]: saving client, client = {}", client);
            dp.saveRecord(client);

            log.debug("testSaveClient [2]: client saved succesful");
        } catch(Exception ex){
            log.debug("testSaveClient [3]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(2)
    @Test
    public void testGetClient(){
        try{
            log.debug("testGetClient [1]: get client");
            Client client = (Client) dp.getRecord(Client.class, "1");

            assertEquals(1, client.getId());
            log.debug("testGetClient [2]: client = {}", client);
        } catch(Exception ex){
            log.debug("testGetClient [3]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(3)
    @Test
    public void testSaveResume(){
        Resume resume = getResume();
        try{
            log.debug("testSaveResume [1]: getting client");
            resume.setClient((Client) dp.getRecord(Client.class, "1"));

            log.debug("testSaveResume [2]: saving resume, resume = {}", resume);
            dp.saveRecord(resume);
            log.debug("testSaveResume [3]: resume saved succesful");
        } catch(Exception ex){
            log.debug("testSaveResume [4]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(4)
    @Test
    public void testGetResume() {
        try {
            log.debug("testGetResume [1]: get resume");
            Resume resume = (Resume) dp.getRecord(Resume.class, "1");

            assertEquals(1, resume.getId());
            log.debug("testGetResume [2]: resume = {}", resume);
        } catch (Exception ex) {
            log.debug("testGetResume [3]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(5)
    @Test
    public void testSaveSeparateQual(){
        SeparateQual separateQual = getSeparateQual();

        try{
            log.debug("testSaveSeparateQual [1]: saving separateQual = {}", separateQual);
            dp.saveRecord(separateQual);
            ;
            log.debug("testSaveSeparateQual [2]: separateQual saved succesful");
        } catch(Exception ex){
            log.debug("testSaveSeparateQual [3]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(6)
    @Test
    public void testGetSeparateQual() {
        try {
            log.debug("testGetSeparateQual [1]: get separateQual");
            SeparateQual separateQual = (SeparateQual) dp.getRecord(SeparateQual.class, "1");

            assertEquals(1, separateQual.getId());
            log.debug("testGetSeparateQual [2]: separateQual = {}", separateQual);
        } catch (Exception ex) {
            log.debug("testGetSeparateQual [3]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(7)
    @Test
    public void testSaveCompany(){
        Company company = getCompany();
        try{
            log.debug("testSaveCompany [1]: getting separateQual");
            List<SeparateQual> separateQuals = new ArrayList<>();
            separateQuals.add((SeparateQual) dp.getRecord(SeparateQual.class, "1"));
            company.setSeparateQuals(separateQuals);

            log.debug("testSaveCompany [2]: saving company = {}", company);
            dp.saveRecord(company);
;
            log.debug("testSaveCompany [3]: company saved succesful");
        } catch(Exception ex){
            log.debug("testSaveCompany [4]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(8)
    @Test
    public void testGetCompany() {
        try {
            log.debug("testGetCompany [1]: get company");
            Company company = (Company) dp.getRecord(Company.class, "1");

            assertEquals(1, company.getId());
            log.debug("testGetCompany [2]: company = {}", company);
        } catch (Exception ex) {
            log.debug("testGetCompany [3]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(9)
    @Test
    public void testSaveEmployee(){
        Employee employee = getEmployee();
        try{
            log.debug("testSaveEmployee [1]: getting company");
            Company company = (Company) dp.getRecord(Company.class, "1");
            employee.setCompany(company);
            log.debug("testSaveEmployee [2] company = {}", company);

            log.debug("testSaveEmployee [3]: saving employee = {}", employee);
            dp.saveRecord(employee);
            log.debug("testSaveEmployee [4]: employee saved succesful");
        } catch(Exception ex){
            log.debug("testSaveEmployee [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(10)
    @Test
    public void testGetEmployee() {
        try {
            log.debug("testGetEmployee [1]: get employee");
            Employee employee = (Employee) dp.getRecord(Employee.class, "2");

            assertEquals(2, employee.getId());
            log.debug("testGetEmployee [2]: employee = {}", employee);
        } catch (Exception ex) {
            log.debug("testGetEmployee [3]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(11)
    @Test
    public void testSaveVacancy(){
        Vacancy vacancy = getVacancy();
        try{
            log.debug("testSaveVacancy [1]: getting company");
            Company company = (Company) dp.getRecord(Company.class, "1");
            log.debug("testSaveVacancy [2] company = {}", company);

            vacancy.setCompany(company);

            log.debug("testSaveVacancy [3] saving vacancy");
            dp.saveRecord(vacancy);
            log.debug("testSaveEmployee [4]: vacancy saved succesful");

        } catch(Exception ex){
            log.debug("testSaveVacancy [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(12)
    @Test
    public void testGetVacancy() {
        try {
            log.debug("testGetVacancy [1]: get vacancy");
            Vacancy vacancy = (Vacancy) dp.getRecord(Vacancy.class, "1");

            assertEquals(1, vacancy.getId());
            log.debug("testGetVacancy [2]: vacancy = {}", vacancy);
        } catch (Exception ex) {
            log.debug("testGetVacancy [3]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование обновления объекта Client
     */
    @Order(13)
    @Test
    public void testUpdateClient() {
        try {
            log.debug("testUpdateClient [1]: get client");
            Client client = (Client) dp.getRecord(Client.class, "1");
            log.debug("testUpdateClient [2]: client = {}", client);

            client.setName("UpdatedName");

            log.debug("testUpdateClient [3]: update client = {}", client);
            dp.updateRecord(client);
            log.debug("testUpdateClient [4]: client updated successful");
        } catch (Exception ex) {
            log.debug("testUpdateClient [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование обновления объекта Employee
     */
    @Order(14)
    @Test
    public void testUpdateEmployee() {
        try {
            log.debug("testUpdateEmployee [1]: get employee");
            Employee employee = (Employee) dp.getRecord(Employee.class, "2");
            log.debug("testUpdateEmployee [2]: employee = {}", employee);

            employee.setPosition("UpdatedPosition");

            log.debug("testUpdateEmployee [3]: update employee = {}", employee);
            dp.updateRecord(employee);
            log.debug("testUpdateEmployee [4]: employee updated successful");
        } catch (Exception ex) {
            log.debug("testUpdateEmployee [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование обновления объекта Resume
     */
    @Order(15)
    @Test
    public void testUpdateResume() {
        try {
            log.debug("testUpdateResume [1]: get resume");
            Resume resume = (Resume) dp.getRecord(Resume.class, "1");
            log.debug("testUpdateResume [2]: resume = {}", resume);

            resume.setProfession("UpdatedProfession");

            log.debug("testUpdateResume [3]: update resume = {}", resume);
            dp.updateRecord(resume);
            log.debug("testUpdateResume [4]: resume updated successful");
        } catch (Exception ex) {
            log.debug("testUpdateResume [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование обновления объекта SeparateQual
     */
    @Order(16)
    @Test
    public void testUpdateSeparateQual() {
        try {
            log.debug("testUpdateSeparateQual [1]: get separateQual");
            SeparateQual separateQual = (SeparateQual) dp.getRecord(SeparateQual.class, "1");
            log.debug("testUpdateSeparateQual [2]: separateQual = {}", separateQual);

            separateQual.setDescription("UpdatedDescription");

            log.debug("testUpdateSeparateQual [3]: update separateQual = {}", separateQual);
            dp.updateRecord(separateQual);
            log.debug("testUpdateSeparateQual [4]: separateQual updated successful");
        } catch (Exception ex) {
            log.debug("testUpdateSeparateQual [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование обновления объекта Vacancy
     */
    @Order(17)
    @Test
    public void testUpdateVacancy() {
        try {
            log.debug("testUpdateVacancy [1]: get vacancy");
            Vacancy vacancy = (Vacancy) dp.getRecord(Vacancy.class, "1");
            log.debug("testUpdateVacancy [2]: vacancy = {}", vacancy);

            vacancy.setTitle("UpdatedTitle");

            log.debug("testUpdateVacancy [3]: update vacancy = {}", vacancy);
            dp.updateRecord(vacancy);
            log.debug("testUpdateVacancy [4]: vacancy updated successful");
        } catch (Exception ex) {
            log.debug("testUpdateVacancy [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование обновления объекта Company
     */
    @Order(18)
    @Test
    public void testUpdateCompany() {
        try {
            log.debug("testUpdateCompany [1]: get company");
            Company company = (Company) dp.getRecord(Company.class, "1");
            log.debug("testUpdateCompany [2]: company = {}", company);

            company.setDescription("UpdatedDescription");

            log.debug("testUpdateCompany [3]: update company = {}", company);
            dp.updateRecord(company);
            log.debug("testUpdateCompany [4]: company updated successful");
        } catch (Exception ex) {
            log.debug("testUpdateCompany [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование удаления объекта Resume
     */
    @Order(19)
    @Test
    public void testDeleteResume() {
        try {
            log.debug("testDeleteResume [1]: get resume");
            Resume resume = (Resume) dp.getRecord(Resume.class, "1");
            log.debug("testDeleteResume [2]: resume = {}", resume);

            dp.deleteRecord(resume);
            log.debug("testDeleteResume [3]: resume deleted successful");

            Resume deletedResume = (Resume) dp.getRecord(Resume.class, "1");
            assertNull(deletedResume);
            log.debug("testDeleteResume [4]: resume = null");
        } catch (Exception ex) {
            log.debug("testDeleteResume [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование удаления объекта Client
     */
    @Order(20)
    @Test
    public void testDeleteClient() {
        try {
            log.debug("testDeleteClient [1]: get client");
            Client client = (Client) dp.getRecord(Client.class, "1");
            log.debug("testDeleteClient [2]: client = {}", client);

            dp.deleteRecord(client);
            log.debug("testDeleteClient [3]: client deleted successful");

            Client deletedClient = (Client) dp.getRecord(Client.class, "1");
            assertNull(deletedClient);
            log.debug("testDeleteClient [4]: client = null");
        } catch (Exception ex) {
            log.debug("testDeleteClient [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование удаления объекта Employee
     */
    @Order(21)
    @Test
    public void testDeleteEmployee() {
        try {
            log.debug("testDeleteEmployee [1]: get employee");
            Employee employee = (Employee) dp.getRecord(Employee.class, "2");
            log.debug("testDeleteEmployee [2]: employee = {}", employee);

            dp.deleteRecord(employee);
            log.debug("testDeleteEmployee [3]: employee deleted successful");

            Employee deletedEmployee = (Employee) dp.getRecord(Employee.class, "2");
            assertNull(deletedEmployee);
            log.debug("testDeleteEmployee [4]: employee = null");
        } catch (Exception ex) {
            log.debug("testDeleteEmployee [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование удаления объекта Vacancy
     */
    @Order(22)
    @Test
    public void testDeleteVacancy() {
        try {
            log.debug("testDeleteVacancy [1]: get vacancy");
            Vacancy vacancy = (Vacancy) dp.getRecord(Vacancy.class, "1");
            log.debug("testDeleteVacancy [2]: vacancy = {}", vacancy);

            dp.deleteRecord(vacancy);
            log.debug("testDeleteVacancy [3]: vacancy deleted successful");

            Vacancy deletedVacancy = (Vacancy) dp.getRecord(Vacancy.class, "1");
            assertNull(deletedVacancy);
            log.debug("testDeleteVacancy [4]: vacancy = null");
        } catch (Exception ex) {
            log.debug("testDeleteVacancy [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    /**
     * Тестирование удаления объекта Company
     */
    @Order(23)
    @Test
    public void testDeleteCompany() {
        try {
            log.debug("testDeleteCompany [1]: get company");
            Company company = (Company) dp.getRecord(Company.class, "1");
            log.debug("testDeleteCompany [2]: company = {}", company);

            dp.deleteRecord(company);
            log.debug("testDeleteCompany [3]: company deleted successful");

            Company deletedCompany = (Company) dp.getRecord(Company.class, "1");
            assertNull(deletedCompany);
            log.debug("testDeleteCompany [4]: company = null");
        } catch (Exception ex) {
            log.debug("testDeleteCompany [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }



    /**
     * Тестирование удаления объекта SeparateQual
     */
    @Order(24)
    @Test
    public void testDeleteSeparateQual() {
        try {
            log.debug("testDeleteSeparateQual [1]: get separateQual");
            SeparateQual separateQual = (SeparateQual) dp.getRecord(SeparateQual.class, "1");
            log.debug("testDeleteSeparateQual [2]: separateQual = {}", separateQual);

            dp.deleteRecord(separateQual);
            log.debug("testDeleteSeparateQual [3]: separateQual deleted successful");

            SeparateQual deletedSeparateQual = (SeparateQual) dp.getRecord(SeparateQual.class, "1");
            assertNull(deletedSeparateQual);
            log.debug("testDeleteSeparateQual [4]: separateQual = null");
        } catch (Exception ex) {
            log.debug("testDeleteSeparateQual [5]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }

    @Order(25)
    @Test
    public void testCreateAndSaveCompanies() {
        log.debug("testCreateAndSaveCompanies [1]: start creating 1000 Company objects");

        List<SeparateQual> separateQualList = IntStream.range(0, 10)
                .mapToObj(i -> {
                    SeparateQual separateQual = new SeparateQual();
                    separateQual.setQuality(i);
                    separateQual.setDescription("Description " + i);
                    return separateQual;
                })
                .collect(Collectors.toList());

        separateQualList.forEach(sq -> assertDoesNotThrow(() -> dp.saveRecord(sq)));

        List<Company> companies = IntStream.range(0, 1000)
                .mapToObj(i -> {
                    Company company = new Company();
                    company.setTitle("Company " + i);
                    company.setDescription("Description for company " + i);
                    company.setSeparateQuals(separateQualList.subList(0, (i % 10) + 1));
                    return company;
                })
                .collect(Collectors.toList());

        companies.forEach(company -> assertDoesNotThrow(() -> dp.saveRecord(company)));

        log.debug("testCreateAndSaveCompanies [2]: successfully created and saved 1000 Company objects");
    }

    /**
     * Tests the selectAllNativeSql method for Company.
     * Measures execution time.
     */
    @Order(26)
    @Test
    public void testSelectAllNativeSql() {
        log.debug("testSelectAllNativeSql [1]: start select all using native SQL");

        long startTime = System.currentTimeMillis();

        List<Company> companies = dp.selectAllNativeSql();
        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;
        log.debug("testSelectAllNativeSql [2]: duration = {} ms", duration);

        assertNotNull(companies);
        log.debug("testSelectAllNativeSql [3]: result = {}", companies);
    }

    /**
     * Tests the selectAllCriteria method for Company.
     * Measures execution time.
     */
    @Order(27)
    @Test
    public void testSelectAllCriteria() {
        log.debug("testSelectAllCriteria [1]: start select all using Criteria");

        long startTime = System.currentTimeMillis();

        List<Company> companies = dp.selectAllCriteria();
        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;
        log.debug("testSelectAllCriteria [2]: duration = {} ms", duration);

        assertNotNull(companies);
        log.debug("testSelectAllCriteria [3]: result = {}", companies);
    }

    /**
     * Tests the selectAllHQL method for Company.
     * Measures execution time.
     */
    @Order(28)
    @Test
    public void testSelectAllHQL() {
        log.debug("testSelectAllHQL [1]: start select all using HQL");

        long startTime = System.currentTimeMillis();

        List<Company> companies = dp.selectAllHQL();
        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;
        log.debug("testSelectAllHQL [2]: duration = {} ms", duration);

        assertNotNull(companies);
        log.debug("testSelectAllHQL [3]: result = {}", companies);
    }

}