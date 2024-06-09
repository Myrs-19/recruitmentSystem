package ru.sfedu.lab5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab5_client")
public class Client extends Person {
    private String password;
    private String address;

    // Getters and Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "password='" + password + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}
