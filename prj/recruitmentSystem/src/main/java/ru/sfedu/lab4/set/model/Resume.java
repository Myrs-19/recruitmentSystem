package ru.sfedu.lab4.set.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import org.simpleframework.xml.*;
import org.simpleframework.xml.Root;

@Embeddable
@Table(name = "lab4_set_resume", schema = "public", catalog="postgres")
@Root
public class Resume {
    @Element
    @CsvBindByPosition(position = 0)
    private int id;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String profession;
    
    @Element
    @CsvBindByPosition(position = 3)
    private String city;
    
    @Element(required = false)
    @CsvBindByPosition(position = 4)
    private String skills;
    
    @Element(required = false)
    @CsvBindByPosition(position = 5)
    private String education;
    
    @Element(required = false)
    @CsvBindByPosition(position = 6)
    private String experience;
    
    @Element(required = false)
    @CsvBindByPosition(position = 8)
    private boolean sex;
    
    @Element(required = false)
    @CsvBindByPosition(position = 10)
    private boolean workPermit;
    
    @Element(required = false)
    @CsvBindByPosition(position = 11)
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
                ", profession = " + getSkills()+
                ", profession = " + getEducation()+
                ", profession = " + getWorkPermit()+
                '}';
    }
}
