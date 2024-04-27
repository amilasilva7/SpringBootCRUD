package com.example.demo.CustomExceptions;

public class CityExistsInCountryException extends RuntimeException {
    public CityExistsInCountryException(String message) {
        super(message);
    }
}

