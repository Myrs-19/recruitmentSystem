/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.model;

import com.opencsv.bean.*;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Company {
    @Element
    @CsvBindByPosition(position = 0)
    int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    String title;
    
    @Element(required = false)
    @CsvBindByPosition(position = 2)
    String description;
    
    @ElementList
    @CsvBindAndSplitByName(elementType = Vacancy.class)
    List<Vacancy> vacancies;
    
    @ElementList
    @CsvBindAndSplitByName(elementType = SeparateQual.class)
    List<SeparateQual> separateQual;
    
    @ElementList
    @CsvBindAndSplitByName(elementType = Employee.class)
    List<Employee> employees;

    public Company(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public List<SeparateQual> getSeparateQual() {
        return separateQual;
    }

    public void setSeparateQual(List<SeparateQual> separateQual) {
        this.separateQual = separateQual;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    @Override
    public String toString(){
        return "Company{" +
                "id = " + getId() +
                ", title = " + getTitle()+
                '}';
    }
}
