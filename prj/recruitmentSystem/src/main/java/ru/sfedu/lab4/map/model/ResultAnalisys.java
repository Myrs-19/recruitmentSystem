package ru.sfedu.lab4.map.model;

public class ResultAnalisys {
    Double result;
    Company company;
    int place;

    public ResultAnalisys(Double result, Company company) {
        setResult(result);
        setCompany(company);
    }
    public ResultAnalisys(Double result, Company company, int place) {
        setResult(result);
        setCompany(company);
        setPlace(place);
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
