/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author mike
 */
@Root
public class Resume {
    @Element
    @CsvBindByPosition(position = 0)
    String id;
    
    @Element
    @CsvBindByPosition(position = 1)
    String userId;
    
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
    String sex;
    
    @Element(required = false)
    @CsvBindByPosition(position = 10)
    String workPermit;
    
    @Element(required = false)
    @CsvBindByPosition(position = 11)
    String citizenship;
    
    public Resume(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(String workPermit) {
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
                ", userId = " + getUserId() +
                ", city = " + getCity() +
                ", profession = " + getProfession() +
                '}';
    }
}
