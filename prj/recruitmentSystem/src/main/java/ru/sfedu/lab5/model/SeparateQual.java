package ru.sfedu.lab5.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lab5_separatequal")
public class SeparateQual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quality;
    private String description;

    @ManyToMany(mappedBy = "separateQuals")
    private List<Company> companies;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "SeparateQual{" +
                "quality=" + quality +
                ", description='" + description + '\'' +
                '}';
    }
}
