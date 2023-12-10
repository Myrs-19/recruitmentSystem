package ru.sfedu.api;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

import ru.sfedu.Constants;

import ru.sfedu.model.*;
import ru.sfedu.model.TypePerson;
import static ru.sfedu.model.TypePerson.EmployeeType;
import static ru.sfedu.model.TypePerson.UserType;

import ru.sfedu.util.FileUtil;
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
                case UserType -> Constants.TITLE_TABLE_USER;
                case EmployeeType -> Constants.TITLE_TABLE_EMPLOYEE;
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
            result.setCode(Constants.CODE_SUCCESS);
            result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("savePerson [3]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public Result saveResume(Resume resume) {
        Result result = new Result();
        
        String pathToCsv = getPath(Constants.TITLE_TABLE_RESUME);
        
        log.debug("saveResume [1]: obj = {}", resume);
        
        String id = getId(pathToCsv);
        resume.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<Resume> beanToCsv = new StatefulBeanToCsvBuilder<Resume>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(resume);
            
            log.debug("saveResume [2]: object saved succesfully");
            result.setCode(Constants.CODE_SUCCESS);
            result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveResume [3]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public Result saveCompany(Company company) {
        Result result = new Result();
        
        String pathToCsv = getPath(Constants.TITLE_TABLE_COMPANY);
        
        log.debug("saveCompany [1]: obj = {}", company);
        
        String id = getId(pathToCsv);
        company.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<Company> beanToCsv = new StatefulBeanToCsvBuilder<Company>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(company);
            
            log.debug("saveCompany [2]: object saved succesfully");
            result.setCode(Constants.CODE_SUCCESS);
            result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveCompany [3]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public Result saveVacancy(Vacancy vacancy) {
        Result result = new Result();
        
        String pathToCsv = getPath(Constants.TITLE_TABLE_VACANCY);
        
        log.debug("saveVacancy [1]: obj = {}", vacancy);
        
        String id = getId(pathToCsv);
        vacancy.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<Vacancy> beanToCsv = new StatefulBeanToCsvBuilder<Vacancy>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(vacancy);
            
            log.debug("saveVacancy [2]: object saved succesfully");
            result.setCode(Constants.CODE_SUCCESS);
            result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveVacancy [3]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public Result saveSeparateQual(SeparateQual separateQual) {
        Result result = new Result();
        
        String pathToCsv = getPath(Constants.TITLE_TABLE_SEPARATE_QUAL);
        
        log.debug("saveSeparateQual [1]: obj = {}", separateQual);
        
        String id = getId(pathToCsv);
        separateQual.setId(id);
        
        try (FileWriter writer  = new FileWriter(pathToCsv, true)){
            StatefulBeanToCsv<SeparateQual> beanToCsv = new StatefulBeanToCsvBuilder<SeparateQual>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(separateQual);
            
            log.debug("saveSeparateQual [2]: object saved succesfully");
            result.setCode(Constants.CODE_SUCCESS);
            result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveSeparateQual [3]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
        
        return result;
    }

    @Override
    public User getUser(String id) {
        log.debug("getUser [1]: id = {}", id);
       
        try(FileReader fileReader = new FileReader(getPath(Constants.TITLE_TABLE_USER))){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<User> beanStrategy = new ColumnPositionMappingStrategy<User>();
            beanStrategy.setType(User.class);
           
            CsvToBean<User> csvToBean = new CsvToBean<User>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            Optional<User> userWrap = csvToBean.parse()
                    .stream()
                    .filter(user -> {
                        return user.getId().equals(id);
                    })
                    .findFirst();
            
            return userWrap.get();
                    
        } catch(IOException | NoSuchElementException ex){
            log.error("getUser [2]: error = {}", ex.getMessage());
        }
       
       throw new NullPointerException("such record does not exist: bean = User, id = " + id);
    }

    @Override
    public Resume getResume(String id) {
        log.debug("getResume [1]: id = {}", id);
       
        try(FileReader fileReader = new FileReader(getPath(Constants.TITLE_TABLE_RESUME))){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<Resume> beanStrategy = new ColumnPositionMappingStrategy<Resume>();
            beanStrategy.setType(Resume.class);
           
            CsvToBean<Resume> csvToBean = new CsvToBean<Resume>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            Optional<Resume> resumeWrap = csvToBean.parse()
                    .stream()
                    .filter(resume -> {
                        return resume.getId().equals(id);
                    })
                    .findFirst();
            
            return resumeWrap.get();
                    
        } catch(IOException | NoSuchElementException ex){
            log.error("getResume [2]: error = {}", ex.getMessage());
        }
       
       throw new NullPointerException("such record does not exist: bean = Resume, id = " + id);
    }

    @Override
    public Company getCompany(String id) {
        log.debug("getCompany [1]: id = {}", id);
       
        try(FileReader fileReader = new FileReader(getPath(Constants.TITLE_TABLE_COMPANY))){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<Company> beanStrategy = new ColumnPositionMappingStrategy<Company>();
            beanStrategy.setType(Company.class);
           
            CsvToBean<Company> csvToBean = new CsvToBean<Company>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            Optional<Company> resumeWrap = csvToBean.parse()
                    .stream()
                    .filter(company -> {
                        return company.getId().equals(id);
                    })
                    .findFirst();
            
            return resumeWrap.get();
                    
        } catch(IOException | NoSuchElementException ex){
            log.error("getCompany [2]: error = {}", ex.getMessage());
        }
       
       throw new NullPointerException("such record does not exist: bean = Company, id = " + id);
    }

    @Override
    public Vacancy getVacancy(String id) {
        log.debug("getVacancy [1]: id = {}", id);
       
        try(FileReader fileReader = new FileReader(getPath(Constants.TITLE_TABLE_VACANCY))){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<Vacancy> beanStrategy = new ColumnPositionMappingStrategy<Vacancy>();
            beanStrategy.setType(Vacancy.class);
           
            CsvToBean<Vacancy> csvToBean = new CsvToBean<Vacancy>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            Optional<Vacancy> resumeWrap = csvToBean.parse()
                    .stream()
                    .filter(vacancy -> {
                        return vacancy.getId().equals(id);
                    })
                    .findFirst();
            
            return resumeWrap.get();
                    
        } catch(IOException | NoSuchElementException ex){
            log.error("getVacancy [2]: error = {}", ex.getMessage());
        }
       
       throw new NullPointerException("such record does not exist: bean = Vacancy, id = " + id);
    }

    @Override
    public Employee getEmployee(String id) {
        log.debug("getEmployee [1]: id = {}", id);
       
        try(FileReader fileReader = new FileReader(getPath(Constants.TITLE_TABLE_EMPLOYEE))){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<Employee> beanStrategy = new ColumnPositionMappingStrategy<Employee>();
            beanStrategy.setType(Employee.class);
           
            CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            Optional<Employee> resumeWrap = csvToBean.parse()
                    .stream()
                    .filter(employee -> {
                        return employee.getId().equals(id);
                    })
                    .findFirst();
            
            return resumeWrap.get();
                    
        } catch(IOException | NoSuchElementException ex){
            log.error("getEmployee [2]: error = {}", ex.getMessage());
        }
       
       throw new NullPointerException("such record does not exist: bean = Employee, id = " + id);
    }

    @Override
    public SeparateQual getSeparateQual(String id) {
        log.debug("getSeparateQual [1]: id = {}", id);
       
        try(FileReader fileReader = new FileReader(getPath(Constants.TITLE_TABLE_SEPARATE_QUAL))){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<SeparateQual> beanStrategy = new ColumnPositionMappingStrategy<SeparateQual>();
            beanStrategy.setType(SeparateQual.class);
           
            CsvToBean<SeparateQual> csvToBean = new CsvToBean<SeparateQual>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            Optional<SeparateQual> resumeWrap = csvToBean.parse()
                    .stream()
                    .filter(separateQual -> {
                        return separateQual.getId().equals(id);
                    })
                    .findFirst();
            
            return resumeWrap.get();
                    
        } catch(IOException | NoSuchElementException ex){
            log.error("getSeparateQual [2]: error = {}", ex.getMessage());
        }
       
       throw new NullPointerException("such record does not exist: bean = SeparateQual, id = " + id);
    }

    @Override
    public List<User> getAllUsers() {
        String pathToCsv = getPath(Constants.TITLE_TABLE_USER);
        log.debug("getAllUsers [1]: getting all record from = {}", pathToCsv);
        
        try(FileReader fileReader = new FileReader(pathToCsv)){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<User> beanStrategy = new ColumnPositionMappingStrategy<User>();
            beanStrategy.setType(User.class);
            
            CsvToBean<User> csvToBean = new CsvToBean<User>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            return csvToBean.parse();
            
        } catch(NullPointerException | IOException ex){
            log.error("getAllUsers [2]: error = {}", ex.getMessage());
        }

        throw new NullPointerException("records such bean do not exists: bean = User");
    }

    @Override
    public List<Resume> getAllResumes() {
        String pathToCsv = getPath(Constants.TITLE_TABLE_RESUME);
        log.debug("getAllResumes [1]: getting all record from = {}", pathToCsv);
        
        try(FileReader fileReader = new FileReader(pathToCsv)){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<Resume> beanStrategy = new ColumnPositionMappingStrategy<Resume>();
            beanStrategy.setType(Resume.class);
            
            CsvToBean<Resume> csvToBean = new CsvToBean<Resume>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            return csvToBean.parse();
            
        } catch(NullPointerException | IOException ex){
            log.error("getAllResumes [2]: error = {}", ex.getMessage());
        }

        throw new NullPointerException("records such bean do not exists: bean = Resume");
    }

    @Override
    public List<Company> getAllCompanies() {
        String pathToCsv = getPath(Constants.TITLE_TABLE_COMPANY);
        log.debug("getAllCompanies [1]: getting all record from = {}", pathToCsv);
        
        try(FileReader fileReader = new FileReader(pathToCsv)){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<Company> beanStrategy = new ColumnPositionMappingStrategy<Company>();
            beanStrategy.setType(Company.class);
            
            CsvToBean<Company> csvToBean = new CsvToBean<Company>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            return csvToBean.parse();
            
        } catch(NullPointerException | IOException ex){
            log.error("getAllCompanies [2]: error = {}", ex.getMessage());
        }

        throw new NullPointerException("records such bean do not exists: bean = Company");
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        String pathToCsv = getPath(Constants.TITLE_TABLE_VACANCY);
        log.debug("getAllVacancies [1]: getting all record from = {}", pathToCsv);
        
        try(FileReader fileReader = new FileReader(pathToCsv)){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<Vacancy> beanStrategy = new ColumnPositionMappingStrategy<Vacancy>();
            beanStrategy.setType(Vacancy.class);
            
            CsvToBean<Vacancy> csvToBean = new CsvToBean<Vacancy>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            return csvToBean.parse();
            
        } catch(NullPointerException | IOException ex){
            log.error("getAllVacancies [2]: error = {}", ex.getMessage());
        }

        throw new NullPointerException("records such bean do not exists: bean = Vacancy");
    }

    @Override
    public List<Employee> getAllEmployees() {
        String pathToCsv = getPath(Constants.TITLE_TABLE_EMPLOYEE);
        log.debug("getAllEmployees [1]: getting all record from = {}", pathToCsv);
        
        try(FileReader fileReader = new FileReader(pathToCsv)){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<Employee> beanStrategy = new ColumnPositionMappingStrategy<Employee>();
            beanStrategy.setType(Employee.class);
            
            CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            return csvToBean.parse();
            
        } catch(NullPointerException | IOException ex){
            log.error("getAllEmployees [2]: error = {}", ex.getMessage());
        }

        throw new NullPointerException("records such bean do not exists: bean = Employee");
    }

    @Override
    public List<SeparateQual> getAllSeparateQuals() {
        String pathToCsv = getPath(Constants.TITLE_TABLE_SEPARATE_QUAL);
        log.debug("getAllSeparateQuals [1]: getting all record from = {}", pathToCsv);
        
        try(FileReader fileReader = new FileReader(pathToCsv)){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<SeparateQual> beanStrategy = new ColumnPositionMappingStrategy<SeparateQual>();
            beanStrategy.setType(SeparateQual.class);
            
            CsvToBean<SeparateQual> csvToBean = new CsvToBean<SeparateQual>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            return csvToBean.parse();
            
        } catch(NullPointerException | IOException ex){
            log.error("getAllSeparateQuals [2]: error = {}", ex.getMessage());
        }

        throw new NullPointerException("records such bean do not exists: bean = SeparateQual");
    }

    @Override
    public Result updatePerson(Person person) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String id = person.getId();
        
        log.debug("updatePerson [1]: obj = {}, id = {}", person, id);
        
        Function<TypePerson, List> getPersons = (TypePerson type) -> {
            return switch (type){
                case UserType -> getAllUsers();
                case EmployeeType -> getAllEmployees();
                default -> null;
            };
        };
        
        List<Person> persons = getPersons.apply(person.getTypePerson());
         
        String pathToCsv = getPathPerson(person.getTypePerson());
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder<Person>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            persons.stream()
                    .forEach((p) -> {
                        try{
                            if(p.getId().equals(person.getId())){
                                    beanToCsv.write(person);
                            }
                            else{
                                beanToCsv.write(p);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("updatePerson [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_SUCCESS){
            MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, person);
        }
        else if(result.getCode() == Constants.CODE_ERROR){
            log.error("updatePerson [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result updateResume(Resume resume) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        log.debug("updateResume [1]: obj = {}, id = {}", resume, resume.getId());
        
        List<Resume> resumes = getAllResumes();
         
        String pathToCsv = getPath(Constants.TITLE_TABLE_RESUME);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<Resume> beanToCsv = new StatefulBeanToCsvBuilder<Resume>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            resumes.stream()
                    .forEach((r) -> {
                        try{
                            if(r.getId().equals(resume.getId())){
                                    beanToCsv.write(resume);
                            }
                            else{
                                beanToCsv.write(r);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("updateResume [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_SUCCESS){
            MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, resume);
        }
        else if(result.getCode() == Constants.CODE_ERROR){
            log.error("updateResume [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result updateCompany(Company company) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        log.debug("updateCompany [1]: obj = {}, id = {}", company, company.getId());
        
        List<Company> companies = getAllCompanies();
         
        String pathToCsv = getPath(Constants.TITLE_TABLE_COMPANY);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<Company> beanToCsv = new StatefulBeanToCsvBuilder<Company>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            companies.stream()
                    .forEach((c) -> {
                        try{
                            if(c.getId().equals(company.getId())){
                                    beanToCsv.write(company);
                            }
                            else{
                                beanToCsv.write(c);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("updateCompany [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_SUCCESS){
            MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, company);
        }
        else if(result.getCode() == Constants.CODE_ERROR){
            log.error("updateCompany [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result updateVacancy(Vacancy vacancy) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        log.debug("updateVacancy [1]: obj = {}, id = {}", vacancy, vacancy.getId());
        
        List<Vacancy> vacancies = getAllVacancies();
        
        String pathToCsv = getPath(Constants.TITLE_TABLE_VACANCY);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<Vacancy> beanToCsv = new StatefulBeanToCsvBuilder<Vacancy>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            vacancies.stream()
                    .forEach((v) -> {
                        try{
                            if(v.getId().equals(vacancy.getId())){
                                    beanToCsv.write(vacancy);
                            }
                            else{
                                beanToCsv.write(v);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("updateVacancy [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_SUCCESS){
            MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, vacancy);
        }
        else if(result.getCode() == Constants.CODE_ERROR){
            log.error("updateVacancy [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result updateSeparateQual(SeparateQual separateQual) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        log.debug("updateSeparateQual [1]: obj = {}, id = {}", separateQual, separateQual.getId());
        
        List<SeparateQual> separateQuals = getAllSeparateQuals();
        
        String pathToCsv = getPath(Constants.TITLE_TABLE_SEPARATE_QUAL);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<SeparateQual> beanToCsv = new StatefulBeanToCsvBuilder<SeparateQual>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            separateQuals.stream()
                    .forEach((sp) -> {
                        try{
                            if(sp.getId().equals(separateQual.getId())){
                                    beanToCsv.write(separateQual);
                            }
                            else{
                                beanToCsv.write(sp);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("updateSeparateQual [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_SUCCESS){
            MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, separateQual);
        }
        else if(result.getCode() == Constants.CODE_ERROR){
            log.error("updateSeparateQual [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result deletePerson(String id, TypePerson typePerson) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        
        log.debug("deletePerson [1]: id = {}", id);
        
        Function<TypePerson, List> getPersons = (TypePerson type) -> {
            return switch (type){
                case UserType -> getAllUsers();
                case EmployeeType -> getAllEmployees();
                default -> null;
            };
        };
        
        List<Person> persons = getPersons.apply(typePerson);
         
        String pathToCsv = getPathPerson(typePerson);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder<Person>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            persons.stream()
                    .forEach((p) -> {
                        try{
                            if(!p.getId().equals(id)){
                                    beanToCsv.write(p);
                            }
                            else{
                                MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, p);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("deletePerson [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_ERROR){
            log.error("deletePerson [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result deleteResume(String id) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        log.debug("deleteResume [1]: id = {}", id);
        
        List<Resume> resumes = getAllResumes();
         
        String pathToCsv = getPath(Constants.TITLE_TABLE_RESUME);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<Resume> beanToCsv = new StatefulBeanToCsvBuilder<Resume>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            resumes.stream()
                    .forEach((r) -> {
                        try{
                            if(!r.getId().equals(id)){
                                    beanToCsv.write(r);
                            }
                            else{
                                MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, r);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("deleteResume [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_ERROR){
            log.error("deleteResume [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result deleteCompany(String id) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        log.debug("deleteCompany [1]: id = {}", id);
        
        List<Company> companies = getAllCompanies();
         
        String pathToCsv = getPath(Constants.TITLE_TABLE_COMPANY);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<Company> beanToCsv = new StatefulBeanToCsvBuilder<Company>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            companies.stream()
                    .forEach((c) -> {
                        try{
                            if(!c.getId().equals(id)){
                                    beanToCsv.write(c);
                            }
                            else{
                                MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, c);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("deleteCompany [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_ERROR){
            log.error("deleteCompany [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result deleteVacancy(String id) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        log.debug("deleteVacancy [1]: id = {}", id);
        
        List<Vacancy> vacancies = getAllVacancies();
         
        String pathToCsv = getPath(Constants.TITLE_TABLE_VACANCY);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<Vacancy> beanToCsv = new StatefulBeanToCsvBuilder<Vacancy>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            vacancies.stream()
                    .forEach((v) -> {
                        try{
                            if(!v.getId().equals(id)){
                                    beanToCsv.write(v);
                            }
                            else{
                                MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, v);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("deleteVacancy [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_ERROR){
            log.error("deleteVacancy [3]: error = {}", result.getMessage());
        }
        return result;
    }

    @Override
    public Result deleteSeparateQual(String id) {
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        log.debug("deleteSeparateQual [1]: id = {}", id);
        
        List<SeparateQual> separateQuals = getAllSeparateQuals();
         
        String pathToCsv = getPath(Constants.TITLE_TABLE_SEPARATE_QUAL);
        
        try(FileWriter writer = new FileWriter(pathToCsv, false)){
            StatefulBeanToCsv<SeparateQual> beanToCsv = new StatefulBeanToCsvBuilder<SeparateQual>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            separateQuals.stream()
                    .forEach((sp) -> {
                        try{
                            if(!sp.getId().equals(id)){
                                    beanToCsv.write(sp);
                            }
                            else{
                                MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, sp);
                            }
                        } catch(Exception ex){
                            result.setCode(Constants.CODE_ERROR);
                            result.setMessage(ex.getMessage());
                        }
                    }
                    );
            
        } catch (NullPointerException | IOException ex) {
            log.error("deleteSeparateQual [2]: error = {}",  ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        } 
       
        if(result.getCode() == Constants.CODE_ERROR){
            log.error("deleteSeparateQual [3]: error = {}", result.getMessage());
        }
        return result;
    }
}
