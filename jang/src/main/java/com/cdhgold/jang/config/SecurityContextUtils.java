package com.cdhgold.jang.config;
/*
 * SecurityContextHolder로 인증객체를 get한다. 
 */
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityContextUtils {

    public static Authentication  getAuthUser() {
        return  SecurityContextHolder.getContext().getAuthentication();
    }
   
}
