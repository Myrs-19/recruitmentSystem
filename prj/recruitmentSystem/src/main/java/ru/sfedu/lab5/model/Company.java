package ru.sfedu.lab5.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "lab5_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Vacancy> vacancies;

    @ManyToMany
    @JoinTable(
            name = "lab5_company_separateQual",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "separateQual_id")
    )
    private List<SeparateQual> separateQuals;

    // constructors



    // Getters and setters
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

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public List<SeparateQual> getSeparateQuals() {
        return separateQuals;
    }

    public void setSeparateQuals(List<SeparateQual> separateQuals) {
        this.separateQuals = separateQuals;
    }

    // toString method
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
