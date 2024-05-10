package ru.sfedu.lab4.list.model;

import com.opencsv.bean.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Entity(name = "Employee")
@Table(name = "lab4_list_employee", schema = "public", catalog="postgres")
@Root
public class Employee extends Person {
    @Element
    @CsvCustomBindByPosition(position = 8, converter = CompanyCsvConverter.class)
    private Company company;
    
    @Element
    @CsvBindByPosition(position = 9)
    private int salary;
    
    @Element
    @CsvBindByPosition(position = 10)
    private String position;
    
    @Element
    @CsvBindByPosition(position = 11)
    private boolean isWorking;
    
    public Employee(){}

    public boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
                ", companyId = " + company.getId()+
                ", fi =" + getSurname() + " " + getName() +
                ", salary = " + getSalary() +
                ", position = " + getPosition()+
                ", isWorking = " + getIsWorking()+
                '}';
    }
}
