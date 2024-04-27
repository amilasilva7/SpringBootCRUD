package com.example.demo.repository;

import com.example.demo.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByPopulationGreaterThan(Long population);
    List<City> findByCityContaining(String city);

    boolean existsByCity(String city);
}

