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
public class Employee extends Person {
    @Element
    @CsvBindByPosition(position = 8)
    int companyId;
    
    @Element
    @CsvBindByPosition(position = 9)
    int salary;
    
    @Element
    @CsvBindByPosition(position = 10)
    String position;
    
    @Element
    @CsvBindByPosition(position = 11)
    boolean isWorking;
    
    public Employee(){}

    public boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
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
                ", fi =" + getSurname() + " " + getName() +
                ", salary = " + getSalary() +
                ", position = " + getPosition()+
                ", isWorking = " + getIsWorking()+
                '}';
    }
}
