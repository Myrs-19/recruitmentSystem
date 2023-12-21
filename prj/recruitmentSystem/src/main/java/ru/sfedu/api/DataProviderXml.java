/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.api;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import ru.sfedu.Constants;
import ru.sfedu.model.*;

import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;
import ru.sfedu.util.FileUtil;
import ru.sfedu.util.TableName;

/**
 *
 * @author mike
 */
public class DataProviderXml implements IDataProvider{
    private static final Logger log = LogManager.getLogger(DataProviderXml.class.getName());
    
    public DataProviderXml(){
        log.debug("DataProviderXml [1]: initialization");
        
        try{
            FileUtil.createFolderIfNotExists(getConfigurationEntry(Constants.XML_PATH_FOLDER));
        } catch(IOException ex){
            log.error("DataProviderXml [2]: error = {}", ex.getMessage());
        }
    }
    
    /**
    * Method generates id for new record
    * получаем список id и увеличиваем максимальный на 1
    * @param ids - list of all of ids in data of bean
    * @return new id for new record
    **/
    private String getId(List<Integer> ids){
        return String.valueOf(Collections.max(ids) + 1);
    }
    
    /**
    * Method returnes path (and creates it if not exist)
    * метод получает имя файла (для конкретного бина)
    * и возвращает относительный путь этого файла
    * @param tableName - имя файла
    * @return возвращает относительный путь до файла
    **/
    private static String getPathAndCreateFileIfNotExist(String tableName){
        String path = getConfigurationEntry(Constants.XML_PATH_FOLDER) + tableName + Constants.XML_FILE_TYPE;
        try{
            FileUtil.createFileIfNotExists(path);
        } catch(IOException ex){
            log.error("getPath [1]: error = {}", ex.getMessage());
        }
        
        return path;
    }
    
    /**
     * Method saves xml wrapper into which saved particular bean
     * @param tableName - имя файла
     * @param obj - обертка, в которой содержится наш бин
     **/
    private static void saveWrap(String tableName, XmlWrapper obj) throws Exception{
        log.debug("save [1]: saving bean through XmlWrapper");
        String filePath = getPathAndCreateFileIfNotExist(tableName);
        
        File file = new File(filePath);
        Serializer serializer = new Persister();
           
        serializer.write(obj, file);
        
    }
    
