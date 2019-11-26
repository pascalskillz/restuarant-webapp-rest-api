package com.monmouthvalley.tandoor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    //catch not found exception
    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleNotFoundException(GenericNotFoundException exc){

        GenericErrorResponse errorResponse = new GenericErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    //Catch all MenuItem exception
    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleAllMenuItemException(RuntimeException exc){

        GenericErrorResponse errorResponse = new GenericErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
