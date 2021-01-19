package com.marcin.vet.exeptions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcin.vet.jsoncomponents.serializers.InvalidOperationExceptionSerializer;

import java.time.LocalDateTime;

@JsonSerialize(using = InvalidOperationExceptionSerializer.class)
public class InvalidOperationException extends RuntimeException {

    private LocalDateTime exceptionTime;

    public LocalDateTime getExceptionTime() {
        return this.exceptionTime;
    }

    public InvalidOperationException(String message) {
        super(message);
        this.exceptionTime = LocalDateTime.now();
    }
}
