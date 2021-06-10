package com.shop.portfolio.service;

import com.shop.portfolio.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(Long id);

    Optional<User> findUserByEmail(String email);

}
