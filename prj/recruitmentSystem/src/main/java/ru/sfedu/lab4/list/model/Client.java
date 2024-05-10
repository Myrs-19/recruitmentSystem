package ru.sfedu.lab4.list.model;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Entity(name = "Client")
@Table(name = "lab4_list_client", schema = "public", catalog="postgres")
@Root
public class Client extends Person{
    @Element
    @CsvBindByPosition(position = 8)
    private String password;

    @Element
    @CsvBindByPosition(position = 9)
    private String address;

    @ElementCollection
    @CollectionTable(name="lab4_list_resume", joinColumns = @JoinColumn(name = "id_client"))
    @OrderColumn
    private List<Resume> resumes;

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
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
