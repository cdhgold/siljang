package com.cdhgold.jang.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter { 
    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) { 
        super.setAuthenticationManager(authenticationManager); 
        
    
    } 
     
    @Override 
    public Authentication attemptAuthentication(HttpServletRequest request, 
            HttpServletResponse response) throws AuthenticationException { 
        
        UsernamePasswordAuthenticationToken authRequest 
        = new UsernamePasswordAuthenticationToken(request.getParameter("email"), request.getParameter("pwd"));
        setDetails(request, authRequest); 
        return this.getAuthenticationManager().authenticate(authRequest); 
        
    
    }
 
 
 
}
