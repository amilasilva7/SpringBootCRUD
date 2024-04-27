package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.models.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<CityDTO> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().map(CityDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<CityDTO> createCity(@RequestBody City city) throws CityAlreadyExistsException {
        if (city.getId() != null || city.getCountry() != null) {
            throw new CityAlreadyExistsException("Invalid city object for creation");
        }
        if (cityRepository.existsByCity(city.getCity())) {
            throw new CityAlreadyExistsException("City " + city.getCity() + " already exists");
        }
        City savedCity = cityRepository.save(city);
        return ResponseEntity.ok(new CityDTO(savedCity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> updateCity(@PathVariable Long id, @RequestBody City city) throws CityNotFoundException, CityAlreadyExistsException {
        if (city.getId() != null || (city.getCountry() != null && city.getCountry().getId() == null)) {
            throw new CityAlreadyExistsException("Invalid city object for update");
        }
        City existingCity = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City with id " + id + " not found"));
        existingCity.setCity(city.getCity());
        existingCity.setIsCapital(city.getIsCapital());
        existingCity.setPopulation(city.getPopulation());
        City savedCity = cityRepository.save(existingCity);
        return ResponseEntity.ok(new CityDTO(savedCity));
    }

    @GetMapping("/searchPop")
    public List<CityDTO> getCitiesByPopulation(@RequestParam Long population) {
        List<City> cities = cityRepository.findByPopulationGreaterThan(population);
        return cities.stream().map(CityDTO::new).toList();
    }

    @GetMapping("/searchCity")
    public List<CityDTO> getCitiesByCity(@RequestParam String city) {
        List<City> cities = cityRepository.findByCityContaining(city);
        return cities.stream().map(CityDTO::new).toList();
    }
}

class CityAlreadyExistsException extends Exception {
    public CityAlreadyExistsException(String message) {
        super(message);
    }
}

class CityNotFoundException extends Exception {
    public CityNotFoundException(String message) {
        super(message);
    }
}

