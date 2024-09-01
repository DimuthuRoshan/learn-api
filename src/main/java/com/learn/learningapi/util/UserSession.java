package com.learn.learningapi.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.learn.learningapi.model.LoginRequest;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class UserSession {

    private Algorithm algorithm = Algorithm.HMAC256 ( "learning-api" );
    private JWTVerifier verifier = JWT.require ( algorithm ).withIssuer ( "learning-api" ).build ( );
    private String jwtToken = null;

    public String createUserSession ( LoginRequest loginReq ) {
        jwtToken = JWT.create ( )
                .withIssuer ( "learning-api" )
                .withSubject ( "user login" )
                .withClaim ( "userId" , loginReq.getUserName ( ) )
                .withIssuedAt ( new Date ( System.currentTimeMillis ( ) + TimeUnit.MINUTES.toMillis ( 5 ) ) )
                .withJWTId ( UUID.randomUUID ( ).toString ( ) )
                .sign ( algorithm );

        // Insert jwtToken in DB

        return jwtToken;
    }
}
