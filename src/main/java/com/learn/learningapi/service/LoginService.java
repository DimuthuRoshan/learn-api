package com.learn.learningapi.service;

import com.learn.learningapi.model.LoginRequest;
import com.learn.learningapi.model.LoginResponse;
import com.learn.learningapi.model.User;


public interface LoginService {
    LoginResponse userLogin ( LoginRequest loginReq );
    void userCreate( User user );
}