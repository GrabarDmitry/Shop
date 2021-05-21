package com.shop.portfolio.service.impl;

import com.shop.portfolio.dao.UserDAO;
import com.shop.portfolio.model.User;
import com.shop.portfolio.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Override
    public UserDetailsImpl loadUserByUsername(String email) {
        log.info("Service method called to load User with email: {}", email);
        User user = userDAO.findUserByEmail(email).
                orElseThrow(() -> {
                    log.warn("User not found with email: {}", email);
                    throw new UsernameNotFoundException("User with email " + email + " not found!"); });
        log.trace("Service method to load User with email: {}, returned User: {}", email, user);
        return new UserDetailsImpl(user);
    }
}
