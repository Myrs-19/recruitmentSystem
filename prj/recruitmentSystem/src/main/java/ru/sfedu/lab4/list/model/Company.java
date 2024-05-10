package ru.sfedu.lab4.list.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;


@Entity(name = "Company")
@Table(name = "lab4_list_company", schema = "public", catalog="postgres")
@Root
public class Company {
    @Id
    @Element
    @CsvBindByPosition(position = 0)
    private int id;
    
    @Element
    @CsvBindByPosition(position = 1)
    private String title;
    
    @Element
    @CsvBindByPosition(position = 2)
    private String description;

    @ElementCollection
    //@CollectionTable(name="lab4_list_employee", joinColumns = @JoinColumn(name = "id_company"))
    @CollectionTable(name="lab4_list_employee")
    @OrderColumn
    private List<Employee> employees;

    @ElementCollection
    //@CollectionTable(name="lab4_list_vacancy", joinColumns = @JoinColumn(name = "id_company"))
    @CollectionTable(name="lab4_list_vacancy")
    @OrderColumn
    private List<Vacancy> vacancies;

    @ElementCollection
    //@CollectionTable(name="lab4_list_separateQual", joinColumns = @JoinColumn(name = "id_company"))
    @CollectionTable(name="lab4_list_separateQual")
    @OrderColumn
    private List<SeparateQual> separateQuals;
    
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
    
    @Override
    public String toString(){
        return "Company{" +
                "id = " + getId()+
                ", title = " + getTitle()+
                '}';
    }

    public List<SeparateQual> getSeparateQuals() {
        return separateQuals;
    }

    public void setSeparateQuals(List<SeparateQual> separateQuals) {
        this.separateQuals = separateQuals;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
