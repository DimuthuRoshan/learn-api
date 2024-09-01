package com.learn.learningapi.config;

import com.learn.learningapi.CustomExceptions.CommonExceptions;
import com.learn.learningapi.CustomExceptions.CustomErrorResponse;
import com.learn.learningapi.util.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler( HttpMessageNotReadableException.class)
    public ResponseEntity <CustomErrorResponse> handleInvalidRequestException( HttpMessageNotReadableException ex) {
        CustomErrorResponse response = new CustomErrorResponse (ErrorCodeEnum.ERROR_0001.httpStatusCode ,
                ErrorCodeEnum.ERROR_0001.label, ex.getLocalizedMessage ( ) );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CommonExceptions.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorResponse> handleBookNotFoundException(CommonExceptions ex) {
        CustomErrorResponse response = new CustomErrorResponse (ex.getErrorCode(), ex.getMessage(), ex.getMessage ());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
