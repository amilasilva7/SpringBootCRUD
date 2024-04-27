package com.example.demo.controllers;

import com.example.demo.CustomExceptions.CityAlreadyExistsException;
import com.example.demo.CustomExceptions.CityNotFoundException;
import com.example.demo.CustomExceptions.CountryNotFoundException;
import com.example.demo.dtos.city.CityDTO;
import com.example.demo.dtos.city.CityRequestDTO;
import com.example.demo.dtos.city.CityUpdateRequestDTO;
import com.example.demo.models.City;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public ResponseEntity<CityRequestDTO> createCity(@Valid @RequestBody CityRequestDTO cityRequestDTO) throws CityAlreadyExistsException {
        City savedCity = cityService.createCity(cityRequestDTO);
        return ResponseEntity.ok(new CityRequestDTO(savedCity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> updateCity(@PathVariable Long id, @Valid @RequestBody CityUpdateRequestDTO cityUpdateRequestDTO) throws CityNotFoundException, CityAlreadyExistsException, CountryNotFoundException {
        City savedCity = cityService.updateCity(cityUpdateRequestDTO, id);
        return ResponseEntity.ok(new CityDTO(savedCity));
    }

    @GetMapping("/searchPop")
    public List<CityDTO> getCitiesByPopulation(@RequestParam Long population) {
        return cityService.getCitiesByPopulation(population);
    }

    @GetMapping("/searchCity")
    public List<CityDTO> getCitiesByCity(@RequestParam String city) {
        return cityService.searchCityByCityName(city);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}







