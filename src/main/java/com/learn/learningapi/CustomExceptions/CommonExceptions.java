package com.learn.learningapi.CustomExceptions;

import org.apache.coyote.BadRequestException;

public class CommonExceptions extends RuntimeException {
    private final String errorCode;
    public CommonExceptions(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return errorCode;
    }

}
