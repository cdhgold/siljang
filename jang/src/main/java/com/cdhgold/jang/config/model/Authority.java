package com.cdhgold.jang.config.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {

    ADMIN,
    COUSER,
    USER;

    @Override
    public String getAuthority() {
        return this.toString();
    }

}
