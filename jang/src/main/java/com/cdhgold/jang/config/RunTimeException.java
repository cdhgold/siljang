package com.cdhgold.jang.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


public class RunTimeException extends RuntimeException {

  /** IconPlusException.java */
  private static final long serialVersionUID = 8162612253643216040L;
  public static ModelAndView modelAndView = new ModelAndView();
  private String message = "";
  private String targetu = "";

  public RunTimeException(String message, Throwable cause ,  HttpServletRequest request) { 
    super(cause);
    this.message = this.searchCode(message);
    HttpSession session = request.getSession(); 
    session.setAttribute("ERROR_MSG", message);
  }
  public RunTimeException(String message, String tagetu) {
	    
	    this.message = message;
	    this.targetu = tagetu;
	    main();
  }
  public RunTimeException(String message, Throwable cause) {
    super(cause);
    this.message = this.searchCode(message);
  }

  public RunTimeException(String message,  HttpServletRequest request) {
      HttpSession session = request.getSession(); 
      session.setAttribute("ERROR_MSG", message);
    this.message = message;
  }

  public RunTimeException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  private String searchCode(String message) {
     
    return message;
  }
  public void  main( ) {
	    
	    modelAndView.setViewName(this.targetu );
	    modelAndView.addObject("message", this.message);
	    //return modelAndView;
	     
  }
 
}
