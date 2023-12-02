package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;

public class Vacancy {
    @CsvBindByPosition(position = 0)
    String id;
    @CsvBindByPosition(position = 1)
    String companyId;
    @CsvBindByPosition(position = 2)
    String title;
    @CsvBindByPosition(position = 3)
    String specialization;
    @CsvBindByPosition(position = 4)
    String online;
    @CsvBindByPosition(position = 5)
    String skills;
    @CsvBindByPosition(position = 6)
    String salary;
    @CsvBindByPosition(position = 7)
    String city;
    @CsvBindByPosition(position = 8)
    String address;
    @CsvBindByPosition(position = 9)
    String experience;
    
    public Vacancy(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
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
        return "Resume{" +
                "id = " + getId() +
                ", companyId = " + getCompanyId()+
                ", title = " + getTitle()+
                ", salary = " + getSalary()+
                '}';
    }
}
