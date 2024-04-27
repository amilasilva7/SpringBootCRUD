package com.example.demo.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CityAlreadyExistsException extends Exception {
    public CityAlreadyExistsException(String message) {
        super(message);
    }
}
