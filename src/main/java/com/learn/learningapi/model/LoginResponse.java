package com.learn.learningapi.model;

public class LoginResponse {
    public  String loginToken = null;

    public String getLoginToken ( ) {
        return loginToken;
    }

    public void setLoginToken ( String loginToken ) {
        this.loginToken = loginToken;
    }
}
