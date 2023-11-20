package com.resasncf.ResaSncf.UseCase.Exception;

import org.springframework.http.HttpStatus;

public class MaintenanceTypeException extends CustomeException{
    public MaintenanceTypeException(Long id) {
        super("Maintenance Type with id " + id + " not found", HttpStatus.NOT_FOUND, "CAR_NOT_FOUND");
    } 
}
