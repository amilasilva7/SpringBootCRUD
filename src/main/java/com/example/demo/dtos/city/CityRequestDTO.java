package com.example.demo.dtos.city;

import com.example.demo.models.City;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CityRequestDTO {

    @Valid
    @NotNull
    @NotBlank
    @NotEmpty
    private String city;
    @Valid
    @NotNull(message = "Value cannot be null")
    private Integer population;

    @Valid
    @NotNull
    @JsonProperty("capital")
    private boolean isCapital;

    public CityRequestDTO(City city) {
        this.city = city.getCity();
        this.population = city.getPopulation();
        this.isCapital = city.getIsCapital();
    }

    public CityRequestDTO() {
    }

    @Override
    public String toString() {
        return "CityRequestDTO{" +
                "city='" + city + '\'' +
                ", population=" + population +
                ", isCapital=" + isCapital +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }
}
