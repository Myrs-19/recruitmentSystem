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
    public void hireEmployee(int idResume, int idVacancy){
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
            
            return;
        }
        
    }
    
    /** Method creating assessment
     * @param idEmployee - id Employee
     * @param idCompany - id Company
     * @param quality - quality of assessment
     * @param description - description of assessment
     */
    public void giveAssessment(int idEmployee, int idCompany, int quality, String description){
        log.debug("giveAssessment [1]: Даем оценку компании, id employee = {}, id company = {}, quality = {}", idEmployee, idCompany, quality);
        if(checkQuality(quality) && checkDealTogether(idEmployee, idCompany)){
            
            SeparateQual separateQual = new SeparateQual();
                
            separateQual.setCompanyId(idCompany);
            separateQual.setEmployeeId(idEmployee);
            separateQual.setDescription(description);
            separateQual.setQuality(quality);
                
            Result result = dataProvider.saveSeparateQual(separateQual);
            log.debug("giveAssessment [2]: результат сохранения, result = {}", result.getMessage());
        }
    }
    
    /**Method creating file with result of calculate assessment. Result - average quality of assessment
     @param idCompany - ID company
     */
    public void calculateAssessment(int idCompany){
        
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
        
        client.setName(name);
        client.setSurname(surname);
        client.setMiddleName(middleName);
        client.setAge(age);
        client.setBirthday(birthday);
        client.setPhone(phone);
        client.setEmail(email);
        client.setPassword(password);
        client.setAddress(address);
        
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
        company.setTitle(title);
        company.setDescription(description);
        
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
        
        resume.setClientId(idClient);
        resume.setProfession(profession);
        resume.setCity(city);
        resume.setSkills(skills);
        resume.setEducation(education);
        resume.setExperience(experience);
        resume.setSex(sex);
        resume.setWorkPermit(workPermit);
        resume.setCitizenship(citizenship);
        
        validateResume(resume);
        
        log.debug("resumeRegistration [2]: saving new resume, resume = {}", resume);
        Result result = dataProvider.saveResume(resume);
        
        log.debug("resumeRegistration [3]: save resume result - {}", result.getMessage());   
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
    
    private void validateClient(Client client) throws Exception{
        log.debug("validateClient [1]: validation client");
        if(client.getName() == null || client.getSurname() == null || client.getAge() == 0 || client.getPassword() == null || client.getAddress() == null){
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
    }
    
    private void validateCompany(Company company) throws Exception{
        log.debug("validateCompany [1]: validation company");
        if(company.getTitle()== null){
            throw new Exception(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
    }
    
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
}
