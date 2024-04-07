package ru.sfedu.lab3.str2.model;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Transient;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Root
public class Person {
    @Id
    @GeneratedValue(generator = "uuid")
    @Element
    @CsvBindByPosition(position = 0)
    private int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    private String name;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String surname;
    
    @Element(required = false)
    @CsvBindByPosition(position = 3)
    private String middleName;
    
    @Element
    @CsvBindByPosition(position = 4)
    private int age;
    
    @Element(required = false)
    @CsvBindByPosition(position = 5)
    private String birthday;
    
    @Element(required = false)
    @CsvBindByPosition(position = 6)
    private String phone;
    
    @Element(required = false)
    @CsvBindByPosition(position = 7)
    private String email;

    //@Transient - аннотация указывает, 
    //что поле не используется в таблице
    @Transient
    private TypePerson typePerson;

    public TypePerson getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(TypePerson typePerson) {
        this.typePerson = typePerson;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
    
    public Person() {}
    
    @Override
    public String toString(){
        return "Person{" +
                "id = " + getId() +
                ", fi = " + getSurname() + " " + getName() +
                ", age = " + getAge() +
                '}';
    }
}
