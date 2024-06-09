package ru.sfedu.lab4.map.model;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Map;

@Entity(name = "Client")
@Table(name = "lab4_map_client", schema = "public", catalog="postgres")
@Root
public class Client extends Person{
    @Element
    @CsvBindByPosition(position = 8)
    private String password;

    @Element
    @CsvBindByPosition(position = 9)
    private String address;

    @ElementCollection
    @CollectionTable(name="lab4_map_resume")
    @MapKeyColumn(name="id_client")
    private Map<String, Resume> resumes;

    public Map<String, Resume> getResumes() {
        return resumes;
    }

    public void setResumes(Map<String, Resume> resumes) {
        this.resumes = resumes;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Client() {}
    
    @Override
    public String toString(){
        return "Client{" +
                "id = " + getId() +
                ", name = " + getName() +
                ", email = " + getEmail()+
                ", phone = " + getPhone() +
                ", address = " + getAddress() +
                '}';
    }

}
