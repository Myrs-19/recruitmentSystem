package ru.sfedu.lab2.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
        
@Entity(name = "TestEntity")
@Table(name="test_entity", schema = "public", catalog="postgres")
public class TestEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
   
    @Column(name="name")
    private String name;
   
    @Column(name="description")
    private String description;
   
    @Column(name="dateCreated_field")
    private Date dateCreated;

    @Column(name="check_field")
    private Boolean check;
    
    @Embedded
    private Operation operation;
    
    public TestEntity() {
    
    }
    
    public TestEntity(String name, String description, Date dateCreated, Boolean check, Operation operation) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.check = check;
        this.operation = operation;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
    
    
}
