package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;

public class Person {
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String surname;
    @CsvBindByPosition(position = 3)
    private String middleName;
    @CsvBindByPosition(position = 4)
    private String age;
    @CsvBindByPosition(position = 5)
    private String birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Person() {}
    
    @Override
    public String toString(){
        return "Person{" +
                "id = " + getId() +
                ", fio = " + getSurname() + " " + getName() + " " + getMiddleName() +
                ", age = " + getAge() +
                ", birthday = " + getBirthday() +
                '}';
    }
}
