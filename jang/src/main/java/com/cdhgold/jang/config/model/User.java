package com.cdhgold.jang.config.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

// PrincipalDetailsService 사용 

@Data 
public class User {

    private List<Authority> authorities;// 필수 , 없으면 오류발생 
    public User() {
        authorities = new ArrayList<>();
        authorities.add(Authority.USER);
    }
	private String email;
	private String nm;
	private String role; //ROLE_USER, ROLE_ADMIN,ROLE_MANG
	private String pwd; 
	
    
	
}
