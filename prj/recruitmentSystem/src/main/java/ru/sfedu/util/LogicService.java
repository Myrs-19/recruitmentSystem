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
        log.info("hireEmployee [1]: hiring employee, id resume = {}, id vacancy = {}", idResume, idVacancy);
        
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
            
            log.info("hireEmployee [2]: Человек успешно нанят");
            
        } catch(NullPointerException ex){
            log.info("hireEmployee [3]: Таких записей нет");
            
            return;
        }
        
    }
    
    public void giveAssessment(int idEmployee, int idCompany, int quality, String description){
        log.info("giveAssessment [1]: Даем оценку компании, id employee = {}, id company = {}, quality = {}", idEmployee, idCompany, quality);
        if(checkQuality(quality) && checkDealTogether(idEmployee, idCompany)){
            try{
                
                
                
            } catch(NullPointerException ex){
                log.info("giveAssessment []: Таких записей нет");
            }
        }
    }
    
    private boolean checkQuality(int quality){
        log.debug("checkQuality [1]: validation quality");
        return quality >= Constants.MIN_QUALITY && quality <= Constants.MAX_QUALITY;
    }
    
    private boolean checkDealTogether(int idEmployee, int idCompany){
        log.debug("checkDealTogether [1]: checking deal");
        try{
            dataProvider.getCompany(idCompany);
        } catch(NullPointerException ex){
            log.debug("checkDealTogether [2]: такой компании нет, id company = {}", idCompany);
        }
        
        try{
            Employee employee = dataProvider.getEmployee(idEmployee);
            return employee.getCompanyId() == idCompany;
        } catch(NullPointerException ex){
            log.debug("checkDealTogether [2]: такого сотрудника нет, id employee = {}", idEmployee);
        }
        
        return false;
    }
}
