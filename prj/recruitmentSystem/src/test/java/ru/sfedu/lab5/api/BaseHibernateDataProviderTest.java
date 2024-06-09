package ru.sfedu.lab5.api;

import ru.sfedu.lab5.model.*;

public class BaseHibernateDataProviderTest {

    public Client getClient() {
        Client client = new Client();
        client.setName("John");
        client.setSurname("Doe");
        client.setMiddleName("Smith");
        client.setPhone("+1234567890");
        client.setEmail("john@example.com");
        client.setAge(30);
        client.setBirthday("1990-01-01");
        client.setPassword("securePassword123");
        client.setAddress("123 Main St, Springfield");
        return client;
    }

    public Company getCompany() {
        Company company = new Company();
        company.setTitle("Tech Solutions");
        company.setDescription("Leading tech company in software solutions.");
        return company;
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setName("Jane");
        employee.setSurname("Doe");
        employee.setMiddleName("Alice");
        employee.setPhone("+1234567899");
        employee.setEmail("jane@example.com");
        employee.setAge(28);
        employee.setBirthday("1992-05-12");
        employee.setSalary("50000");
        employee.setPosition("Developer");
        employee.setIsWorking("true");
        // Assign a company to the employee (assuming the company object is already created)
        employee.setCompany(getCompany());
        return employee;
    }

    public Resume getResume() {
        Resume resume = new Resume();
        resume.setProfession("Software Developer");
        resume.setCity("Springfield");
        resume.setSkills("Java, Python, SQL");
        resume.setEducation("Bachelor's Degree in Computer Science");
        resume.setExperience("5 years of experience in software development.");
        resume.setSex("Male");
        resume.setWorkPermit(true);
        resume.setCitizenship("US");
        // Assign a client to the resume (assuming the client object is already created)
        resume.setClient(getClient());
        return resume;
    }

    public Vacancy getVacancy() {
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle("Senior Developer");
        vacancy.setSpecialization("Software Development");
        vacancy.setOnline(true);
        vacancy.setSkills("Java, Spring, Hibernate");
        vacancy.setSalary("70000");
        vacancy.setCity("New York");
        vacancy.setAddress("456 Tech Ave");
        vacancy.setExperience("7+ years");
        // Assign a company to the vacancy (assuming the company object is already created)
        vacancy.setCompany(getCompany());
        return vacancy;
    }

    public SeparateQual getSeparateQual() {
        SeparateQual separateQual = new SeparateQual();
        separateQual.setQuality(10);
        separateQual.setDescription("Excellent coding skills.");
        return separateQual;
    }
}
