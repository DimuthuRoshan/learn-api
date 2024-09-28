package com.learn.learningapi.model;

public class Utils {
    private static final String loggingMessage = "Request received by %s with request object %s ";

    public String getLoggingMessage(String className,String requestData){
        return String.format(loggingMessage,className,requestData);
    }
}
