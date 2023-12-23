/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.util;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

import ru.sfedu.api.*;

import ru.sfedu.model.*;

/**
 *
 * @author mike
 */
public class LogicService {
    private static final Logger log = LogManager.getLogger(LogicService.class.getName());
    
    private final IDataProvider dataProvider;
    
    public LogicService(IDataProvider dataProvider){
        log.debug("LogicService [1]: init logic service");
        this.dataProvider = dataProvider;
    }
    
    /**Method allows to hire person
     * @param idResume - the ID of the resume through which they want to hire
     * @param idVacancy - the ID of the vacancy for the position that is being hired
     */
    public void hireEmployee(int idResume, int idVacancy) throws Exception{
        log.debug("hireEmployee [1]: hiring employee, id resume = {}, id vacancy = {}", idResume, idVacancy);
        
        try{
            Resume resume = dataProvider.getResume(idResume);
            Vacancy vacancy = dataProvider.getVacancy(idVacancy);
            Client client = dataProvider.getClient(resume.getClientId());
            
            Employee employee = new Employee();
            
            employee.setTypePerson(TypePerson.EmployeeType);
            
            employee.setName(client.getName());
            employee.setSurname(client.getSurname());
            employee.setMiddleName(client.getMiddleName());
            employee.setAge(client.getAge());
            employee.setBirthday(client.getBirthday());
            employee.setPhone(client.getPhone());
            employee.setEmail(client.getEmail());
            employee.setCompanyId(vacancy.getCompanyId());
            employee.setSalary(vacancy.getSalary());
            employee.setPosition(vacancy.getTitle());
            employee.setIsWorking(true);
            
            dataProvider.savePerson(employee);
            
            log.debug("hireEmployee [2]: Человек успешно нанят");
            
        } catch(NullPointerException ex){
            log.error("hireEmployee [3]: Таких записей нет");
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
        
    }
    
    /** Method creating assessment
     * @param idEmployee - id Employee
     * @param idCompany - id Company
     * @param quality - quality of assessment
     * @param description - description of assessment
     */
    public void giveAssessment(int idEmployee, int idCompany, int quality, String description) throws Exception{
        log.debug("giveAssessment [1]: Даем оценку компании, id employee = {}, id company = {}, quality = {}", idEmployee, idCompany, quality);
        if(checkQuality(quality) && checkDealTogether(idEmployee, idCompany)){
            
            SeparateQual separateQual = new SeparateQual();
                
            separateQual.setCompanyId(idCompany);
            separateQual.setEmployeeId(idEmployee);
            separateQual.setDescription(description);
            separateQual.setQuality(quality);
                
            Result result = dataProvider.saveSeparateQual(separateQual);
            log.debug("giveAssessment [2]: результат сохранения, result = {}", result.getMessage());
        }else{
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
    }
    
    /**Method creating file with result of calculate assessment. Result - average quality of assessment
     @param idCompany - ID company
     */
    public void calculateAssessment(int idCompany) throws Exception{
        
    }
    
    /**Method saving new client
     * @param name - client name
     * @param surname - client surname
     * @param middleName - client middleName
     * @param age - client age
     * @param birthday - client birthday
     * @param phone - client phone
     * @param email - client email
     * @param password - client password
     * @param address - client address
     * @throws Exception then data is not valid
     */
    public void clientRegistration(String name, String surname, String middleName, int age, String birthday, String phone, String email, String password, String address) throws Exception{
        log.debug("clientRegistration [1]: registration new client");
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        fillClient(client, name, surname, middleName, age, birthday, phone, email, password, address);
        
        validateClient(client);
        
        log.debug("clientRegistration [2]: saving new client, client = {}", client);
        Result result = dataProvider.savePerson(client);
        
        log.debug("clientRegistration [3]: save client result - {}", result.getMessage());        
    }
    
    /**Method saving new company
     * @param title - title company
     * @param description  - description company
     * @throws Exception then data is not valid
     */
    public void companyRegistration(String title, String description) throws Exception{
        log.debug("companyRegistration [1]: registration new company");
        
        Company company = new Company();
        
        fillCompany(company, title, description);
        
        validateCompany(company);
        
        log.debug("companyRegistration [2]: saving new company, company = {}", company);
        Result result = dataProvider.saveCompany(company);
        
        log.debug("companyRegistration [3]: save company result - {}", result.getMessage());   
    }
    
    /**Method saving new resume
     * @param idClient - ID client of resume
     * @param profession  - profession in resume
     * @param city - city in resume
     * @param skills  - skills in resume
     * @param education  - education in resume
     * @param experience  - experience in resume
     * @param sex  - sex in resume
     * @param workPermit  - workPermit in resume
     * @param citizenship  - citizenship in resume
     * @throws Exception then data is not valid or such client does not exists
     */
    public void resumeRegistration(int idClient, String profession, String city, String skills, String education, String experience, boolean sex, boolean workPermit, String citizenship) throws Exception{
        log.debug("resumeRegistration [1]: registration new resume");
        
        Resume resume = new Resume();
        
        fillResume(resume, idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
        
        validateResume(resume);
        
        log.debug("resumeRegistration [2]: saving new resume, resume = {}", resume);
        Result result = dataProvider.saveResume(resume);
        
        log.debug("resumeRegistration [3]: save resume result - {}", result.getMessage());   
    }
    
    /**Method saving new vacancy
     * @param idCompany - ID resume company
     * @param title  - title in resume
     * @param specialization - specialization in resume
     * @param online  - online in resume
     * @param skills  - education in resume
     * @param salary  - experience in resume
     * @param city  - sex in resume
     * @param address  - workPermit in resume
     * @param experience  - citizenship in resume
     * @throws Exception then data is not valid or such client does not exists
     */
    public void vacancyRegistration(int idCompany, String title, String specialization, boolean online, String skills, int salary, String city, String address, String experience) throws Exception{
        log.debug("vacancyRegistration [1]: registration new vacancy");
        
        Vacancy vacancy = new Vacancy();
        
        fillVacancy(vacancy, idCompany, title, specialization, online, skills, salary, city, address, experience);
        
        validateVacancy(vacancy);
        
        log.debug("vacancyRegistration [2]: saving new vacancy, vacancy = {}", vacancy);
        Result result = dataProvider.saveVacancy(vacancy);
        
        log.debug("vacancyRegistration [3]: save vacancy result - {}", result.getMessage());   
    }
    
    /**Method changes client by id
     * @param id - client id
     * @param name - client name
     * @param surname - client surname
     * @param middleName - client middleName
     * @param age - client age
     * @param birthday - client birthday
     * @param phone - client phone
     * @param email - client email
     * @param password - client password
     * @param address - client address
     * @throws Exception then data is not valid
     */
    public void clientChange(int id, String name, String surname, String middleName, int age, String birthday, String phone, String email, String password, String address) throws Exception{
        log.debug("clientChange [1]: changing client by id, id = {}", id);
        
        dataProvider.getClient(id);
        
        Client client = new Client();
        client.setTypePerson(TypePerson.ClientType);
        
        fillClient(client, name, surname, middleName, age, birthday, phone, email, password, address);
        
        validateClient(client);
        
        client.setId(id);
        
        log.debug("clientChange [2]: change client, client = {}", client);
        Result result = dataProvider.updatePerson(client);
        
        log.debug("clientChange [3]: change client result - {}", result.getMessage());        
    }
    
    /**Method changing company
     * @param id - company id
     * @param title - title company
     * @param description  - description company
     * @throws Exception then data is not valid
     */
    public void companyChange(int id, String title, String description) throws Exception{
        log.debug("companyChange [1]: changing company, id = {}", id);
        
        dataProvider.getCompany(id);
        
        Company company = new Company();
        
        fillCompany(company, title, description);
        
        validateCompany(company);
        
        company.setId(id);
        
        log.debug("companyChange [3]: changing company, company = {}", company);
        Result result = dataProvider.updateCompany(company);
        
        log.debug("companyChange [4]: change company result - {}", result.getMessage());   
    }
    
    /**Method changing resume
     * @param id - resume id
     * @param idClient - ID client of resume
     * @param profession  - profession in resume
     * @param city - city in resume
     * @param skills  - skills in resume
     * @param education  - education in resume
     * @param experience  - experience in resume
     * @param sex  - sex in resume
     * @param workPermit  - workPermit in resume
     * @param citizenship  - citizenship in resume
     * @throws Exception then data is not valid or such client does not exists
     */
    public void resumeChange(int id, int idClient, String profession, String city, String skills, String education, String experience, boolean sex, boolean workPermit, String citizenship) throws Exception{
        log.debug("resumeChange [1]: changing resume, id = {}", id);
        
        dataProvider.getResume(id);
        
        Resume resume = new Resume();
        
        fillResume(resume, idClient, profession, city, skills, education, experience, sex, workPermit, citizenship);
        
        validateResume(resume);
        
        resume.setId(id);
        
        log.debug("resumeChange [2]: changing resume, resume = {}", resume);
        Result result = dataProvider.updateResume(resume);
        
        log.debug("resumeChange [3]: change resume result - {}", result.getMessage());   
    }
    
    /**Method changing vacancy
     * @param id - vacancy id
     * @param idCompany - ID resume company
     * @param title  - title in resume
     * @param specialization - specialization in resume
     * @param online  - online in resume
     * @param skills  - education in resume
     * @param salary  - experience in resume
     * @param city  - sex in resume
     * @param address  - workPermit in resume
     * @param experience  - citizenship in resume
     * @throws Exception then data is not valid or such client does not exists
     */
    public void vacancyChange(int id, int idCompany, String title, String specialization, boolean online, String skills, int salary, String city, String address, String experience) throws Exception{
        log.debug("vacancyChange [1]: changing vacancy, id = {}", id);
        
        dataProvider.getVacancy(id);
        
        Vacancy vacancy = new Vacancy();
        
        fillVacancy(vacancy, idCompany, title, specialization, online, skills, salary, city, address, experience);
        
        validateVacancy(vacancy);
        
        vacancy.setId(id);
        
        log.debug("vacancyChange [2]: change vacancy, vacancy = {}", vacancy);
        Result result = dataProvider.updateVacancy(vacancy);
        
        log.debug("vacancyChange [3]: change vacancy result - {}", result.getMessage());   
    }
    
    /**Method validates quality
     @param quality - quality of assessment
     @return result of quality validation 
     */
    private boolean checkQuality(int quality){
        log.debug("checkQuality [1]: validation quality");
        return quality >= Constants.MIN_QUALITY && quality <= Constants.MAX_QUALITY;
    }
    
    /**Method checks that employee with such id and company with such id have dealed
     @param idEmployee - ID of Employee
     @param idCompany - ID of Company
     @return result of checking deal together
     */
    private boolean checkDealTogether(int idEmployee, int idCompany){
        log.debug("checkDealTogether [1]: checking deal");
        try{
            dataProvider.getCompany(idCompany);
        } catch(NullPointerException ex){
            log.debug("checkDealTogether [2]: такой компании нет, id company = {}", idCompany);
            return false;
        }
        
        try{
            Employee employee = dataProvider.getEmployee(idEmployee);
            return employee.getCompanyId() == idCompany;
        } catch(NullPointerException ex){
            log.debug("checkDealTogether [2]: такого сотрудника нет, id employee = {}", idEmployee);
        }
        
        return false;
    }
    
    /**Method validates client data
     * @throws Exception means data is not valide
     */
    private void validateClient(Client client) throws Exception{
        log.debug("validateClient [1]: validation client");
        if(client.getName() == null || client.getSurname() == null || client.getAge() == 0 || client.getPassword() == null || client.getAddress() == null){
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
    }
    
    /**Method validates company data
     * @throws Exception means data is not valide
     */
    private void validateCompany(Company company) throws Exception{
        log.debug("validateCompany [1]: validation company");
        if(company.getTitle()== null){
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
    }
    
    /**Method validates resume data and is exists client
     * @throws Exception means data is not valide or client does not exists
     */
    private void validateResume(Resume resume) throws Exception{
        log.debug("validateResume [1]: validation resume");
        try{
            dataProvider.getClient(resume.getClientId());
        } catch(NullPointerException ex){
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
        
        if(resume.getClientId()== 0 || resume.getProfession() == null || resume.getCity() == null){
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
    }
    
    /**Method validates vacancy data and is exists company
     * @throws Exception means data is not valide or company does not exists
     */
    private void validateVacancy(Vacancy vacancy) throws Exception{
        log.debug("validateVacancy [1]: validation vacancy");
        try{
            dataProvider.getCompany(vacancy.getCompanyId());
        } catch(NullPointerException ex){
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
        
        if(vacancy.getCompanyId() == 0 || vacancy.getTitle() == null){
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
    }
    
    /**Method fill client bean
     */
    private void fillClient(Client client, String name, String surname, String middleName, int age, String birthday, String phone, String email, String password, String address){
        client.setName(name);
        client.setSurname(surname);
        client.setMiddleName(middleName);
        client.setAge(age);
        client.setBirthday(birthday);
        client.setPhone(phone);
        client.setEmail(email);
        client.setPassword(password);
        client.setAddress(address);
    }
    
    /**Method fill company bean
     */
    private void fillCompany(Company company, String title, String description){
        company.setTitle(title);
        company.setDescription(description);
    }
    
    /**Method fill resume bean
     */
    private void fillResume(Resume resume, int idClient, String profession, String city, String skills, String education, String experience, boolean sex, boolean workPermit, String citizenship){
        resume.setClientId(idClient);
        resume.setProfession(profession);
        resume.setCity(city);
        resume.setSkills(skills);
        resume.setEducation(education);
        resume.setExperience(experience);
        resume.setSex(sex);
        resume.setWorkPermit(workPermit);
        resume.setCitizenship(citizenship);
    }
    
    /**Method fill vacancy bean
     */
    private void fillVacancy(Vacancy vacancy, int idCompany, String title, String specialization, boolean online, String skills, int salary, String city, String address, String experience){
        vacancy.setCompanyId(idCompany);
        vacancy.setTitle(title);
        vacancy.setSpecialization(specialization);
        vacancy.setOnline(online);
        vacancy.setSkills(skills);
        vacancy.setSalary(salary);
        vacancy.setCity(city);
        vacancy.setAddress(address);
        vacancy.setExperience(experience);
    }
}
