package ru.sfedu.lab5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lab5_employee")
public class Employee extends Person {
    private String salary;
    private String position;
    private String isWorking;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Getters and Setters
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(String isWorking) {
        this.isWorking = isWorking;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary='" + salary + '\'' +
                ", position='" + position + '\'' +
                ", isWorking='" + isWorking + '\'' +
                ", company=" + company +
                "} " + super.toString();
    }
}
