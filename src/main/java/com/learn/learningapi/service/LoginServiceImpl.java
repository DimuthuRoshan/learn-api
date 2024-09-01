package com.learn.learningapi.service;

import com.learn.learningapi.CustomExceptions.CommonExceptions;
import com.learn.learningapi.model.LoginRequest;
import com.learn.learningapi.model.LoginResponse;
import com.learn.learningapi.model.User;
import com.learn.learningapi.util.PasswordVerifyUtil;
import com.learn.learningapi.util.UserSession;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

//import static com.learn.learningapi.util.PasswordVerifyUtil.encryptPwd;


@Service
public class LoginServiceImpl implements LoginService {

    private UserSession userSession = new UserSession ();
    private PasswordVerifyUtil passwordVerifyUtil = new PasswordVerifyUtil ();
    @Override
    public LoginResponse userLogin ( LoginRequest loginReq ) {
        LoginResponse loginResponse = new LoginResponse ();

        SecretKey key = null;
        String input = "baeldung";
        try {
             key = passwordVerifyUtil.generateKey(128);
        } catch (NoSuchAlgorithmException e) {
            System.out.println (" e.getMessage ()" );
            throw new RuntimeException ( e );
        }
        IvParameterSpec ivParameterSpec = passwordVerifyUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = null;
        String plainText = null;
        try {
            cipherText = passwordVerifyUtil.encrypt(algorithm, input, key, ivParameterSpec);
            plainText = passwordVerifyUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);
        } catch (Exception e) {
            /**
             * NoSuchAlgorithmException
                    * NoSuchPaddingException
                    * InvalidKeyException
                    * IllegalBlockSizeException
                    * BadPaddingException
                    */
                    System.out.println (" e.getMessage ()" );
            throw new RuntimeException ( e );
        }

        System.out.println ("bbbbbbbbbbbbbbbbbbbbbbb");
        System.out.println (cipherText);
        System.out.println (plainText);

       /* try {
            System.out.println ( encryptPwd("passwordasasaxsc","test12312345xzxzs") );
        } catch (Exception e) {
            *//**
             * NoSuchAlgorithmException
             * NoSuchPaddingException
             * InvalidKeyException
             * IllegalBlockSizeException
             * BadPaddingException
             *//*
            System.out.println (" e.getMessage ()" );
            throw new RuntimeException ( e );
        }*/


        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder ();
        String passwordInDB = "$2a$10$5t59XK9S.YTDFbu6KeQhhebLtwzzrRxzns0Z.l4hY1ojyO9Qo3H9e";
        String userNameInDB = "dimuthu";

        System.out.println ( "=============" );

        byte[] decodedBytes = Base64.getDecoder().decode(loginReq.getPassword ());
        String decodedStr = (new String(decodedBytes, Charset.forName("ISO-8859-1")));
        String decodedString = new String(decodedBytes);

        System.out.println ( "Decode password" );
        System.out.println ( decodedString.toString () );
        System.out.println ( decodedStr );

        if(loginReq.getUserName ().equals (userNameInDB )){
            System.out.println ( "User name equal" );
        }



        if(loginReq.getUserName ().equals (userNameInDB ) && (bCryptPasswordEncoder.matches ( decodedString.toString (),passwordInDB ))){
            passwordVerifyUtil.getPasswordPlainText ( "password" );
            loginResponse.setLoginToken ( userSession.createUserSession (loginReq) );
        }else {
            System.out.println ( "User name wrong" );
        }
        return loginResponse;
    }

    @Override
    public void userCreate ( User user ) throws HttpMessageNotReadableException {
        System.out.println ( "nnnnnn" );
    }
}
