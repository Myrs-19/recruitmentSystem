package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Person {
    @Element
    @CsvBindByPosition(position = 0)
    private String id;
    
    @Element
    @CsvBindByPosition(position = 1)
    private String name;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String surname;
    
    @Element
    @CsvBindByPosition(position = 3)
    private String middleName;
    
    @Element
    @CsvBindByPosition(position = 4)
    private String age;
    
    @Element
    @CsvBindByPosition(position = 5)
    private String birthday;

    private TypePerson typePerson;

    public TypePerson getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(TypePerson typePerson) {
        this.typePerson = typePerson;
    }
        
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
