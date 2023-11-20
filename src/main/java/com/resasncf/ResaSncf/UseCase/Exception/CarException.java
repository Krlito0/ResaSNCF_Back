package com.resasncf.ResaSncf.UseCase.Exception;

import org.springframework.http.HttpStatus;

public class CarException extends CustomeException{
       public CarException(Long id) {
        super("Car with id " + id + " not found", HttpStatus.NOT_FOUND, "CAR_NOT_FOUND");
    } 
}