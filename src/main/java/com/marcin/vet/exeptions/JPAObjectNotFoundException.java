package com.marcin.vet.exeptions;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcin.vet.jsoncomponents.serializers.JPAObjectNotFoundExceptionSerializer;

import java.time.LocalDateTime;

@JsonSerialize(using = JPAObjectNotFoundExceptionSerializer.class)
public class JPAObjectNotFoundException extends RuntimeException {

    private LocalDateTime exceptionTime;

    public LocalDateTime getExceptionTime() {
        return this.exceptionTime;
    }

    public JPAObjectNotFoundException(String params, String values) {
        super("Could not found object with params (" + params + ") = (" + values    + ").");
        this.exceptionTime = LocalDateTime.now();
    }
}
