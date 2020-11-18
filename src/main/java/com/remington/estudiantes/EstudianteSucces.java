package com.remington.estudiantes;

import org.springframework.http.HttpStatus;

public class EstudianteSucces {

    private final String errorMessage;

    public EstudianteSucces(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
