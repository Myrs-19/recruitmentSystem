package ru.sfedu.lab4.map.model;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import org.simpleframework.xml.Element;

import java.util.HashMap;
import java.util.Map;

@Entity(name = "Company")
@Table(name = "lab4_map_company", schema = "public", catalog="postgres")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Element
    @CsvBindByPosition(position = 0)
    private int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    private String title;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<String, Employee> employees = new HashMap<>();

    @ElementCollection
    @CollectionTable(name="lab4_map_vacancy")
    @MapKeyColumn(name="id_company")
    private Map<String, Vacancy> vacancies;

    @ElementCollection
    @CollectionTable(name="lab4_map_separateQual")
    @MapKeyColumn(name="id_company")
    private Map<String, SeparateQual> separateQuals;

    public Company(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Map<String, Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Map<String, SeparateQual> getSeparateQuals() {
        return separateQuals;
    }

    public void setSeparateQuals(Map<String, SeparateQual> separateQuals) {
        this.separateQuals = separateQuals;
    }
    
    @Override
    public String toString(){
        return "Company{" +
                "id = " + getId()+
                ", title = " + getTitle()+
                '}';
    }
}
