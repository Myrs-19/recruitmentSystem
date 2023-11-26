package ru.sfedu.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Person {
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private int age;
    @CsvBindByPosition(position = 3)
    private String phone;
    @CsvBindByPosition(position = 4)
    private String address;

    public Person(int id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString(){
        return "Person{" +
                "name=" + name +
                ", age =" + age +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }
}
