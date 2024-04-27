package com.example.demo.service;

import com.example.demo.CustomExceptions.CityAlreadyExistsException;
import com.example.demo.CustomExceptions.CityExistsInCountryConstraintException;
import com.example.demo.dtos.country.CountryResponseDTO;
import com.example.demo.models.Country;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CityRepository cityRepository;


    public Optional<Country> isExistCountry(Integer id) {
        return countryRepository.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<CountryResponseDTO>> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        List<CountryResponseDTO> countryDTOs = countries.stream().map(CountryResponseDTO::new).toList();
        return ResponseEntity.ok(countryDTOs);
    }

    public ResponseEntity<Void> deleteCountryById(Integer id) throws CityAlreadyExistsException, CityExistsInCountryConstraintException {
        if (!countryRepository.existsById(id)) {
            throw new CityAlreadyExistsException("Country " + id + " doesn't exist.");
        }
        Optional<Country> country = countryRepository.findById(id);
        Long associatedCitiesCount = cityRepository.countByCountryId(id);
        if (associatedCitiesCount > 0) {
            throw new CityExistsInCountryConstraintException(country.get());
        }
        countryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
