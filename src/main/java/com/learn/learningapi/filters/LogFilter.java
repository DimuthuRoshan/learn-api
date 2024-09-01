package com.learn.learningapi.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogFilter implements Filter {
    private static final Logger logger = LogManager.getLogger ();
    @Override
    public void doFilter (
            ServletRequest servletRequest , ServletResponse servletResponse ,
            FilterChain filterChain ) throws IOException, ServletException {

        logger.info ( "Request from : " + servletRequest.getRemoteAddr () );
        filterChain.doFilter ( servletRequest,servletResponse );
    }
}
