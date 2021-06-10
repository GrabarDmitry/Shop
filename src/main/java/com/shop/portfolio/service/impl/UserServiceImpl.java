package com.shop.portfolio.service.impl;

import com.shop.portfolio.model.User;
import com.shop.portfolio.repository.UserRepository;
import com.shop.portfolio.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findUser(Long id) {
        log.trace("Service method called to view User with id: {}", id);
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        log.trace("Service method called to view User with email: {}", email);
        return userRepository.findUserByEmail(email);
    }

}
