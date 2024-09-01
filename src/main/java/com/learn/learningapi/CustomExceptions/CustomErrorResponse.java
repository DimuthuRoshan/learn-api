package com.learn.learningapi.CustomExceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomErrorResponse {
    private String errorCode;
    private String message;
    private String timestamp;
    private String detailMessage;

    public String getDetailMessage ( ) {
        return detailMessage;
    }

    public void setDetailMessage ( String detailMessage ) {
        this.detailMessage = detailMessage;
    }

    public String getErrorCode ( ) {
        return errorCode;
    }

    public void setErrorCode ( String errorCode ) {
        this.errorCode = errorCode;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

    public String getTimestamp ( ) {
        return timestamp;
    }

    public void setTimestamp ( String timestamp ) {
        this.timestamp = timestamp;
    }

    public CustomErrorResponse( String errorCode, String message, String detailMessage) {
        this.errorCode = errorCode;
        this.message = message;
        this.detailMessage = detailMessage;
        this.timestamp = LocalDateTime.now().format( DateTimeFormatter.ISO_DATE_TIME);
    }
}
