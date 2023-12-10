/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Company {
    @Element
    @CsvBindByPosition(position = 0)
    String id;
    
    @Element
    @CsvBindByPosition(position = 1)
    String userId;
    
    @Element
    @CsvBindByPosition(position = 2)
    String title;
    
    @Element
    @CsvBindByPosition(position = 3)
    String description;
    
    public Company(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    
    @Override
    public String toString(){
        return "Company{" +
                "id = " + getId() +
                ", userId = " + getUserId() +
                ", title = " + getTitle()+
                '}';
    }
}
