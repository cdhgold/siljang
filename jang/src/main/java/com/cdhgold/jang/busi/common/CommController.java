package com.cdhgold.jang.busi.common;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
import com.cdhgold.jang.config.model.Comm;

  
@Controller
@Primary
public class CommController {
	private static Comm commvo;
    public Comm setVo(Comm vo ) {
    	commvo = vo;
        return commvo;  
               
    }
    public Comm getVo( ) {
        return this.commvo;  
               
    }
}

