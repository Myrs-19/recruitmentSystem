package ru.sfedu.api;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.sfedu.Constants;

import ru.sfedu.model.*;

import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;

import ru.sfedu.util.FileUtil;

/**
 *
 * @author mike
 */
public interface IDataProvider {
    
    static final Logger log = LogManager.getLogger(IDataProvider.class.getName());
    
    /**
     * Method for registering a person in the system.
     * If a person is valid returns a Result with a 200 code and an object which was saved.
     * If a person is not valid returns a Result with a 422 code and a message.
     *
     * @param person - the person(employee, client as inheriters) to be saved.
     * @return an object that contains the result of the save.
     **/
    Result savePerson(Person person);
    
    /**
     * Method for registering a resume in the system.
     * If a resume is valid returns a Result with a 200 code and an object which was saved.
     * If a resume is not valid returns a Result with a 422 code and a message.
     *
     * @param resume - the resume to be saved.
     * @return an object that contains the result of the save.
     **/
    Result saveResume(Resume resume);
    
    /**
     * Method for registering a company in the system.
     * If a company is valid returns a Result with a 200 code and an object which was saved.
     * If a company is not valid returns a Result with a 422 code and a message.
     *
     * @param company - the resume to be saved.
     * @return an object that contains the result of the save.
     **/
    Result saveCompany(Company company);
    
    /**
     * Method for registering a vacancy in the system.
     * If a vacancy is valid returns a Result with a 200 code and an object which was saved.
     * If a vacancy is not valid returns a Result with a 422 code and a message.
     *
     * @param vacancy - the resume to be saved.
     * @return an object that contains the result of the save.
     **/
    Result saveVacancy(Vacancy vacancy);
    
    /**
     * Method for registering a separateQual in the system.
     * If a separateQual is valid returns a Result with a 200 code and an object which was saved.
     * If a separateQual is not valid returns a Result with a 422 code and a message.
     *
     * @param separateQual - the resume to be saved.
     * @return an object that contains the result of the save.
     **/
    Result saveSeparateQual(SeparateQual separateQual);
    
    /**
     * Method that returns client in system by id.
     *
     * @param id - id of a client.
     * @return client object.
     **/
    Client getClient(int id);
    
    /**
     * Method that returns resume in system by id.
     *
     * @param id - id of a resume.
     * @return resume object.
     **/
    Resume getResume(int id);
    
    /**
     * Method that returns company in system by id.
     *
     * @param id - id of a company.
     * @return company object.
     **/
    Company getCompany(int id);
    
    /**
     * Method that returns vacancy in system by id.
     *
     * @param id - id of a vacancy .
     * @return vacancy object.
     **/
    Vacancy getVacancy(int id);
    
    /**
     * Method that returns employee in system by id.
     *
     * @param id - id of a employee .
     * @return employee object.
     **/
    Employee getEmployee(int id);
    
    /**
     * Method that returns separateQual in system by id.
     *
     * @param id - id of a separateQual .
     * @return separateQual object.
     **/
    SeparateQual getSeparateQual(int id);
    
    /**
     * Method that returns all clients in system.
     *
     * @return a list of clients objects.
     **/
    List<Client> getAllClients();
    
    /**
     * Method that returns all resume in system.
     *
     * @return a list of resumes objects.
     **/
    List<Resume> getAllResumes();
    
    /**
     * Method that returns all companies in system.
     *
     * @return a list of companies objects.
     **/
    List<Company> getAllCompanies();
    
    /**
     * Method that returns all vacancies in system.
     *
     * @return a list of vacancies objects.
     **/
    List<Vacancy> getAllVacancies();
    
    /**
     * Method that returns all employees in system.
     *
     * @return a list of employees objects.
     **/
    List<Employee> getAllEmployees();
    
    /**
     * Method that returns all separateQuals in system.
     *
     * @return a list of separateQuals objects.
     **/
    List<SeparateQual> getAllSeparateQuals();

    /**
     * Method for updating a person(client, employee) in the system.
     * If a person is valid returns a Result with a 200 code and an object which was updated.
     * If a person is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param person - the object to be saved.
     * @return an object that contains the result of the save.
     **/
    Result updatePerson(Person person);
    
    /**
     * Method for updating a resume in the system.
     * If a resume is valid returns a Result with a 200 code and an object which was updated.
     * If a resume is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param resume - the object to be saved.
     * @return an object that contains the result of the save.
     **/
    Result updateResume(Resume resume);
    
