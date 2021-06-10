package com.shop.portfolio.service.impl;

import com.shop.portfolio.model.User;
import com.shop.portfolio.repository.UserRepository;
import com.shop.portfolio.security.UserDetailsImpl;
import com.shop.portfolio.security.jwt.TokenProvider;
import com.shop.portfolio.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SecurityServiceImpl implements SecurityService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final TokenProvider provider;
    private final UserRepository userRepository;

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
    public User registration(User user) {
        log.info("Service method called to registration User with email: {}", user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getCurrentUser() {
        log.info("Service method called to get Current User");
        return Optional.of(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(principal -> principal instanceof UserDetailsImpl)
                .map(principal -> Optional.of(((UserDetailsImpl) principal).getUser()))
                .orElse(Optional.empty());

    }

}

