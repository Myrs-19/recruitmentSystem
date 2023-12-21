package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class SeparateQual {
    @Element
    @CsvBindByPosition(position = 0)
    int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    int companyId;
    
    @Element
    @CsvBindByPosition(position = 2)
    int employeeId;
    
    @Element
    @CsvBindByPosition(position = 3)
    int quality;
    
    @Element(required = false)
    @CsvBindByPosition(position = 4)
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
                ", companyId = " + getCompanyId()+
                ", employeeId = " + getEmployeeId()+
                ", quality = " + getQuality()+
                '}';
    }
}
