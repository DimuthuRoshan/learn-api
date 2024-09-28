package com.learn.learningapi.interceptor;

import com.learn.learningapi.model.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger logger = LogManager.getLogger ();
    private Utils utils = new Utils();
    @Override
    public boolean preHandle (
            HttpServletRequest request , HttpServletResponse response , Object handler ) throws Exception {
        System.out.println ( "bbbbbbbbbbbbbbbbb- preHandle" );
        System.out.println ( this.getClass() );

        logger.info("");
        return HandlerInterceptor.super.preHandle ( request , response , handler );
    }

    @Override
    public void postHandle (
            HttpServletRequest request , HttpServletResponse response , Object handler ,
            ModelAndView modelAndView ) throws Exception {
        System.out.println ( "bbbbbbbbbbbbbbbbb" );
        HandlerInterceptor.super.postHandle ( request , response , handler , modelAndView );
    }

    @Override
    public void afterCompletion (
            HttpServletRequest request , HttpServletResponse response , Object handler ,
            Exception ex ) throws Exception {
        System.out.println ( "bbbbbbbbbbbbbbbbb" );
        HandlerInterceptor.super.afterCompletion ( request , response , handler , ex );
    }
}
