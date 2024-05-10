package ru.sfedu.lab4.list.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Company {
    @Element
    @CsvBindByPosition(position = 0)
    private int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    private String title;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String description;
    
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
    
    @Override
    public String toString(){
        return "Company{" +
                "id = " + getId()+
                ", title = " + getTitle()+
                '}';
    }
}