    /**
     * Method for updating a company in the system.
     * If a company is valid returns a Result with a 200 code and an object which was updated.
     * If a company is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param company - the object to be saved.
     * @return an object that contains the result of the save.
     **/
    Result updateCompany(Company company);
    
    /**
     * Method for updating a vacancy in the system.
     * If a vacancy is valid returns a Result with a 200 code and an object which was updated.
     * If a vacancy is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param vacancy - the object to be saved.
     * @return an object that contains the result of the save.
     **/
    Result updateVacancy(Vacancy vacancy);
    
    /**
     * Method for updating a separateQual in the system.
     * If a separateQual is valid returns a Result with a 200 code and an object which was updated.
     * If a separateQual is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param separateQual - the object to be saved.
     * @return an object that contains the result of the save.
     **/
    Result updateSeparateQual(SeparateQual separateQual);
    
    /**
     * Method for deleting a person in the system by id.
     * If a person is valid returns a Result with a 200 code and an object which was deleted.
     * If a person is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of person .
     * @param typePerson - the type of person what (Client, Employee).
     * @return an object that contains the result of the save.
     **/
    Result deletePerson(int id, TypePerson typePerson);
    
    /**
     * Method for deleting a resume in the system by id.
     * If a resume is valid returns a Result with a 200 code and an object which was deleted.
     * If a resume is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of resume .
     * @return an object that contains the result of the save.
     **/
    Result deleteResume(int id);
    
    /**
     * Method for deleting a company in the system by id.
     * If a company is valid returns a Result with a 200 code and an object which was deleted.
     * If a company is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of company .
     * @return an object that contains the result of the save.
     **/
    Result deleteCompany(int id);
    
    /**
     * Method for deleting a vacancy in the system by id.
     * If a vacancy is valid returns a Result with a 200 code and an object which was deleted.
     * If a vacancy is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of vacancy .
     * @return an object that contains the result of the save.
     **/
    Result deleteVacancy(int id);
    
    /**
     * Method for deleting a separateQual in the system by id.
     * If a separateQual is valid returns a Result with a 200 code and an object which was deleted.
     * If a separateQual is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of separateQual .
     * @return an object that contains the result of the save.
     **/
    Result deleteSeparateQual(int id);
    
    
    Result giveAssessment(int idEmployee, int idCompany, int quality, String description);
    
    
    default boolean checkQuality(int quality){
        return quality >= Constants.MIN_QUALITY && quality <= Constants.MAX_QUALITY;
    }
    
    boolean checkDealTogether(int idEmployee, int idCompany);
    
    
    Result calculateAssessment(int idCompany, boolean others);
    
    
    Result calculateAssessmentWithOthers(ResultAnalisys resultAnalisys);
    
    
    default void generateResultFile(ResultAnalisys resultAnalisys){
        log.debug("generateResultFile [1]: writting result, company = {}, result = {}", resultAnalisys.getCompany(), resultAnalisys.getResult());
        
        String filePath = getConfigurationEntry(Constants.PATH_RESULT).concat(String.format(Constants.NAME_FILE_RESULT, resultAnalisys.getCompany().getTitle(), resultAnalisys.getCompany().getId(), String.valueOf(LocalDateTime.now()))).concat(Constants.CSV_FILE_TYPE);
     
        try{
            FileUtil.createFolderIfNotExists(getConfigurationEntry(Constants.PATH_RESULT));
            FileUtil.createFileIfNotExists(filePath);
            File file = new File(filePath);
            
            FileWriter outputfile = new FileWriter(file);
            
            CSVWriter writer = new CSVWriter(outputfile);
            
            writer.writeNext(Constants.HEADER_RESULT);
            String[] data;
            if(resultAnalisys.getPlace() != 0){
                data = new String[] {
                    String.valueOf( resultAnalisys.getCompany().getId()), 
                    resultAnalisys.getCompany().getTitle(), 
                    String.valueOf(resultAnalisys.getResult()), 
                    String.valueOf(resultAnalisys.getPlace())
                };
                
            }
            else{
                data = new String[] {
                    String.valueOf( resultAnalisys.getCompany().getId()), 
                    resultAnalisys.getCompany().getTitle(), 
                    String.valueOf(resultAnalisys.getResult())
                };
                
            }
            
            writer.writeNext(data);
            
            writer.close();
        } catch(IOException ex){
            log.error("generateResultFile [2]: error = {}", ex.getMessage());
        }
    }
}
