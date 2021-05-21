package com.shop.portfolio.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String roleName;

    @Override
    public String getAuthority() {
        return roleName;
    }

}
