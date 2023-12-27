/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.sfedu.Constants;

import ru.sfedu.model.*;

import static ru.sfedu.model.TypePerson.ClientType;
import static ru.sfedu.model.TypePerson.EmployeeType;

/**
 *
 * @author mike
 */
public class h2Util {
    
    /** Method generates statement for different type of person
     * @param person - бин который нужно обработать
     * @param preStat - statement with sql inside
     */
    public static void fillStatPerson(PreparedStatement preStat, Person person) throws NullPointerException, SQLException{
        switch(person.getTypePerson()){
            case ClientType:{
                Client client = (Client) person;
                //person fields
                preStat.setString(1, client.getName());
                preStat.setString(2, client.getSurname());
                preStat.setString(3, client.getMiddleName());
                preStat.setInt(4, client.getAge());
                preStat.setString(5, client.getBirthday());
                preStat.setString(6, client.getPhone());
                preStat.setString(7, client.getEmail());
                //client fields
                preStat.setString(8, client.getPassword());
                preStat.setString(9, client.getAddress());
                
                break;
            }
            case EmployeeType:{
                Employee employee = (Employee) person;
                //employee fields
                preStat.setString(1, employee.getName());
                preStat.setString(2, employee.getSurname());
                preStat.setString(3, employee.getMiddleName());
                preStat.setInt(4, employee.getAge());
                preStat.setString(5, employee.getBirthday());
                preStat.setString(6, employee.getPhone());
                preStat.setString(7, employee.getEmail());
                
                preStat.setInt(8, employee.getCompany().getId());
                preStat.setInt(9, employee.getSalary());
                preStat.setString(10, employee.getPosition());
                preStat.setBoolean(11, employee.getIsWorking());
                
                break;
            }
                default:
                    throw new NullPointerException("not defined");
            }
    }
    
    /** Method create client through ResultSet
     * @param res - object of data client
     * @return filled instance Client
     */
    public static Client createClient(ResultSet res) throws SQLException {
        
        Client client = new Client();
        client.setTypePerson(ClientType);
        
        client.setId(res.getInt(1));
        client.setName(res.getString(2));
        client.setSurname(res.getString(3));
        client.setMiddleName(res.getString(4));
        client.setAge(res.getInt(5));
        client.setBirthday(res.getString(6));
        client.setPhone(res.getString(7));
        client.setEmail(res.getString(8));
        client.setPassword(res.getString(9));
        client.setAddress(res.getString(10));
            
        return client;
    }
    
    /** Method create resume through ResultSet
     * @param res - object of data resume
     * @return filled instance Resume
     */
    public static Resume createResume(ResultSet res) throws SQLException {
        
        Resume resume = new Resume();
            
        resume.setId(res.getInt(1));
//        resume.setClientId(res.getInt(2));
        resume.setProfession(res.getString(3));
        resume.setCity(res.getString(4));
        resume.setSkills(res.getString(5));
        resume.setEducation(res.getString(6));
        resume.setExperience(res.getString(7));
        resume.setSex(res.getBoolean(8));
        resume.setWorkPermit(res.getBoolean(9));
        resume.setCitizenship(res.getString(10));
            
        return resume;
    }
    
    /** Method create company through ResultSet
     * @param res - object of data company
     * @return filled instance Company
     */
    public static Company createCompany(ResultSet res) throws SQLException {
        
        Company company = new Company();
            
        company.setId(res.getInt(1));
        company.setTitle(res.getString(2));
        company.setDescription(res.getString(3));
        
        return company;
    }
    
    /** Method create vacancy through ResultSet
     * @param res - object of data vacancy
     * @return filled instance Vacancy
     */
    public static Vacancy createVacancy(ResultSet res) throws SQLException {
        
        Vacancy vacancy = new Vacancy();
            
        vacancy.setId(res.getInt(1));
//        vacancy.setCompanyId(res.getInt(2));
        vacancy.setTitle(res.getString(3));
        vacancy.setSpecialization(res.getString(4));
        vacancy.setOnline(res.getBoolean(5));
        vacancy.setSkills(res.getString(6));
        vacancy.setSalary(res.getInt(7));
        vacancy.setCity(res.getString(8));
        vacancy.setAddress(res.getString(9));
        vacancy.setExperience(res.getString(10));
            
        return vacancy;
    }
    
