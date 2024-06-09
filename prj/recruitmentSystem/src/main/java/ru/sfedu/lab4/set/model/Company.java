package ru.sfedu.lab4.set.model;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import org.simpleframework.xml.Element;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Company")
@Table(name = "lab4_set_company", schema = "public", catalog="postgres")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    private String title;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();

    @ElementCollection
    @CollectionTable(name="lab4_set_vacancy")
    @MapKeyColumn(name="id_company")
    private Set<Vacancy> vacancies;

    @ElementCollection
    @CollectionTable(name="lab4_set_separateQual")
    @MapKeyColumn(name="id_company")
    private Set<SeparateQual> separateQuals;

    public Company(){}

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Set<SeparateQual> getSeparateQuals() {
        return separateQuals;
    }

    public void setSeparateQuals(Set<SeparateQual> separateQuals) {
        this.separateQuals = separateQuals;
    }

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
    
    @Override
    public String toString(){
        return "Company{" +
                "id = " + getId()+
                ", title = " + getTitle()+
                '}';
    }
}
