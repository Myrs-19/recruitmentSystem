package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Vacancy {
    @Element
    @CsvBindByPosition(position = 0)
    int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    String title;
    
    @Element(required = false)
    @CsvBindByPosition(position = 2)
    String specialization;
    
    @Element(required = false)
    @CsvBindByPosition(position = 3)
    boolean online;
    
    @Element(required = false)
    @CsvBindByPosition(position = 4)
    String skills;
    
    @Element
    @CsvBindByPosition(position = 5)
    int salary;
    
    @Element(required = false)
    @CsvBindByPosition(position = 6)
    String city;
    
    @Element(required = false)
    @CsvBindByPosition(position = 7)
    String address;
    
    @Element(required = false)
    @CsvBindByPosition(position = 8)
    String experience;
    
    public Vacancy(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id = " + getId() +
                ", companyId = " + getCompanyId()+
                ", title = " + getTitle()+
                ", salary = " + getSalary()+
                '}';
    }
}
