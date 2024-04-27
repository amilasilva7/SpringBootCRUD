package com.example.demo.dtos;

import com.example.demo.models.City;

public class CityDTO {
    private String city;
    private Long population;
    private boolean isCapital;
    private String country;
    private String headOfState;

    public CityDTO(City city) {
        this.city = city.getCity();
        this.population = Long.valueOf(city.getPopulation());
        this.isCapital = city.getIsCapital();
        this.country = city.getCountry().getCountry();
        this.headOfState = city.getCountry().getHeadOfState();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }
}
