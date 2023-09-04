package com.workintech.S7D1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HoolywoodExceptions {

   @ExceptionHandler
    public ResponseEntity<HollywoodErrorResponse> handleException(MovieExceptions movieExceptions) {

        HollywoodErrorResponse hollywoodErrorResponse = new HollywoodErrorResponse(movieExceptions.getHttpStatus().value(),
                movieExceptions.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(hollywoodErrorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<HollywoodErrorResponse> handleException(Exception exception) {

        HollywoodErrorResponse hollywoodErrorResponse = new HollywoodErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(hollywoodErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
