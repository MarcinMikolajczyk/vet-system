package com.marcin.vet.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JPAObjectNotFoundAdvice {

    @ExceptionHandler(JPAObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JPAObjectNotFoundException JPAObjectNotFoundHandler(JPAObjectNotFoundException e) {
        return e;
    }
}
