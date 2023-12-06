/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author mike
 */
public class Employee extends Person {
    @CsvBindByPosition(position = 6)
    String companyId;
    @CsvBindByPosition(position = 7)
    String startWorkDate;
    @CsvBindByPosition(position = 8)
    String salary;
    @CsvBindByPosition(position = 9)
    String position;
    @CsvBindByPosition(position = 10)
    String isWorking;
    
    public Employee(){}

    public String getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(String isWorking) {
        this.isWorking = isWorking;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    
    public String getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(String startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

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
    
    @Override
    public String toString(){
        return "Employee{" +
                "id = " + getId() +
                ", companyId = " + getCompanyId()+
                ", fio =" + getSurname() + " " + getName() + " " + getMiddleName() +
                ", startWorkDate = " + getStartWorkDate() +
                ", salary = " + getSalary() +
                ", position = " + getPosition()+
                ", isWorking = " + getIsWorking()+
                '}';
    }
}
