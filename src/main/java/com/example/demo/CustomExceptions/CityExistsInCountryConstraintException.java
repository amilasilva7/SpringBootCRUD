package com.example.demo.CustomExceptions;

import com.example.demo.models.Country;

import java.sql.SQLIntegrityConstraintViolationException;

public class CityExistsInCountryConstraintException extends SQLIntegrityConstraintViolationException {
    public CityExistsInCountryConstraintException(Country country) {
        super("Country " + country.getCountry() + " cannot be deleted. There are associated cities");
    }
}
