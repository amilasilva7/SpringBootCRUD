package com.example.demo.dtos.country;

import com.example.demo.dtos.continent.ContinentDTO;
import com.example.demo.models.Country;

public class CountryResponseDTO {

    private String country;
    private String headOfState;
    private ContinentDTO continent;

    public CountryResponseDTO(Country country) {
        this.country = country.getCountry();
        this.headOfState = country.getHeadOfState();
        this.continent = country.getContinent() != null ? new ContinentDTO(country.getContinent()) : null;
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

    public ContinentDTO getContinent() {
        return continent;
    }

    public void setContinent(ContinentDTO continent) {
        this.continent = continent;
    }
}
