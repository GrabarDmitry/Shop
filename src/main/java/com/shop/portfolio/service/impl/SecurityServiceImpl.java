package com.shop.portfolio.service.impl;

import com.shop.portfolio.model.User;
import com.shop.portfolio.security.UserDetailsImpl;
import com.shop.portfolio.security.jwt.TokenProvider;
import com.shop.portfolio.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SecurityServiceImpl implements SecurityService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final TokenProvider provider;

    public String authentication(String email, String password) {
        log.info("Service method called to authenticate User with email: {}, password: {}", email, password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            UserDetailsImpl user = userDetailsService.loadUserByUsername(email);
            String token = provider.createToken(user);
            log.info("authentication:User with email {} was authenticated!", email);
            return token;
        } catch (AuthenticationException exception) {
            log.error("authentication:User with email {} was not authenticated!", email);
            throw new BadCredentialsException("Invalid Username or password!");
        }
    }

    @Override
    public String registration(User user) {
        return null;
    }

}

