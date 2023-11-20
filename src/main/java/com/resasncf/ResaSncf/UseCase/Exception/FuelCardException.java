package com.resasncf.ResaSncf.UseCase.Exception;

import org.springframework.http.HttpStatus;

public class FuelCardException extends CustomeException{
    public FuelCardException(Long id) {
        super("Fuel Card with id " + id + " not found", HttpStatus.NOT_FOUND, "CAR_NOT_FOUND");
    } 
}
