package com.remington.estudiantes;

import org.springframework.http.HttpStatus;

public class EstudianteException extends RuntimeException {
    private final HttpStatus status;
    private final String errorMessage;

    public EstudianteException(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
