package com.learn.learningapi.controller;

import com.learn.learningapi.CustomExceptions.CommonExceptions;
import com.learn.learningapi.model.LoginRequest;
import com.learn.learningapi.model.LoginResponse;
import com.learn.learningapi.model.User;
import com.learn.learningapi.service.LoginService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping ( "/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger ();

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginResponse userLogin (@RequestBody LoginRequest loginRequest ) {
        logger.info ( "userLogin Request recived" );
        return loginService.userLogin ( loginRequest );
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public void userCreate( @Valid @RequestBody User user ) {

        logger.info ( "userCreate Request recived" );
        loginService.userCreate ( user );


    }

    @GetMapping ( "/greetings")
    public String greetings ( ) {
        return String.format ( "Welcome %s" , "Dimuthu" );
    }
}
