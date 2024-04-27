package com.example.demo.repository;


import com.example.demo.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByPopulationGreaterThan(Long population);

    @Query(value = "SELECT * FROM city WHERE city LIKE %?1%", nativeQuery = true)
    List<City> findCitiesByCityContaining(String city);

    boolean existsByCity(String city);

    Long countByCountryId(Integer id);
}

