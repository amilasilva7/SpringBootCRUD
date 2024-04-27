package com.example.demo.dtos.country;

import com.example.demo.models.Country;

public class CountryDTO {
    private String country;
    private String headOfState;

    public CountryDTO(Country country) {
        this.country = country.getCountry();
        this.headOfState = country.getHeadOfState();
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
