package com.cdhgold.jang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdhgold.jang.busi.common.CommController;
import com.cdhgold.jang.config.model.Comm;

@Component
public class RunTimeException  {

	@Autowired
	protected CommController commCntr;
	 
  private String message = "";
  private String targetu = "";

 
  public void setException(String message, String tagetu) {
	    
	    this.message = message;
	    this.targetu = tagetu;
	    main();
  }
  
  public void  main( ) {
	    
	    Comm vo = new Comm();
	    vo.setPath(this.targetu);
	    vo.setErr(this.message); 
	    commCntr.setVo(vo);
	    
  }
 
}
