package com.resasncf.ResaSncf.UseCase.Exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomeException extends RuntimeException {
    private HttpStatus httpStatus;
    private String erroCode;

public CustomeException(String message, HttpStatus httpStatus,String errorCode) {
super(message);
this.httpStatus = httpStatus;
this.erroCode = errorCode;    
}

}
