package com.cdhgold.jang.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cdhgold.jang.config.model.User;

import lombok.Data;
 
// Authentication 媛앹껜�뿉 ���옣�븷 �닔 �엳�뒗 �쑀�씪�븳 ���엯
@Data
public class PrincipalDetails implements UserDetails{

	private User user;
	Set<GrantedAuthority> authorities=null;
	public PrincipalDetails(User user) {
		super();
		this.user = user;
	}
	

    public void setAuthorities(Set<GrantedAuthority> authorities)
    {
        this.authorities=authorities;
    }
	@Override
	public String getPassword() {
		return user.getPwd();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
		collet.add(()->{ return user.getRole();});
		return collet;
	}
	 
	
	public User getUser() {
	    return this.user;
	}

	
}
