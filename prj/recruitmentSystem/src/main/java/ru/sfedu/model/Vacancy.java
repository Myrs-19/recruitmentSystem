package ru.sfedu.model;

import com.opencsv.bean.*;
import com.opencsv.bean.*;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Vacancy {
    @Element
    @CsvBindByPosition(position = 0)
    private int id;
    
    @Element
    @CsvCustomBindByPosition(position = 1, converter = CompanyCsvConverter.class)
    private Company company;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String title;
    
    @Element
    @CsvBindByPosition(position = 3)
    private String specialization;
    
    @Element
    @CsvBindByPosition(position = 4)
    private boolean online;
    
    @Element
    @CsvBindByPosition(position = 5)
    private String skills;
    
    @Element
    @CsvBindByPosition(position = 6)
    private int salary;
    
    @Element
    @CsvBindByPosition(position = 7)
    private String city;
    
    @Element
    @CsvBindByPosition(position = 8)
    private String address;
    
    @Element
    @CsvBindByPosition(position = 9)
    private String experience;
    
    
    public Vacancy(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean getOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    
    @Override
    public String toString(){
        return "Vacancy{" +
                "id = " + getId()+
                ", title = " + getTitle()+
                ", salary = " + getSalary()+
                '}';
    }
}
