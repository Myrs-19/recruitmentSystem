package ru.sfedu.lab5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lab5_vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String specialization;
    private boolean online;
    private String skills;
    private String salary;
    private String city;
    private String address;
    private String experience;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isOnline() {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "title='" + title + '\'' +
                ", specialization='" + specialization + '\'' +
                ", online=" + online +
                ", skills='" + skills + '\'' +
                ", salary='" + salary + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", experience='" + experience + '\'' +
                ", company=" + company +
                '}';
    }
}
