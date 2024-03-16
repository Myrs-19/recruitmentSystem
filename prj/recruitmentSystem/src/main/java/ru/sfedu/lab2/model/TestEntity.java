package ru.sfedu.lab2.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class TestEntity implements Serializable{
    @Id
    private long id;
   
    @Column(name="name")
    private String name;
   
    @Column(name="description")
    private String description;
   
    @Column(name="dateCreated")
    private Date dateCreated;

    @Column(name="check")
    private Boolean check;
    
    public TestEntity() {
    
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
    
    
}
