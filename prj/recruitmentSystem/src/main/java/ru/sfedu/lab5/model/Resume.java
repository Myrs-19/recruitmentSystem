package ru.sfedu.lab5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lab5_resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profession;
    private String city;
    private String skills;
    private String education;
    private String experience;
    private String sex;
    private boolean workPermit;
    private String citizenship;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isWorkPermit() {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "profession='" + profession + '\'' +
                ", city='" + city + '\'' +
                ", skills='" + skills + '\'' +
                ", education='" + education + '\'' +
                ", experience='" + experience + '\'' +
                ", sex='" + sex + '\'' +
                ", workPermit=" + workPermit +
                ", citizenship='" + citizenship + '\'' +
                ", client=" + client +
                '}';
    }
}
