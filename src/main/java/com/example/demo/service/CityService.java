package com.example.demo.service;

import com.example.demo.CustomExceptions.CityAlreadyExistsException;
import com.example.demo.CustomExceptions.CityNotFoundException;
import com.example.demo.dtos.city.CityDTO;
import com.example.demo.dtos.city.CityRequestDTO;
import com.example.demo.dtos.city.CityUpdateRequestDTO;
import com.example.demo.models.City;
import com.example.demo.models.Country;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    CountryService countryService;
    @Autowired
    private CityRepository cityRepository;

    public List<CityDTO> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().map(CityDTO::new).toList();
    }

    public City createCity(CityRequestDTO cityRequestDTO) throws CityAlreadyExistsException {
        if (cityRepository.existsByCity(cityRequestDTO.getCity())) {
            throw new CityAlreadyExistsException("City " + cityRequestDTO.getCity() + " already exists");
        }
        City city = new City(cityRequestDTO.getCity(), false, cityRequestDTO.getPopulation());
        City savedCity = cityRepository.save(city);
        return savedCity;
    }

    public City updateCity(CityUpdateRequestDTO cityUpdateRequestDTO, Long id) throws CityNotFoundException {
        City existingCity = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City with id " + id + " not found"));

        if (cityUpdateRequestDTO.getCountry() != null) {
            if (cityUpdateRequestDTO.getCountry().getId() != null) {
                Optional<Country> country = countryService.isExistCountry(cityUpdateRequestDTO.getCountry().getId());
                if (country.isPresent()) {
                    existingCity.setCountry(country.get());
                    return cityRepository.saveAndFlush(existingCity);
                } else {
                    throw new CityNotFoundException("Country id is not valid.");
                }
            }
        }
        throw new CityNotFoundException("Country field is required.");
    }

    public List<CityDTO> getCitiesByPopulation(Long population) {
        List<City> cities = cityRepository.findByPopulationGreaterThan(population);
        if (cities != null) {
            return cities.stream().map(CityDTO::new).toList();
        }
        return new ArrayList<>();
    }

    public List<CityDTO> searchCityByCityName(String cityName) {
        List<City> cities = cityRepository.findCitiesByCityContaining(cityName);
        return cities.stream().map(CityDTO::new).toList();
    }

    public Long countByCountryId(Integer id) {
        return cityRepository.countByCountryId(id);
    }
}
