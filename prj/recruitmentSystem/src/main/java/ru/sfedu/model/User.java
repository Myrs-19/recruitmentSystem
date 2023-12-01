/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author mike
 */
public class User extends Person{
    @CsvBindByPosition(position = 6)
    private String password;
    @CsvBindByPosition(position = 7)
    private String phone;
    @CsvBindByPosition(position = 8)
    private String email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public User() {}
    
    @Override
    public String toString(){
        return "User{" +
                "id = " + getId() +
                ", name = " + getName() +
                ", email = " + getEmail()+
                ", phone = " + getPhone() +
                ", address = " + getAddress() +
                '}';
    }
}
