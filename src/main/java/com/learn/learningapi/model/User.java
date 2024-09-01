package com.learn.learningapi.model;


import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "Can not be blank")
    public String userName;
    public String password;
    public String emailId;
    public boolean userStatus;

    public String getUserName ( ) {
        return userName;
    }

    public void setUserName ( String userName ) {
        this.userName = userName;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getEmailId ( ) {
        return emailId;
    }

    public void setEmailId ( String emailId ) {
        this.emailId = emailId;
    }

    public boolean isUserStatus ( ) {
        return userStatus;
    }

    public void setUserStatus ( boolean userStatus ) {
        this.userStatus = userStatus;
    }
}
