/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import org.simpleframework.xml.*;
import org.simpleframework.xml.Root;

/**
 *
 * @author mike
 */
@Root
public class Resume {
    @Element
    @CsvBindByPosition(position = 0)
    int id;
    
    @Element
    @CsvCustomBindByPosition(position = 1, converter = ClientCsvConverter.class)
    Client client;
    
    @Element
    @CsvBindByPosition(position = 2)
    String profession;
    
    @Element
    @CsvBindByPosition(position = 3)
    String city;
    
    @Element(required = false)
    @CsvBindByPosition(position = 4)
    String skills;
    
    @Element(required = false)
    @CsvBindByPosition(position = 5)
    String education;
    
    @Element(required = false)
    @CsvBindByPosition(position = 6)
    String experience;
    
    @Element(required = false)
    @CsvBindByPosition(position = 8)
    boolean sex;
    
    @Element(required = false)
    @CsvBindByPosition(position = 10)
    boolean workPermit;
    
    @Element(required = false)
    @CsvBindByPosition(position = 11)
    String citizenship;
    
    public Resume(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(boolean workPermit) {
        this.workPermit = workPermit;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
    
    @Override
    public String toString(){
        return "Resume{" +
                "id = " + getId() +
                ", clientId = " + client.getId() +
                ", city = " + getCity() +
                ", profession = " + getProfession() +
                '}';
    }
}
