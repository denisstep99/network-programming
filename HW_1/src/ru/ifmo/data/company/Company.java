package ru.ifmo.data.company;

public class Company {
    private int id;
    private String name;
    private String country;
    private int numberOfEmployees;
    private int revenue;
    private String type;

    public Company(int id, String name, String country, int numberOfEmployees, int revenue, String type) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.numberOfEmployees = numberOfEmployees;
        this.revenue = revenue;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
