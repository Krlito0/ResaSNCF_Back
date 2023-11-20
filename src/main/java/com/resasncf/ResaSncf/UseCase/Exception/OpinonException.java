package com.resasncf.ResaSncf.UseCase.Exception;

import org.springframework.http.HttpStatus;

public class OpinonException extends CustomeException{
   public OpinonException(Long id) {
        super("Opinion with id " + id + " not found", HttpStatus.NOT_FOUND, "CAR_NOT_FOUND");
    }  
}
