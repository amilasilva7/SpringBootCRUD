package com.example.demo.dtos.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

public class CityUpdateRequestDTO {

    @Valid
    @NotNull
    @NotEmpty
    @NotBlank
    private String city;

    private int population;
    @JsonProperty("capital")
    private boolean isCapital;
    @Valid
    @NotNull
    @JsonProperty("country")
    private CityRequestCountryDTO country;

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

    @Nullable
    public CityRequestCountryDTO getCountry() {
        return country;
    }

    public void setCountry(@Nullable CityRequestCountryDTO country) {
        this.country = country;
    }
}
