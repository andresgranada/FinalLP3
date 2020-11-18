package com.remington.estudiantes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EstudianteErrorHandler {

    @ExceptionHandler(EstudianteException.class)
    public ResponseEntity<ErrorResponse> handlerEstudianteException(EstudianteException ex) {

        return ResponseEntity.status(ex.getStatus()).body(new ErrorResponse(ex.getErrorMessage()));
    }
}
