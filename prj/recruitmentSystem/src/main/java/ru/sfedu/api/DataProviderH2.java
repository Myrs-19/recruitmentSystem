/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.api;

import java.sql.*;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

import ru.sfedu.model.*;
import static ru.sfedu.model.TypePerson.ClientType;
import static ru.sfedu.model.TypePerson.EmployeeType;
import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;

/**
 *
 * @author mike
 */
public class DataProviderH2 implements IDataProvider{
    
    private static final Logger log = LogManager.getLogger(DataProviderH2.class.getName());

    public DataProviderH2(){
        createTables();
    }
    
    /**Method creates all table all beans IF NOT EXISTS
    * создание таблиц, если еще не созданы
    */
    private void createTables(){
        log.debug("createTables[1]: creating tables for h2 data base");
        try(
                Connection conn = getConnection(); 
                Statement stat = conn.createStatement();
                ){
            
            
            stat.executeUpdate(Constants.H2_QUERY_CREATE_CLIENT);
            log.debug("createTables[2]: created client table");
            
            stat.executeUpdate(Constants.H2_QUERY_CREATE_COMPANY);
            log.debug("createTables[3]: created company table");
            
            stat.executeUpdate(Constants.H2_QUERY_CREATE_EMPLOYEE);
            log.debug("createTables[4]: created employee table");
            
            stat.executeUpdate(Constants.H2_QUERY_CREATE_RESUME);
            log.debug("createTables[5]: created resume table");
            
            stat.executeUpdate(Constants.H2_QUERY_CREATE_VACANCY);
            log.debug("createTables[6]: created vacancy table");
            
            stat.executeUpdate(Constants.H2_QUERY_CREATE_SEPARATE_QUAL);
            log.debug("createTables[7]: created separate quality table");
            
        } catch(SQLException ex){
            log.error("createTables[8]: error = {}", ex.getMessage());
        }
    }
    
    /** Method for getting connetion to H2 data base
    * @return h2 data base connector
    */
    public Connection getConnection() throws SQLException {
        log.debug("getConnection[1]: getting connect to h2 data base");
        return DriverManager.getConnection(
                getConfigurationEntry(Constants.H2_CONNECTOR)
                        .concat(Constants.H2_PREFIX_PATH)
                        .concat(getConfigurationEntry(Constants.H2_PATH))
                        .concat(Constants.H2_DB_NAME));
    }
    
    /** Method generates statement for different type of person
     * @param person - бин который нужно обработать
     * @param conn - connection, с помощью которого создается PreparedStatement и заполняется
     * @return возвращается PreparedStatement заполненый полями бина person
     */
    private PreparedStatement getSqlSavePerson(Person person, Connection conn) throws NullPointerException, SQLException{
        switch(person.getTypePerson()){
            case ClientType:{
                Client client = (Client) person;
                
                PreparedStatement preStat = conn.prepareStatement(Constants.H2_QUERY_INSERT_CLIENT);
               
                preStat.setString(1, client.getName());
                preStat.setString(2, client.getSurname());
                preStat.setString(3, client.getMiddleName());
                preStat.setInt(4, Integer.parseInt(client.getAge()));
                preStat.setString(5, client.getBirthday());
                preStat.setString(6, client.getPhone());
                preStat.setString(7, client.getEmail());
                
                preStat.setString(8, client.getPassword());
                preStat.setString(9, client.getAddress());
                
                return preStat;
            }
            case EmployeeType:{
                Employee employee = (Employee) person;
                
                PreparedStatement preStat = conn.prepareStatement(Constants.H2_QUERY_INSERT_EMPLOYEE);
               
                preStat.setString(1, employee.getName());
                preStat.setString(2, employee.getSurname());
                preStat.setString(3, employee.getMiddleName());
                preStat.setInt(4, Integer.parseInt(employee.getAge()));
                preStat.setString(5, employee.getBirthday());
                preStat.setString(6, employee.getPhone());
                preStat.setString(7, employee.getEmail());
                
                preStat.setInt(8, Integer.parseInt(employee.getCompanyId()));
                preStat.setString(9, employee.getStartWorkDate());
                preStat.setInt(10, Integer.parseInt(employee.getSalary()));
                preStat.setString(11, employee.getPosition());
                preStat.setBoolean(12, employee.getIsWorking());
                
                
                return preStat;
            }
                default:
                    throw new NullPointerException("not defined");
            }
    }
    
