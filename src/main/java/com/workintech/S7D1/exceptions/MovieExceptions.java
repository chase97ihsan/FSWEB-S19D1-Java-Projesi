package com.workintech.S7D1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieExceptions extends RuntimeException{

    private HttpStatus httpStatus;

    public MovieExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
