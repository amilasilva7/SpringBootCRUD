package com.example.demo.controllers;

import com.example.demo.CustomExceptions.CityAlreadyExistsException;
import com.example.demo.CustomExceptions.CityExistsInCountryConstraintException;
import com.example.demo.CustomExceptions.CityExistsInCountryException;
import com.example.demo.dtos.country.CountryResponseDTO;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponseDTO>> getAllCountries() {
        return countryService.getAllCountries();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Integer id) throws CityExistsInCountryException, CityAlreadyExistsException, CityExistsInCountryConstraintException {
        return countryService.deleteCountryById(id);
    }

}