    /** See also {@link IDataProvider#savePerson(Person)}. */ 
    @Override
    public Result savePerson(Person person) throws NullPointerException{
        log.debug("savePerson [1]: saving record of person, person = {}", person);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            PreparedStatement preStat = getSqlSavePerson(person, conn);
        ){
            
            preStat.executeUpdate();
            log.debug("savePerson [2]: saved successful");
        
        } catch(SQLException ex){
            log.error("savePerson [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#saveResume(Resume)}. */ 
    @Override
    public Result saveResume(Resume resume) {
      log.debug("saveResume [1]: saving resume, resume = {}", resume);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
                Connection conn = getConnection();
                PreparedStatement preStat = conn.prepareStatement(Constants.H2_QUERY_INSERT_RESUME);
        ){
            
            preStat.setInt(1, Integer.parseInt(resume.getClientId()));
            preStat.setString(2, resume.getProfession());
            preStat.setString(3, resume.getCity());
            preStat.setString(4, resume.getSkills());
            preStat.setString(5, resume.getEducation());
            preStat.setString(6, resume.getExperience());
            preStat.setBoolean(7, resume.getSex());
            preStat.setBoolean(8, resume.getWorkPermit());
            preStat.setString(9, resume.getCitizenship());
            
            preStat.executeUpdate();
            log.debug("saveResume [2]: saved successful");
        } catch(SQLException ex){
            log.error("saveResume [2]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#saveCompany(Company)}. */ 
    @Override
    public Result saveCompany(Company company) {
        log.debug("saveCompany [1]: saving company, company = {}", company);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
                Connection conn = getConnection();
                PreparedStatement preStat = conn.prepareStatement(Constants.H2_QUERY_INSERT_COMPANY);
        ){
            
            preStat.setString(1, company.getTitle());
            preStat.setString(2, company.getDescription());
            
            preStat.executeUpdate();
            log.debug("saveCompany [2]: saved successfull");
            
        } catch(SQLException ex){
            log.error("saveCompany [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#saveVacancy(Vacancy)}. */ 
    @Override
    public Result saveVacancy(Vacancy vacancy) {
        log.debug("saveVacancy [1]: saving vacancy, vacancy = {}", vacancy);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
                Connection conn = getConnection();
                PreparedStatement preStat = conn.prepareStatement(Constants.H2_QUERY_INSERT_VACANCY);
        ){
            
            preStat.setInt(1, vacancy.getCompanyId());
            preStat.setString(2, vacancy.getTitle());
            preStat.setString(3, vacancy.getSpecialization());
            preStat.setBoolean(4, vacancy.getOnline());
            preStat.setString(5, vacancy.getSkills());
            preStat.setInt(6, vacancy.getSalary());
            preStat.setString(7, vacancy.getCity());
            preStat.setString(8, vacancy.getAddress());
            preStat.setString(9, vacancy.getExperience());
            
            preStat.executeUpdate();
            log.debug("saveVacancy [2]: saved successfull");
            
        } catch(SQLException ex){
            log.error("saveVacancy [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#saveSeparateQual(SeparateQual)}. */ 
    @Override
    public Result saveSeparateQual(SeparateQual separateQual) {
        log.debug("saveSeparateQual [1]: saving separateQual, separateQual = {}", separateQual);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
                Connection conn = getConnection();
                PreparedStatement preStat = conn.prepareStatement(Constants.H2_QUERY_INSERT_VACANCY);
        ){
            
            preStat.setInt(1, separateQual.getCompanyId());
            preStat.setInt(2, separateQual.getEmployeeId());
            preStat.setInt(3, separateQual.getQuality());
            preStat.setString(4, separateQual.getDescription());
            
            preStat.executeUpdate();
            log.debug("saveSeparateQual [2]: saved successfull");
            
        } catch(SQLException ex){
            log.error("saveSeparateQual [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    @Override
    public Client getClient(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Resume getResume(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Company getCompany(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vacancy getVacancy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employee getEmployee(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SeparateQual getSeparateQual(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Client> getAllClients() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Resume> getAllResumes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Company> getAllCompanies() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Employee> getAllEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SeparateQual> getAllSeparateQuals() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result updatePerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result updateResume(Resume resume) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result updateCompany(Company company) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result updateVacancy(Vacancy vacancy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result updateSeparateQual(SeparateQual separateQual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result deletePerson(String id, TypePerson typePerson) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result deleteResume(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result deleteCompany(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result deleteVacancy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result deleteSeparateQual(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
