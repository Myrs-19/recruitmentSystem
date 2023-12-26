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
    private int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    private String profession;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String city;
    
    @Element(required = false)
    @CsvBindByPosition(position = 3)
    private String skills;
    
    @Element(required = false)
    @CsvBindByPosition(position = 4)
    private String education;
    
    @Element(required = false)
    @CsvBindByPosition(position = 5)
    private String experience;
    
    @Element(required = false)
    @CsvBindByPosition(position = 6)
    private boolean sex;
    
    @Element(required = false)
    @CsvBindByPosition(position = 7)
    private boolean workPermit;
    
    @Element(required = false)
    @CsvBindByPosition(position = 8)
    private String citizenship;
    
    public Resume(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", city = " + getCity() +
                ", profession = " + getProfession() +
                '}';
    }
}
