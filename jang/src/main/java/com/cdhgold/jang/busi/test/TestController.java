package com.cdhgold.jang.busi.test;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * test용 
 */
import org.springframework.web.servlet.ModelAndView;

import com.cdhgold.jang.config.RunTimeException;

  
@Controller
public class TestController {

    @Autowired
    protected TestService testService;
    @RequestMapping("/loginFrm")
    public ModelAndView loginFrm(HttpServletRequest request, Model model) {
    	ModelAndView mv = new ModelAndView();

    	ModelAndView modelAndView = RunTimeException.modelAndView ;
    	if(modelAndView != null && modelAndView.getModel().size()  >0) {
    		
        	RunTimeException.modelAndView = null;

        	System.out.println("modelAndView.getView()"+modelAndView.getModel().get("name"));
    	}
    	mv.setViewName("/loginFrm test" );
        return modelAndView;  
               
    }
    
}

