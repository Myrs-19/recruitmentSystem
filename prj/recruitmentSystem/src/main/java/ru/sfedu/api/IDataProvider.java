package ru.sfedu.api;

import java.util.List;
import ru.sfedu.model.*;

/**
 *
 * @author mike
 */
public interface IDataProvider {
    /**
     * Method for registering a person in the system.
     * If a person is valid returns a Result with a 200 code and an object which was saved.
     * If a person is not valid returns a Result with a 422 code and a message.
     *
     * @param person - the person(employee, user as inheriters) to be saved.
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
     * Method that returns user in system by id.
     *
     * @param id - id of a user.
     * @return user object.
     **/
    User getUser(String id);
    
    /**
     * Method that returns resume in system by id.
     *
     * @param id - id of a resume.
     * @return resume object.
     **/
    Resume getResume(String id);
    
    /**
     * Method that returns company in system by id.
     *
     * @param id - id of a company.
     * @return company object.
     **/
    Company getCompany(String id);
    
    /**
     * Method that returns vacancy in system by id.
     *
     * @param id - id of a vacancy .
     * @return vacancy object.
     **/
    Vacancy getVacancy(String id);
    
    /**
     * Method that returns employee in system by id.
     *
     * @param id - id of a employee .
     * @return employee object.
     **/
    Employee getEmployee(String id);
    
    /**
     * Method that returns separateQual in system by id.
     *
     * @param id - id of a separateQual .
     * @return separateQual object.
     **/
    SeparateQual getSeparateQual(String id);
    
    /**
     * Method that returns all users in system.
     *
     * @return a list of users objects.
     **/
    List<User> getAllUsers();
    
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
     * Method for updating a person(user, employee) in the system.
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
     * @return an object that contains the result of the save.
     **/
    Result deletePerson(String id);
    
    /**
     * Method for deleting a resume in the system by id.
     * If a resume is valid returns a Result with a 200 code and an object which was deleted.
     * If a resume is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of resume .
     * @return an object that contains the result of the save.
     **/
    Result deleteResume(String id);
    
    /**
     * Method for deleting a company in the system by id.
     * If a company is valid returns a Result with a 200 code and an object which was deleted.
     * If a company is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of company .
     * @return an object that contains the result of the save.
     **/
    Result deleteCompany(String id);
    
    /**
     * Method for deleting a vacancy in the system by id.
     * If a vacancy is valid returns a Result with a 200 code and an object which was deleted.
     * If a vacancy is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of vacancy .
     * @return an object that contains the result of the save.
     **/
    Result deleteVacancy(String id);
    
    /**
     * Method for deleting a separateQual in the system by id.
     * If a separateQual is valid returns a Result with a 200 code and an object which was deleted.
     * If a separateQual is not valid returns a Result with a 422 code and a pair that consists of an object and errors.
     *
     * @param id - the id of separateQual .
     * @return an object that contains the result of the save.
     **/
    Result deleteSeparateQual(String id);
}