    /** Method create employee through ResultSet
     * @param res - object of data employee
     * @return filled instance Employee
     */
    public static Employee createEmployee(ResultSet res) throws SQLException {
        
        Employee employee = new Employee();
        employee.setTypePerson(EmployeeType);
        
        employee.setId(res.getInt(1));
        employee.setName(res.getString(2));
        employee.setSurname(res.getString(3));
        employee.setMiddleName(res.getString(4));
        employee.setAge(res.getInt(5));
        employee.setBirthday(res.getString(6));
        employee.setPhone(res.getString(7));
        employee.setEmail(res.getString(8));
//        employee.setCompanyId(res.getInt(9));
        employee.setSalary(res.getInt(10));
        employee.setPosition(res.getString(11));
        employee.setIsWorking(res.getBoolean(12));
        
        return employee;
    }
    
    /** Method create separate quality through ResultSet
     * @param res - object of data separateQual
     * @return filled instance SeparateQual
     */
    public static SeparateQual createSeparateQual(ResultSet res) throws SQLException {
        
        SeparateQual separateQual = new SeparateQual();
            
        separateQual.setId(res.getInt(1));
//        separateQual.setCompanyId(res.getInt(2));
        separateQual.setQuality(res.getInt(3));
        separateQual.setDescription(res.getString(4));
        
        return separateQual;
    }
    
    /** Method fills PrepapedStatement instance with needed sql
     * @param preStat - statement with sql inside
     * @param resume - which filling PreparedStatement
     */
    public static void fillStatResume(PreparedStatement preStat, Resume resume) throws SQLException{
        preStat.setInt(1, resume.getClient().getId());
        preStat.setString(2, resume.getProfession());
        preStat.setString(3, resume.getCity());
        preStat.setString(4, resume.getSkills());
        preStat.setString(5, resume.getEducation());
        preStat.setString(6, resume.getExperience());
        preStat.setBoolean(7, resume.getSex());
        preStat.setBoolean(8, resume.getWorkPermit());
        preStat.setString(9, resume.getCitizenship());
    }
    
    /** Method fills PrepapedStatement instance with needed sql
     * @param preStat - statement with sql inside
     * @param company - which filling PreparedStatement
     */
    public static void fillStatCompany(PreparedStatement preStat, Company company) throws SQLException{
        preStat.setString(1, company.getTitle());
        preStat.setString(2, company.getDescription());
    }
    
    /** Method fills PrepapedStatement instance with needed sql
     * @param preStat - statement with sql inside
     * @param vacancy - which filling PreparedStatement
     */
    public static void fillStatVacancy(PreparedStatement preStat, Vacancy vacancy) throws SQLException{
        preStat.setInt(1, vacancy.getCompany().getId());
        preStat.setString(2, vacancy.getTitle());
        preStat.setString(3, vacancy.getSpecialization());
        preStat.setBoolean(4, vacancy.getOnline());
        preStat.setString(5, vacancy.getSkills());
        preStat.setInt(6, vacancy.getSalary());
        preStat.setString(7, vacancy.getCity());
        preStat.setString(8, vacancy.getAddress());
        preStat.setString(9, vacancy.getExperience());
    }
    
    /** Method fills PrepapedStatement instance with needed sql
     * @param preStat - statement with sql inside
     * @param separateQual  - which filling PreparedStatement
     */
    public static void fillStatSeparateQual(PreparedStatement preStat, SeparateQual separateQual) throws SQLException{
        preStat.setInt(1, separateQual.getCompany().getId());
        preStat.setInt(2, separateQual.getQuality());
        preStat.setString(3, separateQual.getDescription());
    }
}
