/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.api;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

import ru.sfedu.model.*;
import static ru.sfedu.model.TypePerson.ClientType;
import static ru.sfedu.model.TypePerson.EmployeeType;
import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;
import ru.sfedu.util.TableName;
import ru.sfedu.util.h2Util;

/**
 *
 * @author mike
 */
public class DataProviderH2 implements IDataProvider{
    
    private static final Logger log = LogManager.getLogger(DataProviderH2.class.getName());

    private final String pathFolder;
    
    public DataProviderH2(){
        pathFolder = getConfigurationEntry(Constants.H2_PATH);
        createTables();
    }
    
    public DataProviderH2(String path){
        pathFolder = path.concat(getConfigurationEntry(Constants.H2_PATH));
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
            
            stat.execute(Constants.H2_QUERY_CREATE_CLIENT);
            log.debug("createTables[2]: created client table");
            
            stat.execute(Constants.H2_QUERY_CREATE_COMPANY);
            log.debug("createTables[3]: created company table");
            
            stat.execute(Constants.H2_QUERY_CREATE_EMPLOYEE);
            log.debug("createTables[4]: created employee table");
            
            stat.execute(Constants.H2_QUERY_CREATE_RESUME);
            log.debug("createTables[5]: created resume table");
            
            stat.execute(Constants.H2_QUERY_CREATE_VACANCY);
            log.debug("createTables[6]: created vacancy table");
            
            stat.execute(Constants.H2_QUERY_CREATE_SEPARATE_QUAL);
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
                        .concat(pathFolder)
                        .concat(Constants.H2_DB_NAME));
    }
    
    /** See also {@link IDataProvider#savePerson(Person)} */ 
    @Override
    public Result savePerson(Person person) throws NullPointerException{
        log.debug("savePerson [1]: saving record of person, person = {}", person);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        Function<TypePerson, String> getSqlPerson = (TypePerson type) -> {
            return switch(type){
                case ClientType -> Constants.H2_QUERY_INSERT_CLIENT;
                case EmployeeType -> Constants.H2_QUERY_INSERT_EMPLOYEE;
                default -> null;
            };
        };
        
        try(
            Connection conn = getConnection();
            PreparedStatement preStat = conn.prepareStatement(getSqlPerson.apply(person.getTypePerson()));
        ){
            
            h2Util.fillStatPerson(preStat, person);
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
            
            h2Util.fillStatResume(preStat, resume);
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
            
            h2Util.fillStatCompany(preStat, company);
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
            
            h2Util.fillStatVacancy(preStat, vacancy);
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
                PreparedStatement preStat = conn.prepareStatement(Constants.H2_QUERY_INSERT_SEPARATE_QUAL);
        ){
            
            h2Util.fillStatSeparateQual(preStat, separateQual);
            preStat.executeUpdate();
            
            log.debug("saveSeparateQual [2]: saved successfull");
            
        } catch(SQLException ex){
            log.error("saveSeparateQual [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#getClient(int)}. */
    @Override
    public Client getClient(int id) throws NullPointerException{
        log.debug("getClient [1]: gettind client by id, id = {}", id);
        try(
                Connection conn = getConnection();
                Statement stat = conn.createStatement();
        ){
            String sql = String.format(Constants.H2_QUERY_GET_RECORD_BY_ID, Constants.TITLE_TABLE_CLIENT, id);
            ResultSet res = stat.executeQuery(sql);
            if(res.next()){
                return h2Util.createClient(res);
            }
        } catch(SQLException ex){
            log.error("getClient [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("such record does not exist, id = " + id);
    }

    /** See also {@link IDataProvider#getResume(int)}. */
    @Override
    public Resume getResume(int id) {
        log.debug("getResume [1]: gettind resume by id, id = {}", id);
        try(
                Connection conn = getConnection();
                Statement stat = conn.createStatement();
        ){
            String sql = String.format(Constants.H2_QUERY_GET_RECORD_BY_ID, Constants.TITLE_TABLE_RESUME, id);
            ResultSet res = stat.executeQuery(sql);
            if(res.next()){
                Resume resume = h2Util.createResume(res);
                resume.setClient(getClient(res.getInt(2)));
                
                return resume;
            }
        } catch(SQLException ex){
            log.error("getResume [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("such record does not exist, id = " + id);
    }

    /** See also {@link IDataProvider#getCompany(int)}. */
    @Override
    public Company getCompany(int id) {
        log.debug("getCompany [1]: gettind company by id, id = {}", id);
        try(
                Connection conn = getConnection();
                Statement stat = conn.createStatement();
        ){
            String sql = String.format(Constants.H2_QUERY_GET_RECORD_BY_ID, Constants.TITLE_TABLE_COMPANY, id);
            ResultSet res = stat.executeQuery(sql);
            if(res.next()){
                return h2Util.createCompany(res);
            }
        } catch(SQLException ex){
            log.error("getCompany [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("such record does not exist, id = " + id);
    }

    /** See also {@link IDataProvider#getVacancy(int)}. */
    @Override
    public Vacancy getVacancy(int id) {
        log.debug("getVacancy [1]: gettind vacancy by id, id = {}", id);
        try(
                Connection conn = getConnection();
                Statement stat = conn.createStatement();
        ){
            String sql = String.format(Constants.H2_QUERY_GET_RECORD_BY_ID, Constants.TITLE_TABLE_VACANCY, id);
            ResultSet res = stat.executeQuery(sql);
            if(res.next()){
                Vacancy vacancy = h2Util.createVacancy(res);
                vacancy.setCompany(getCompany(res.getInt(2)));
                
                return vacancy;
            }
        } catch(SQLException ex){
            log.error("getVacancy [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("such record does not exist, id = " + id);
    }

    /** See also {@link IDataProvider#getEmployee(int)}. */
    @Override
    public Employee getEmployee(int id) {
        log.debug("getEmployee [1]: gettind employee by id, id = {}", id);
        try(
                Connection conn = getConnection();
                Statement stat = conn.createStatement();
        ){
            String sql = String.format(Constants.H2_QUERY_GET_RECORD_BY_ID, Constants.TITLE_TABLE_EMPLOYEE, id);
            ResultSet res = stat.executeQuery(sql);
            if(res.next()){
                Employee employee = h2Util.createEmployee(res);
                employee.setCompany(getCompany(res.getInt(9)));
                
                return employee;
            }
        } catch(SQLException ex){
            log.error("getEmployee [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("such record does not exist, id = " + id);
    }

    /** See also {@link IDataProvider#getSeparateQual(int)}. */
    @Override
    public SeparateQual getSeparateQual(int id) {
        log.debug("getSeparateQual [1]: gettind separateQual by id, id = {}", id);
        try(
                Connection conn = getConnection();
                Statement stat = conn.createStatement();
        ){
            String sql = String.format(Constants.H2_QUERY_GET_RECORD_BY_ID, Constants.TITLE_TABLE_SEPARATE_QUAL, id);
            ResultSet res = stat.executeQuery(sql);
            if(res.next()){
                SeparateQual separateQual = h2Util.createSeparateQual(res);
                separateQual.setCompany(getCompany(res.getInt(2)));
                
                return separateQual;
            }
        } catch(SQLException ex){
            log.error("getSeparateQual [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("such record does not exist, id = " + id);
    }

    /** See also {@link IDataProvider#getAllClients()}. */
    @Override
    public List<Client> getAllClients() {
        log.debug("getAllClients [1]: getting all record client");
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
        ){
            
            String sql = String.format(Constants.H2_QUERY_GET_ALL_RECORD, Constants.TITLE_TABLE_CLIENT);
            ResultSet res = stat.executeQuery(sql);
  
            List<Client> clients = new ArrayList<Client>();
            
            while(res.next()){
                clients.add(h2Util.createClient(res));
            }
            
            return clients;
            
        } catch(SQLException ex){
            log.error("getAllClients [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException(Constants.MESSAGE_EXCEPTION_DONT_RECORDS);
    }

    /** See also {@link IDataProvider#getAllResumes()}. */
    @Override
    public List<Resume> getAllResumes() {
        log.debug("getAllResumes [1]: getting all record resume");
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
        ){
            
            String sql = String.format(Constants.H2_QUERY_GET_ALL_RECORD, Constants.TITLE_TABLE_RESUME);
            ResultSet res = stat.executeQuery(sql);
            
            List<Resume> resumes = new ArrayList<Resume>();
            while(res.next()){
                Resume resume = h2Util.createResume(res);
                resume.setClient(getClient(res.getInt(2)));
                resumes.add(resume);
            }
            
            return resumes;
            
        } catch(SQLException ex){
            log.error("getAllResumes [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException(Constants.MESSAGE_EXCEPTION_DONT_RECORDS);
    }

    /** See also {@link IDataProvider#getAllCompanies()}. */
    @Override
    public List<Company> getAllCompanies() {
        log.debug("getAllCompanies [1]: getting all record сompany");
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
        ){
            
            String sql = String.format(Constants.H2_QUERY_GET_ALL_RECORD, Constants.TITLE_TABLE_COMPANY);
            ResultSet res = stat.executeQuery(sql);
            
            List<Company> сompanies = new ArrayList<Company>();
            while(res.next()){
                сompanies.add(h2Util.createCompany(res));
            }
            
            return сompanies;
            
        } catch(SQLException ex){
            log.error("getAllCompanies [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException(Constants.MESSAGE_EXCEPTION_DONT_RECORDS);
    }

    /** See also {@link IDataProvider#getAllVacancies()}. */
    @Override
    public List<Vacancy> getAllVacancies() {
        log.debug("getAllVacancies [1]: getting all record vacancy");
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
        ){
            
            String sql = String.format(Constants.H2_QUERY_GET_ALL_RECORD, Constants.TITLE_TABLE_VACANCY);
            ResultSet res = stat.executeQuery(sql);
            
            List<Vacancy> vacancies = new ArrayList<Vacancy>();
            while(res.next()){
                Vacancy vacancy = h2Util.createVacancy(res);
                vacancy.setCompany(getCompany(res.getInt(2)));
                vacancies.add(vacancy);
            }
            
            return vacancies;
            
        } catch(SQLException ex){
            log.error("getAllVacancies [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException(Constants.MESSAGE_EXCEPTION_DONT_RECORDS);
    }

    /** See also {@link IDataProvider#getAllEmployees()}. */
    @Override
    public List<Employee> getAllEmployees() {
        log.debug("getAllEmployees [1]: getting all record employee");
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
        ){
            
            String sql = String.format(Constants.H2_QUERY_GET_ALL_RECORD, Constants.TITLE_TABLE_EMPLOYEE);
            ResultSet res = stat.executeQuery(sql);
            
            List<Employee> employees = new ArrayList<Employee>();
            while(res.next()){
                Employee employee = h2Util.createEmployee(res);
                employee.setCompany(getCompany(res.getInt(9)));
                employees.add(employee);
            }
            
            return employees;
            
        } catch(SQLException ex){
            log.error("getAllEmployees [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException(Constants.MESSAGE_EXCEPTION_DONT_RECORDS);
    }

    /** See also {@link IDataProvider#getAllSeparateQuals()}. */
    @Override
    public List<SeparateQual> getAllSeparateQuals() {
        log.debug("getAllSeparateQuals [1]: getting all record separateQual");
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
        ){
            
            String sql = String.format(Constants.H2_QUERY_GET_ALL_RECORD, Constants.TITLE_TABLE_SEPARATE_QUAL);
            ResultSet res = stat.executeQuery(sql);
            
            List<SeparateQual> separateQuals = new ArrayList<SeparateQual>();
            while(res.next()){
                SeparateQual separateQual = h2Util.createSeparateQual(res);
                separateQual.setCompany(getCompany(res.getInt(2)));
                separateQuals.add(separateQual);
            }
            
            return separateQuals;
            
        } catch(SQLException ex){
            log.error("getAllSeparateQuals [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException(Constants.MESSAGE_EXCEPTION_DONT_RECORDS);
    }

    /** See also {@link IDataProvider#updatePerson(Person)}. */
    @Override
    public Result updatePerson(Person person) {
        log.debug("updatePerson [1]: updating person, person id = ", person.getId());
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        Function<TypePerson, String> getSqlPerson = (TypePerson type) -> {
            return switch(type){
                case ClientType -> Constants.H2_QUERY_UPDATE_CLIENT;
                case EmployeeType -> Constants.H2_QUERY_UPDATE_EMPLOYEE;
                default -> null;
            };
        };
        
        try(
            Connection conn = getConnection();
            PreparedStatement preStat = conn.prepareStatement(String.format(getSqlPerson.apply(person.getTypePerson()), person.getId()));
                ){
            
            h2Util.fillStatPerson(preStat, person);
                    
            if(preStat.executeUpdate() == 1){
                MongoProvider.save(CommandType.UPDATED, RepositoryType.H2, person);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_UPDATE);
                
                log.warn("{} person = {}", Constants.MESSAGE_CODE_WARN_UPDATE, person);
            }
            
        } catch(SQLException ex){
            log.error("updatePerson [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#updateResume(Resume)}. */
    @Override
    public Result updateResume(Resume resume) {
        log.debug("updateResume [1]: updating resume, resume id = ", resume.getId());
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            PreparedStatement preStat = conn.prepareStatement(String.format(Constants.H2_QUERY_UPDATE_RESUME, resume.getId()));
                ){
            
            h2Util.fillStatResume(preStat, resume);
                    
            if(preStat.executeUpdate() == 1){
                MongoProvider.save(CommandType.UPDATED, RepositoryType.H2, resume);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_UPDATE);
                
                log.warn("{} resume = {}", Constants.MESSAGE_CODE_WARN_UPDATE, resume);
            }
            
        } catch(SQLException ex){
            log.error("updateResume [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#updateCompany(Company)}. */
    @Override
    public Result updateCompany(Company company) {
        log.debug("updateCompany [1]: updating company, company id = ", company.getId());
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            PreparedStatement preStat = conn.prepareStatement(String.format(Constants.H2_QUERY_UPDATE_COMPANY, company.getId()));
                ){
            
            h2Util.fillStatCompany(preStat, company);
                    
            if(preStat.executeUpdate() == 1){
                MongoProvider.save(CommandType.UPDATED, RepositoryType.H2, company);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_UPDATE);
                
                log.warn("{} company = {}", Constants.MESSAGE_CODE_WARN_UPDATE, company);
            }
            
        } catch(SQLException ex){
            log.error("updateCompany [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#updateVacancy(Vacancy)}. */
    @Override
    public Result updateVacancy(Vacancy vacancy) {
        log.debug("updateVacancy [1]: updating vacancy, vacancy id = ", vacancy.getId());
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            PreparedStatement preStat = conn.prepareStatement(String.format(Constants.H2_QUERY_UPDATE_VACANCY, vacancy.getId()));
                ){
            
            h2Util.fillStatVacancy(preStat, vacancy);
                    
            if(preStat.executeUpdate() == 1){
                MongoProvider.save(CommandType.UPDATED, RepositoryType.H2, vacancy);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_UPDATE);
                
                log.warn("{} vacancy = {}", Constants.MESSAGE_CODE_WARN_UPDATE, vacancy);
            }
            
        } catch(SQLException ex){
            log.error("updateVacancy [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#updateSeparateQual(SeparateQual)}. */
    @Override
    public Result updateSeparateQual(SeparateQual separateQual) {
        log.debug("updateSeparateQual [1]: updating separateQual, separateQual id = ", separateQual.getId());
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            PreparedStatement preStat = conn.prepareStatement(String.format(Constants.H2_QUERY_UPDATE_SEPARATE_QUAL, separateQual.getId()));
                ){
            
            h2Util.fillStatSeparateQual(preStat, separateQual);
                    
            if(preStat.executeUpdate() == 1){
                MongoProvider.save(CommandType.UPDATED, RepositoryType.H2, separateQual);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_UPDATE);
                
                log.warn("{} separateQual = {}", Constants.MESSAGE_CODE_WARN_UPDATE, separateQual);
            }
            
        } catch(SQLException ex){
            log.error("updateSeparateQual [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deletePerson(int, TypePerson)}. */
    @Override
    public Result deletePerson(int id, TypePerson typePerson) {
        log.debug("deletePerson [1]: id = {}, typePerson = {}", id, typePerson);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
                ){
            
            String sql = String.format(Constants.H2_QUERY_DELETE_RECORD_BY_ID, TableName.getTableNamePerson(typePerson), id);
            
            if(stat.executeUpdate(sql) == 1){
                Person person = new Person();
                person.setTypePerson(typePerson);
                person.setId(id);
                
                MongoProvider.save(CommandType.DELETED, RepositoryType.H2, person);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_DELETE);
                
                log.warn("{}", Constants.MESSAGE_CODE_WARN_DELETE);
            }
            
        } catch(SQLException ex){
            log.error("deletePerson [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deleteResume(int)}. */
    @Override
    public Result deleteResume(int id) {
        log.debug("deleteResume [1]: id = {}", id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
                ){
            
            String sql = String.format(Constants.H2_QUERY_DELETE_RECORD_BY_ID, Constants.TITLE_TABLE_RESUME, id);
            
            if(stat.executeUpdate(sql) == 1){
                Resume resume = new Resume();
                resume.setId(id);
                
                MongoProvider.save(CommandType.DELETED, RepositoryType.H2, resume);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_DELETE);
                
                log.warn("{}", Constants.MESSAGE_CODE_WARN_DELETE);
            }
            
        } catch(SQLException ex){
            log.error("deleteResume [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deleteCompany(int)}. */
    @Override
    public Result deleteCompany(int id) {
        log.debug("deleteCompany [1]: id = {}", id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
                ){
            
            String sql = String.format(Constants.H2_QUERY_DELETE_RECORD_BY_ID, Constants.TITLE_TABLE_COMPANY, id);
            
            if(stat.executeUpdate(sql) == 1){
                Company company = new Company();
                company.setId(id);
                
                MongoProvider.save(CommandType.DELETED, RepositoryType.H2, company);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_DELETE);
                
                log.warn("{}", Constants.MESSAGE_CODE_WARN_DELETE);
            }
            
        } catch(SQLException ex){
            log.error("deleteCompany [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deleteVacancy(int)}. */
    @Override
    public Result deleteVacancy(int id) {
        log.debug("deleteVacancy [1]: id = {}", id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
                ){
            
            String sql = String.format(Constants.H2_QUERY_DELETE_RECORD_BY_ID, Constants.TITLE_TABLE_VACANCY, id);
            
            if(stat.executeUpdate(sql) == 1){
                Vacancy vacancy = new Vacancy();
                vacancy.setId(id);
                
                MongoProvider.save(CommandType.DELETED, RepositoryType.H2, vacancy);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_DELETE);
                
                log.warn("{}", Constants.MESSAGE_CODE_WARN_DELETE);
            }
            
        } catch(SQLException ex){
            log.error("deleteVacancy [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deleteSeparateQual(int)}. */
    @Override
    public Result deleteSeparateQual(int id) {
        log.debug("deleteSeparateQual [1]: id = {}", id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        try(
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
                ){
            
            String sql = String.format(Constants.H2_QUERY_DELETE_RECORD_BY_ID, Constants.TITLE_TABLE_SEPARATE_QUAL, id);
            
            if(stat.executeUpdate(sql) == 1){
                SeparateQual separateQual = new SeparateQual();
                separateQual.setId(id);
                
                MongoProvider.save(CommandType.DELETED, RepositoryType.H2, separateQual);
            }
            else{
                result.setCode(Constants.CODE_WARN);
                result.setMessage(Constants.MESSAGE_CODE_WARN_DELETE);
                
                log.warn("{}", Constants.MESSAGE_CODE_WARN_DELETE);
            }
            
        } catch(SQLException ex){
            log.error("deleteSeparateQual [2]: error = {}", ex.getMessage());
            
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#giveAssessment(int)}. */
    @Override
    public Result giveAssessment(int idEmployee, int idCompany, int quality, String description){
        log.debug("giveAssessment [1]: Даем оценку компании, id employee = {}, id company = {}, quality = {}", idEmployee, idCompany, quality);
        Result result = new Result();

        if(checkQuality(quality) && checkDealTogether(idEmployee, idCompany)){
            
            SeparateQual separateQual = new SeparateQual();
                
            log.debug("giveAssessment [1]: установка объекту оценки поле company");
            separateQual.setCompany(getCompany(idCompany));
            
            separateQual.setDescription(description);
            separateQual.setQuality(quality);
                
            result = saveSeparateQual(separateQual);
            log.debug("giveAssessment [2]: результат сохранения, result = {}", result.getMessage());
        }
        else{
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
        
        return result;
    }

    /** See also {@link IDataProvider#checkDealTogether(int, int)}. */
    @Override
    public boolean checkDealTogether(int idEmployee, int idCompany) {
        log.debug("checkDealTogether [1]: checking deal");
        try{
            getCompany(idCompany);
        } catch(NullPointerException ex){
            log.debug("checkDealTogether [2]: такой компании нет, id company = {}", idCompany);
            return false;
        }
        
        try{
            Employee employee = getEmployee(idEmployee);
            return employee.getCompany().getId() == idCompany;
        } catch(NullPointerException ex){
            log.debug("checkDealTogether [2]: такого сотрудника нет, id employee = {}", idEmployee);
        }
        
        return false;
    }

    /** See also {@link IDataProvider#calculateAssessment(int, boolean)}. */
    @Override
    public Result calculateAssessment(int idCompany, boolean others) {
        log.debug("calculateAssessment [1]: calculate assessment, idCompany = {}", idCompany);
        
        Result result = new Result();
        
        try{
            Company company = getCompany(idCompany);
            
            log.debug("calculateAssessment [2]: get all quals");
            List<SeparateQual> separateQuals = getAllSeparateQuals();
            separateQuals = separateQuals.stream()
                    .filter((separateQual) -> separateQual.getCompany().getId() == idCompany)
                    .toList();
            
            ResultAnalisys resultAnalisys = getResultAnalisys(company, separateQuals);
            
            log.debug("calculateAssessment [3]: check extend");
            if(others){
                calculateAssessmentWithOthers(resultAnalisys);
            }
            
            log.debug("calculateAssessment [4]: generate result file");
            generateResultFile(resultAnalisys);
            
            result.setCode(Constants.CODE_SUCCESS);
            result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
            
        } catch(NullPointerException ex){
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
            log.error("calculateAssessment [5]: error = {}", ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#calculateAssessmentWithOthers(ResultAnalisys)}. */
    @Override
    public Result calculateAssessmentWithOthers(ResultAnalisys resultAnalisys) {
        log.debug("calculateAssessmentWithOthers[1]: resultAnalisys = {}", resultAnalisys.getResult());
        Result result = new Result();
        
        try{
            
            List<Company> companies = getAllCompanies();
            List<SeparateQual> separateQuals = getAllSeparateQuals();
            int place = Constants.DEFAULT_PLACE_COMPANY;
            for(Company cmp : companies){
            
                log.debug("calculateAssessmentWithOthers[2]: расчет среднего, company = {}", cmp);
                ResultAnalisys tempResultAnalisys = getResultAnalisys(
                        cmp, 
                        separateQuals.stream()
                        .filter((separateQual) -> separateQual.getCompany().getId() == cmp.getId())
                        .toList());
            
                if(resultAnalisys.getResult() > tempResultAnalisys.getResult()){
                    place++;
                }
            }
            
            resultAnalisys.setPlace(place);
            result.setCode(Constants.CODE_SUCCESS);
            result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        } catch(Exception ex){
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
            log.error("calculateAssessmentWithOthers[3]: error = {}", ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#hireEmployee(int, int, boolean)}. */
    @Override
    public Result hireEmployee(int idResume, int idVacancy, boolean test){
        log.debug("hireEmployee [1]: hiring employee, id resume = {}, id vacancy = {}", idResume, idVacancy);
        Result result = new Result();
        try{
            Resume resume = getResume(idResume);
            Vacancy vacancy = getVacancy(idVacancy);
            Client client = getClient(resume.getClient().getId());
            
            Employee employee = new Employee();
            
            employee.setTypePerson(TypePerson.EmployeeType);
            
            employee.setName(client.getName());
            employee.setSurname(client.getSurname());
            employee.setMiddleName(client.getMiddleName());
            employee.setAge(client.getAge());
            employee.setBirthday(client.getBirthday());
            employee.setPhone(client.getPhone());
            employee.setEmail(client.getEmail());
            employee.setCompany(vacancy.getCompany());
            employee.setSalary(vacancy.getSalary());
            employee.setPosition(vacancy.getTitle());
            employee.setIsWorking(true);
            
            savePerson(employee);
            
            log.debug("hireEmployee [2]: send hire message");
            sendHireMessage(employee.getEmail(), vacancy);
            
            if(test){
                log.debug("hireEmployee [3]: send test message");
                sendTestMessage(employee.getEmail(), vacancy);
            }
            
            log.debug("hireEmployee [4]: Человек успешно нанят");
            result.setCode(Constants.CODE_SUCCESS);
            result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        } catch(NullPointerException ex){
            log.error("hireEmployee [5]: {}", Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(Constants.MESSAGE_EXCEPTION_DOESNT_VALID_DATA);
        }
        
        return result;
    }
    
    /**
     * Method filles ResultAnalisys
     * @param company - company
     * @param separateQuals  - list of company sepatareQuals
     * @return ResultAnalisys
     **/
    private ResultAnalisys getResultAnalisys(Company company, List<SeparateQual> separateQuals){
        log.debug("getResultAnalisys[1]: company = {}", company);
        
        int count = separateQuals.size();
        double sum = separateQuals.stream()
                .mapToInt((separateQual) -> (separateQual.getQuality()))
                .sum();
            
        double avg = sum / count;
        ResultAnalisys resultAnalisys = new ResultAnalisys(avg, company);
            
        return resultAnalisys;
    }
    
    
}