    /**
     * Method gives bean into xml wrap
     * @param tableName - имя файла
     * @return возвращает бин в обертке XmlWrapper
     **/
    private static <T> XmlWrapper getWrap(String tableName) throws Exception{
        log.debug("save [1]: getting bean through XmlWrapper");
        Serializer serializer = new Persister();
        
        String filePath = getPathAndCreateFileIfNotExist(tableName);
        
        File file = new File(filePath);
        XmlWrapper<T> wrap = new XmlWrapper<T>();
        
        wrap = serializer.read(XmlWrapper.class, file);
        
        return wrap;
    }
    
    
    /** See also {@link IDataProvider#savePerson(Person)}. */
    @Override
    public Result savePerson(Person person) {
        log.debug("savePerson [1]: saving person, type of person = {}, person = {}", person.getTypePerson(), person);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = TableName.getTableNamePerson(person.getTypePerson());
        
        try{
            int id = Constants.FIRST_ID;
            XmlWrapper<Person> wrap;
            try{
                wrap = DataProviderXml.<Person>getWrap(tableName);
                id = Integer.parseInt(getId(
                    wrap.getList().stream()
                            .map((Person p) -> p.getId()).toList()
                ));
                person.setId(id);
                
                List<Person> list = wrap.getList();
                list.add(person);
                wrap.setList(list);
                
            } catch(Exception ex){
                log.error("savePerson [2]: error = File is Empty");
                person.setId(id);
                
                wrap = new XmlWrapper<Person>();    
                wrap.setList(Arrays.asList(person));
                
            }
            
            DataProviderXml.saveWrap(tableName, wrap);
            
        } catch(Exception ex){
            log.error("savePerson [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#saveResume(Resume)}. */
    @Override
    public Result saveResume(Resume resume) {
        log.debug("saveResume [1]: saving resume, resume = {}",resume);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_RESUME;
        
        try{
            int id = Constants.FIRST_ID;
            XmlWrapper<Resume> wrap;
            try{
                wrap = DataProviderXml.<Resume>getWrap(tableName);
                id = Integer.parseInt(getId(
                wrap.getList().stream()
                        .map((Resume r) -> r.getId()).toList()
                ));
                resume.setId(id);
                
                List<Resume> list = wrap.getList();
                list.add(resume);
                wrap.setList(list);
                
            } catch(Exception ex){
                log.error("saveResume [2]: error = File is Empty");
                resume.setId(id);
                
                wrap = new XmlWrapper<Resume>();    
                wrap.setList(Arrays.asList(resume));
                
            }
            
            DataProviderXml.saveWrap(tableName, wrap);
            
        } catch(Exception ex){
            log.error("saveResume [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#saveCompany(Company)}. */
    @Override
    public Result saveCompany(Company company) {
        log.debug("saveCompany [1]: saving company, company = {}",company);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_COMPANY;
        
        try{
            int id = Constants.FIRST_ID;
            XmlWrapper<Company> wrap;
            try{
                wrap = DataProviderXml.<Company>getWrap(tableName);
                id = Integer.parseInt(getId(
                wrap.getList().stream()
                        .map((Company c) -> c.getId()).toList()
                ));
                company.setId(id);
                
                List<Company> list = wrap.getList();
                list.add(company);
                wrap.setList(list);
                
            } catch(Exception ex){
                log.error("saveCompany [2]: error = File is Empty");
                company.setId(id);
                
                wrap = new XmlWrapper<Company>();    
                wrap.setList(Arrays.asList(company));
                
            }
            
            DataProviderXml.saveWrap(tableName, wrap);
            log.debug("saveCompany [3]: saving was successful, company = {}", company);
        } catch(Exception ex){
            log.error("saveCompany [4]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#saveVacancy(Vacancy)}. */
    @Override
    public Result saveVacancy(Vacancy vacancy) {
        log.debug("saveVacancy [1]: saving vacancy, vacancy = {}",vacancy);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_VACANCY;
        
        try{
            int id = Constants.FIRST_ID;
            XmlWrapper<Vacancy> wrap;
            try{
                wrap = DataProviderXml.<Vacancy>getWrap(tableName);
                id = Integer.parseInt(getId(
                wrap.getList().stream()
                        .map((Vacancy v) -> v.getId()).toList()
                ));
                vacancy.setId(id);
                
                List<Vacancy> list = wrap.getList();
                list.add(vacancy);
                wrap.setList(list);
                
            } catch(Exception ex){
                log.error("saveVacancy [2]: error = File is Empty");
                vacancy.setId(id);
                
                wrap = new XmlWrapper<Vacancy>();    
                wrap.setList(Arrays.asList(vacancy));
                
            }
            
            DataProviderXml.saveWrap(tableName, wrap);
            
        } catch(Exception ex){
            log.error("saveVacancy [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#saveSeparateQual(SeparateQual)}. */
    @Override
    public Result saveSeparateQual(SeparateQual separateQual) {
        log.debug("SeparateQual [1]: saving separateQual, separateQual = {}",separateQual);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_SEPARATE_QUAL;
        
        try{
            int id = Constants.FIRST_ID;
            XmlWrapper<SeparateQual> wrap;
            try{
                wrap = DataProviderXml.<SeparateQual>getWrap(tableName);
                id = Integer.parseInt(getId(
                wrap.getList().stream()
                        .map((SeparateQual sq) -> sq.getId()).toList()
                ));
                separateQual.setId(id);
                
                List<SeparateQual> list = wrap.getList();
                list.add(separateQual);
                wrap.setList(list);
                
            } catch(Exception ex){
                log.error("SeparateQual [2]: error = File is Empty");
                separateQual.setId(id);
                
                wrap = new XmlWrapper<SeparateQual>();    
                wrap.setList(Arrays.asList(separateQual));
                
            }
            
            DataProviderXml.saveWrap(tableName, wrap);
            
        } catch(Exception ex){
            log.error("SeparateQual [3]: error = {}", ex.getMessage());
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#getClient(int)}. */
    @Override
    public Client getClient(int id) {
        log.debug("getClient [1]: getting client, id = {}", id);
        try{
            XmlWrapper<Client> wrap = getWrap(Constants.TITLE_TABLE_CLIENT);
            Optional<Client> optionalClient = wrap.getList().stream()
                    .filter(u -> u.getId() == id)
                    .findFirst();
            return optionalClient.get();
        } catch(Exception ex){
            log.error("getClient [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("the client has not been found, id = " + id);
    }

    /** See also {@link IDataProvider#getResume(int)}. */
    @Override
    public Resume getResume(int id) {
        log.debug("getResume [1]: getting resume, id = {}", id);
        try{
            XmlWrapper<Resume> wrap = getWrap(Constants.TITLE_TABLE_RESUME);
            Optional<Resume> optionalResume = wrap.getList().stream()
                    .filter(r -> r.getId() == id)
                    .findFirst();
            return optionalResume.get();
        } catch(Exception ex){
            log.error("getResume [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("the resume has not been found, id = " + id);
    }

    /** See also {@link IDataProvider#getCompany(int)}. */
    @Override
    public Company getCompany(int id) {
        log.debug("getCompany [1]: getting company, id = {}", id);
        try{
            XmlWrapper<Company> wrap = getWrap(Constants.TITLE_TABLE_COMPANY);
            Optional<Company> optionalCompany = wrap.getList().stream()
                    .filter(c -> c.getId() == id)
                    .findFirst();
            return optionalCompany.get();
        } catch(Exception ex){
            log.error("getCompany [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("the company has not been found, id = " + id);
    }

    /** See also {@link IDataProvider#getVacancy(int)}. */
    @Override
    public Vacancy getVacancy(int id) {
        log.debug("getVacancy [1]: getting vacancy, id = {}", id);
        try{
            XmlWrapper<Vacancy> wrap = getWrap(Constants.TITLE_TABLE_VACANCY);
            Optional<Vacancy> optionalVacancy = wrap.getList().stream()
                    .filter(v -> v.getId() == id)
                    .findFirst();
            return optionalVacancy.get();
        } catch(Exception ex){
            log.error("getVacancy [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("the vacancy has not been found, id = " + id);
    }

    /** See also {@link IDataProvider#getEmployee(int)}. */
    @Override
    public Employee getEmployee(int id) {
        log.debug("getEmployee [1]: getting employee, id = {}", id);
        try{
            XmlWrapper<Employee> wrap = getWrap(Constants.TITLE_TABLE_EMPLOYEE);
            Optional<Employee> optionalEmployee = wrap.getList().stream()
                    .filter(emp -> emp.getId() == id)
                    .findFirst();
            return optionalEmployee.get();
        } catch(Exception ex){
            log.error("getEmployee [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("the employee has not been found, id = " + id);
    }

    /** See also {@link IDataProvider#getSeparateQual(int)}. */
    @Override
    public SeparateQual getSeparateQual(int id) {
        log.debug("getSeparateQual [1]: getting separateQual, id = {}", id);
        try{
            XmlWrapper<SeparateQual> wrap = getWrap(Constants.TITLE_TABLE_SEPARATE_QUAL);
            Optional<SeparateQual> optionalSeparateQual = wrap.getList().stream()
                    .filter(v -> v.getId() == id)
                    .findFirst();
            return optionalSeparateQual.get();
        } catch(Exception ex){
            log.error("getSeparateQual [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("the separateQual has not been found, id = " + id);
    }

    /** See also {@link IDataProvider#getAllClients()}. */
    @Override
    public List<Client> getAllClients() {
        log.debug("getAllClients [1]: getting all clients");
        try{
            XmlWrapper<Client> wrap = getWrap(Constants.TITLE_TABLE_CLIENT);
            return wrap.getList();
        } catch(Exception ex){
            log.error("getAllClients [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("no clients were not found");
    }

    /** See also {@link IDataProvider#getAllResumes()}. */
    @Override
    public List<Resume> getAllResumes() {
        log.debug("getAllResumes [1]: getting all resumes");
        try{
            XmlWrapper<Resume> wrap = getWrap(Constants.TITLE_TABLE_RESUME);
            return wrap.getList();
        } catch(Exception ex){
            log.error("getAllResumes [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("no resumes were not found");
    }

    /** See also {@link IDataProvider#getAllCompanies()}. */
    @Override
    public List<Company> getAllCompanies() {
        log.debug("getAllCompanies [1]: getting all companies");
        try{
            XmlWrapper<Company> wrap = getWrap(Constants.TITLE_TABLE_COMPANY);
            return wrap.getList();
        } catch(Exception ex){
            log.error("getAllCompanies [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("no companies were not found");
    }

    /** See also {@link IDataProvider#getAllVacancies()}. */
    @Override
    public List<Vacancy> getAllVacancies() {
        log.debug("getAllVacancies [1]: getting all мacancies");
        try{
            XmlWrapper<Vacancy> wrap = getWrap(Constants.TITLE_TABLE_VACANCY);
            return wrap.getList();
        } catch(Exception ex){
            log.error("getAllVacancies [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("no мacancies were not found");
    }

    /** See also {@link IDataProvider#getAllEmployees()}. */
    @Override
    public List<Employee> getAllEmployees() {
        log.debug("getAllEmployees [1]: getting all employees");
        try{
            XmlWrapper<Employee> wrap = getWrap(Constants.TITLE_TABLE_EMPLOYEE);
            return wrap.getList();
        } catch(Exception ex){
            log.error("getAllEmployees [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("no employees were not found");
    }

    /** See also {@link IDataProvider#getAllSeparateQuals()}. */
    @Override
    public List<SeparateQual> getAllSeparateQuals() {
        log.debug("getAllSeparateQuals [1]: getting all separateQuals");
        try{
            XmlWrapper<SeparateQual> wrap = getWrap(Constants.TITLE_TABLE_SEPARATE_QUAL);
            return wrap.getList();
        } catch(Exception ex){
            log.error("getAllSeparateQuals [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("no separateQuals were not found");
    }

    /** See also {@link IDataProvider#updatePerson()}. */
    @Override
    public Result updatePerson(Person person) {
        log.debug("updatePerson [1]: updating person, type of person = {}, person = {}", person.getTypePerson(), person);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = TableName.getTableNamePerson(person.getTypePerson());
        
        try{
            XmlWrapper<Person> wrap = DataProviderXml.<Person>getWrap(tableName);
            
            List<Person> list = wrap.getList().stream()
                    .map((p) -> {
                        if(p.getId() == person.getId()){
                            return person;
                        }
                        else{
                            return p;
                        }
                    }).toList();
            
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            MongoProvider.save(CommandType.UPDATED, RepositoryType.XML, person);
        } catch(Exception ex){
            log.error("updatePerson [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#updateResume(Resume)}. */
    @Override
    public Result updateResume(Resume resume) {
        log.debug("updateResume [1]: updating resume, resume = {}", resume);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_RESUME;
        
        try{
            XmlWrapper<Resume> wrap = DataProviderXml.<Resume>getWrap(tableName);
            
            List<Resume> list = wrap.getList().stream()
                    .map((r) -> {
                        if(r.getId() == resume.getId()){
                            return resume;
                        }
                        else{
                            return r;
                        }
                    }).toList();
            
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            MongoProvider.save(CommandType.UPDATED, RepositoryType.XML, resume);
        } catch(Exception ex){
            log.error("updateResume [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#updateCompany(Company)}. */
    @Override
    public Result updateCompany(Company company) {
        log.debug("updateCompany [1]: updating company, company = {}", company);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_COMPANY;
        
        try{
            XmlWrapper<Company> wrap = DataProviderXml.<Company>getWrap(tableName);
            
            List<Company> list = wrap.getList().stream()
                    .map((c) -> {
                        if(c.getId() == company.getId()){
                            return company;
                        }
                        else{
                            return c;
                        }
                    }).toList();
            
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            MongoProvider.save(CommandType.UPDATED, RepositoryType.XML, company);
        } catch(Exception ex){
            log.error("updateCompany [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#updateVacancy(Vacancy)}. */
    @Override
    public Result updateVacancy(Vacancy vacancy) {
        log.debug("updateVacancy [1]: updating vacancy, vacancy = {}", vacancy);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_VACANCY;
        
        try{
            XmlWrapper<Vacancy> wrap = DataProviderXml.<Vacancy>getWrap(tableName);
            
            List<Vacancy> list = wrap.getList().stream()
                    .map((v) -> {
                        if(v.getId() == vacancy.getId()){
                            return vacancy;
                        }
                        else{
                            return v;
                        }
                    }).toList();
            
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            MongoProvider.save(CommandType.UPDATED, RepositoryType.XML, vacancy);
        } catch(Exception ex){
            log.error("updateVacancy [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#updateSeparateQual(SeparateQual)}. */
    @Override
    public Result updateSeparateQual(SeparateQual separateQual) {
        log.debug("updateSeparateQual [1]: updating separateQual, separateQual = {}", separateQual);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_SEPARATE_QUAL;
        
        try{
            XmlWrapper<SeparateQual> wrap = DataProviderXml.<SeparateQual>getWrap(tableName);
            
            List<SeparateQual> list = wrap.getList().stream()
                    .map((sp) -> {
                        if(sp.getId() == separateQual.getId()){
                            return separateQual;
                        }
                        else{
                            return sp;
                        }
                    }).toList();
            
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            MongoProvider.save(CommandType.UPDATED, RepositoryType.XML, separateQual);
        } catch(Exception ex){
            log.error("updateSeparateQual [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deletePerson(int, TypePerson)}. */
    @Override
    public Result deletePerson(int id, TypePerson typePerson) {
        log.debug("deletePerson [1]: deleting person, typePerson = {}, id = {}", typePerson, id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = TableName.getTableNamePerson(typePerson);
        
        try{
            XmlWrapper<Person> wrap = DataProviderXml.<Person>getWrap(tableName);
            
            List<Person> list = wrap.getList().stream()
                    .filter((p) -> p.getId() != id)
                    .toList();
            boolean flag = wrap.getList().size() != list.size();
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            if(flag){
                Person person = new Person();
                person.setId(id);
                MongoProvider.save(CommandType.DELETED, RepositoryType.XML, person);
            }
        } catch(Exception ex){
            log.error("deletePerson [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deleteResume(int)}. */
    @Override
    public Result deleteResume(int id) {
        log.debug("deleteResume [1]: deleting resume, id = {}", id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_RESUME;
        
        try{
            XmlWrapper<Resume> wrap = DataProviderXml.<Resume>getWrap(tableName);
            
            List<Resume> list = wrap.getList().stream()
                    .filter((r) -> r.getId() != id)
                    .toList();
            boolean flag = wrap.getList().size() != list.size();
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            if(flag){
                Resume resume = new Resume();
                resume.setId(id);
                MongoProvider.save(CommandType.DELETED, RepositoryType.XML, resume);
            }
        } catch(Exception ex){
            log.error("deleteResume [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deleteCompany(int)}. */
    @Override
    public Result deleteCompany(int id) {
        log.debug("deleteCompany [1]: deleting company, id = {}", id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_COMPANY;
        
        try{
            XmlWrapper<Company> wrap = DataProviderXml.<Company>getWrap(tableName);
            
            List<Company> list = wrap.getList().stream()
                    .filter((c) -> c.getId() != id)
                    .toList();
            boolean flag = wrap.getList().size() != list.size();
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            if(flag){
                Company company = new Company();
                company.setId(id);
                MongoProvider.save(CommandType.DELETED, RepositoryType.XML, company);
            }
        } catch(Exception ex){
            log.error("deleteCompany [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deleteVacancy(int)}. */
    @Override
    public Result deleteVacancy(int id) {
        log.debug("deleteVacancy [1]: deleting vacancy, id = {}", id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_VACANCY;
        
        try{
            XmlWrapper<Vacancy> wrap = DataProviderXml.<Vacancy>getWrap(tableName);
            
            List<Vacancy> list = wrap.getList().stream()
                    .filter((v) -> v.getId() != id)
                    .toList();
            boolean flag = wrap.getList().size() != list.size();
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            if(flag){
                Vacancy vacancy = new Vacancy();
                vacancy.setId(id);
                MongoProvider.save(CommandType.DELETED, RepositoryType.XML, vacancy);
            }
        } catch(Exception ex){
            log.error("deleteVacancy [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    /** See also {@link IDataProvider#deleteSeparateQual(int)}. */
    @Override
    public Result deleteSeparateQual(int id) {
        log.debug("deleteSeparateQual [1]: deleting separateQual, id = {}", id);
        
        Result result = new Result();
        result.setCode(Constants.CODE_SUCCESS);
        result.setMessage(Constants.MESSAGE_CODE_SUCCESS);
        
        String tableName = Constants.TITLE_TABLE_SEPARATE_QUAL;
        
        try{
            XmlWrapper<SeparateQual> wrap = DataProviderXml.<SeparateQual>getWrap(tableName);
            
            List<SeparateQual> list = wrap.getList().stream()
                    .filter((sp) -> sp.getId() != id)
                    .toList();
            boolean flag = wrap.getList().size() != list.size();
            wrap.setList(list);
            
            saveWrap(tableName, wrap);
            if(flag){
                SeparateQual separateQual = new SeparateQual();
                separateQual.setId(id);
                MongoProvider.save(CommandType.DELETED, RepositoryType.XML, separateQual);
            }
        } catch(Exception ex){
            log.error("deleteSeparateQual [2]: error = File does not exist");
            result.setCode(Constants.CODE_ERROR);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }
    
}
