package ru.sfedu.lab4.set.model;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Entity(name = "Client")
@Table(name = "lab4_set_client", schema = "public", catalog="postgres")
@Root
public class Client extends Person{
    @Element
    @CsvBindByPosition(position = 8)
    private String password;
    
    @Element
    @CsvBindByPosition(position = 9)
    private String address;

    @ElementCollection
    @CollectionTable(name="lab4_set_resume", joinColumns = @JoinColumn(name = "id_client"))
    //private Set<Resume> resumes = new HashSet<Resume>();
    private Set<Resume> resumes;

    public Set<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(Set<Resume> resumes) {
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
