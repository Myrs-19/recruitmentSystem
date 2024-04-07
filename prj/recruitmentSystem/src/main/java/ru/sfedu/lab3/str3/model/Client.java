package ru.sfedu.lab3.str3.model;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Entity(name = "Client")
@DiscriminatorValue("client")
@Root
public class Client extends Person{
    @Element
    @CsvBindByPosition(position = 8)
    private String password;
    
    @Element
    @CsvBindByPosition(position = 9)
    private String address;

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
