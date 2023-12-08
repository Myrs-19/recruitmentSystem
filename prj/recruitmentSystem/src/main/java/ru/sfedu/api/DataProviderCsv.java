package ru.sfedu.api;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
import java.util.function.Function;

import ru.sfedu.Constants;
import ru.sfedu.exception.IncorrectDataStorageException;

import ru.sfedu.model.*;
import ru.sfedu.model.TypePerson;
import static ru.sfedu.model.TypePerson.EmployeeType;
import static ru.sfedu.model.TypePerson.UserType;

import ru.sfedu.util.FileUtil;
import ru.sfedu.util.BeanUtil;
import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;

public class DataProviderCsv implements IDataProvider{
    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());
    
    public DataProviderCsv(){
        log.debug("DataProviderCsv [1]: initialization");
        
        try{
            FileUtil.createFolderIfNotExists(getConfigurationEntry(Constants.CSV_PATH_FOLDER));
        } catch(IOException ex){
            log.error("DataProviderCsv [2]: error = {}", ex.getMessage());
        }
    }
    
    private String getId(String pathToCsv){
        log.debug("getId [1]: gettind id, pathToCsv = {}", pathToCsv);
        
        final String[] idWrapper = {Constants.CSV_FIRST_ID};
        String id = idWrapper[0];
        
        try(FileReader fileReader = new FileReader(pathToCsv)){
            CSVReader csvReader = new CSVReader(fileReader);
            
            csvReader.readAll().stream()
                    .forEach(
                    (it) -> {
                        if(Integer.parseInt(it[0]) >= Integer.parseInt(idWrapper[0])){
                            idWrapper[0] = it[0];
                        }
                    }
                    );
            
            id = String.valueOf(Integer.parseInt(idWrapper[0])+1);
            
            log.debug("getId [2]: gettind has been successful");
            return id;
        } catch(NullPointerException | IOException | CsvException ex){
            log.error("getId [3]: error = {}", ex.getMessage());
        } 
        
        return id;
    }
    
    private String getPath(String tableName){
        return getConfigurationEntry(Constants.CSV_PATH_FOLDER) + tableName + Constants.CSV_FILE_TYPE;
    }

    private String getPathPerson(TypePerson type){
        Function<TypePerson, String> func = (TypePerson t) -> {
            return switch (t) {
                case UserType -> Constants.CSV_TITLE_TABLE_USER;
                case EmployeeType -> Constants.CSV_TITLE_TABLE_EMPLOYEE;
                default -> null;
            };
        };
        
        String tableName = func.apply(type);
        String pathToCsv = getPath(tableName);
        
        return pathToCsv;
    }
    
    
    @Override
    public Result savePerson(Person person) {
        Result result = new Result();
        
        String pathToCsv = getPathPerson(person.getTypePerson());
        
        log.debug("savePerson [1]: obj = {}", person);
        
        String id = getId(pathToCsv);
        person.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder<Person>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(person);
            
            log.debug("savePerson [2]: object saved succesfully");
            result.setCode(200);
            result.setMessage("OK");
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("savePerson [3]: error = {}",  ex.getMessage());
            result.setCode(422);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public Result saveResume(Resume resume) {
        Result result = new Result();
        
        String pathToCsv = getPath(Constants.CSV_TITLE_TABLE_RESUME);
        
        log.debug("saveResume [1]: obj = {}", resume);
        
        String id = getId(pathToCsv);
        resume.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<Resume> beanToCsv = new StatefulBeanToCsvBuilder<Resume>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(resume);
            
            log.debug("saveResume [2]: object saved succesfully");
            result.setCode(200);
            result.setMessage("OK");
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveResume [3]: error = {}",  ex.getMessage());
            result.setCode(422);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public Result saveCompany(Company company) {
        Result result = new Result();
        
        String pathToCsv = getPath(Constants.CSV_TITLE_TABLE_COMPANY);
        
        log.debug("saveCompany [1]: obj = {}", company);
        
        String id = getId(pathToCsv);
        company.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<Company> beanToCsv = new StatefulBeanToCsvBuilder<Company>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(company);
            
            log.debug("saveCompany [2]: object saved succesfully");
            result.setCode(200);
            result.setMessage("OK");
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveCompany [3]: error = {}",  ex.getMessage());
            result.setCode(422);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public Result saveVacancy(Vacancy vacancy) {
        Result result = new Result();
        
        String pathToCsv = getPath(Constants.CSV_TITLE_TABLE_VACANCY);
        
        log.debug("saveVacancy [1]: obj = {}", vacancy);
        
        String id = getId(pathToCsv);
        vacancy.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<Vacancy> beanToCsv = new StatefulBeanToCsvBuilder<Vacancy>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(vacancy);
            
            log.debug("saveVacancy [2]: object saved succesfully");
            result.setCode(200);
            result.setMessage("OK");
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveVacancy [3]: error = {}",  ex.getMessage());
            result.setCode(422);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public Result saveSeparateQual(SeparateQual separateQual) {
        Result result = new Result();
        
        String pathToCsv = getPath(Constants.CSV_TITLE_TABLE_SEPARATE_QUAL);
        
        log.debug("saveSeparateQual [1]: obj = {}", separateQual);
        
        String id = getId(pathToCsv);
        separateQual.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<SeparateQual> beanToCsv = new StatefulBeanToCsvBuilder<SeparateQual>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(separateQual);
            
            log.debug("saveSeparateQual [2]: object saved succesfully");
            result.setCode(200);
            result.setMessage("OK");
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveSeparateQual [3]: error = {}",  ex.getMessage());
            result.setCode(422);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public User getUser(String id) {
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
    public List<User> getAllUsers() {
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
    public Result deletePerson(String id) {
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
