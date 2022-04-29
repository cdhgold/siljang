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

import com.cdhgold.jang.busi.common.CommController;
import com.cdhgold.jang.config.RunTimeException;
import com.cdhgold.jang.config.model.Comm;

  
@Controller
public class TestController extends CommController {

    @Autowired
    protected TestService testService;
    @RequestMapping("/loginFrm")
    public ModelAndView loginFrm(HttpServletRequest request, Model model) {
    	ModelAndView mv = new ModelAndView();
    	if(this.getVo() != null ) {
	        Comm vo = this.getVo();
	    	mv.setViewName(vo.getPath() );
	    	mv.addObject("message", vo.getErr());
	    	this.setVo(null);
    	}else {
        	mv.setViewName("/loginFrm");
    	}
        return mv;  
               
    }
    @RequestMapping("/workspace/wrk01")
    public void workspace01(HttpServletRequest request, Model model) {
    	try {
    	testService.workspace01();
    	}catch(Exception e) {
    		System.out.println("main workspace01==> runtime이후 ");
    	}
    	System.out.println("main workspace01==> runtime catch 밖  ");
    } 
    @RequestMapping("/workspace/wrk02")
    public void workspace02(HttpServletRequest request, Model model) {
    	try {
    	testService.workspace02();
    	}catch(Exception e) {

        	System.out.println("main workspace02==> catch안 ");
    		e.printStackTrace();
    	}
    	System.out.println("main workspace02==> runtime이후 ");
    	
    	
    }
}

