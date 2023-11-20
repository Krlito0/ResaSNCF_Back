package com.resasncf.ResaSncf.UseCase.Exception;

import org.springframework.http.HttpStatus;

public class OperationException extends CustomeException{
    public OperationException(Long id) {
        super("Operation with id " + id + " not found", HttpStatus.NOT_FOUND, "CAR_NOT_FOUND");
    } 
}
