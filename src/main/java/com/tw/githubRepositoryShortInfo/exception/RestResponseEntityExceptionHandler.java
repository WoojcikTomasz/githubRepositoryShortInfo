package com.tw.githubRepositoryShortInfo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RepositoryNotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(RepositoryNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(value = ServiceUnavailableException.class)
    protected ResponseEntity<Object> handleServiceUnavailableException(ServiceUnavailableException e) {
        return new ResponseEntity<>(e.getMessage(), SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = ValidationException.class)
    protected ResponseEntity<Object> handleServiceUnavailableException(ValidationException e) {
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleGlobalException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), INTERNAL_SERVER_ERROR);
    }
}