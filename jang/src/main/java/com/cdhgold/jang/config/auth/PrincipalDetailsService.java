package com.cdhgold.jang.config.auth;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdhgold.jang.busi.test.TestService;
import com.cdhgold.jang.config.model.User;
 

@Service
public class PrincipalDetailsService implements UserDetailsService{

    Logger logger = LoggerFactory.getLogger(PrincipalDetailsService.class);
	@Autowired
	private TestService testService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    // username �� 蹂�寃쏀븯硫� �븞�맂�떎, �궡遺��뿉�꽌 �궗�슜�븯�뒗媛� 
    // login action諛쒖깮�떆 �옄�룞�쑝濡� �샇異쒕맂�떎 
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
 logger.debug("loadUserByUsername - login " );	    
	    Map map = new HashMap();
	    map.put("email", email); // �씤肄붾뵫�맂 email 
		User user = testService.selectUser(map);  
		user.setRole("ROLE_ADMIN");
		//String pwd = user.getPwd();
		//String rawPwd = bCryptPasswordEncoder.encode(pwd);
		//if(bCryptPasswordEncoder.matches(rawPassword, encodedPassword))
		//�꽦怨듯썑 pwd泥댄겕 
		if(user == null) {
			return null;
		}
		// �뿬湲곗꽌 return�맂 UserDetails�뒗 SecurityContext�쓽 Authentication�뿉 �벑濡앸릺�뼱 �씤利� �젙蹂대�� 媛뽮퀬�엳�뒗�떎.
		return new PrincipalDetails(user);
	}

}
