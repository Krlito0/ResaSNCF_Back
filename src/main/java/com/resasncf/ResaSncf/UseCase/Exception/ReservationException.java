package com.resasncf.ResaSncf.UseCase.Exception;

import org.springframework.http.HttpStatus;

public class ReservationException extends CustomeException{
    public ReservationException(Long id) {
        super("Reservation with id " + id + " not found", HttpStatus.NOT_FOUND, "CAR_NOT_FOUND");
    } 
}
