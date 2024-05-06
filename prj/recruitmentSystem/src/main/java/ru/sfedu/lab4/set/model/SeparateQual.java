package ru.sfedu.lab4.set.model;

import com.opencsv.bean.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class SeparateQual {
    @Element
    @CsvBindByPosition(position = 0)
    private int id;
    
    @Element
    @CsvCustomBindByPosition(position = 1, converter = CompanyCsvConverter.class)
    private Company company;

    @Element
    @CsvBindByPosition(position = 2)
    private int quality;
    
    @Element(required = false)
    @CsvBindByPosition(position = 3)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public SeparateQual(){}
    
    @Override
    public String toString(){
        return "SeparateQual{" +
                "id = " + getId() +
                ", companyId = " + getCompany().getId()+
                ", quality = " + getQuality()+
                '}';
    }
}
