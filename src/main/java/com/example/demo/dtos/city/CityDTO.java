package com.example.demo.dtos.city;

import com.example.demo.dtos.country.CountryDTO;
import com.example.demo.models.City;

public class CityDTO {
    private String city;
    private int population;
    private boolean isCapital;
    private CountryDTO country;

    public CityDTO(City city) {
        this.city = city.getCity();
        this.population = city.getPopulation();
        this.isCapital = city.getIsCapital();
        this.country = city.getCountry() != null ? new CountryDTO(city.getCountry()) : null;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
}
