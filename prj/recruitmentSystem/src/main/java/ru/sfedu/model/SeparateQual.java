package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class SeparateQual {
    @Element
    @CsvBindByPosition(position = 0)
    String id;
    
    @Element
    @CsvBindByPosition(position = 1)
    String companyId;
    
    @Element
    @CsvBindByPosition(position = 2)
    String employeeId;
    
    @Element
    @CsvBindByPosition(position = 3)
    String quality;
    
    @Element(required = false)
    @CsvBindByPosition(position = 4)
    String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
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
                ", companyId = " + getCompanyId()+
                ", employeeId = " + getEmployeeId()+
                ", quality = " + getQuality()+
                '}';
    }
}
