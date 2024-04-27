package com.example.demo.dtos.city;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CityRequestCountryDTO {
    @Valid
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
