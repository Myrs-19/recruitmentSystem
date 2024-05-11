package ru.sfedu.lab4.list.model;

import com.opencsv.bean.*;
import jakarta.persistence.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Entity(name="Employee")
@Table(name = "lab4_list_employee", schema = "public", catalog="postgres")
@Embeddable
@Root
public class Employee extends Person {

    @ManyToOne
    @JoinColumn()
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

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
//
//    public int getEmployees_order() {
//        return employees_order;
//    }
//
//    public void setEmployees_order(int employees_order) {
//        this.employees_order = employees_order;
//    }
////
//    public int getEmployees_id() {
//        return employees_id;
//    }
//
//    public void setEmployees_id(int employees_id) {
//        this.employees_id = employees_id;
//    }

    @Override
    public String toString(){
        return "Employee{" +
                //"id = " + getId() +
                ", fi =" + getSurname() + " " + getName() +
                ", salary = " + getSalary() +
                ", position = " + getPosition()+
                ", isWorking = " + getIsWorking()+
                '}';
    }
}
