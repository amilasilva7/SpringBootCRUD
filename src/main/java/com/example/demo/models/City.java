package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String city;
    private Boolean isCapital;
    private Integer population;
    @ManyToOne
    @JoinColumn(name = "country_fk")
    private Country country;


    public City(String city, Boolean isCapital, Integer population) {
        this.city = city;
        this.isCapital = isCapital;
        this.population = population;
    }

    public City() {

    }

    public City(Integer id, String city, Boolean isCapital, Integer population, Country country) {
        this.id = id;
        this.city = city;
        this.isCapital = isCapital;
        this.population = population;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getIsCapital() {
        return isCapital;
    }

    public void setIsCapital(Boolean isCapital) {
        this.isCapital = isCapital;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
