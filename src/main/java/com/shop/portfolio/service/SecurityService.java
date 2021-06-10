package com.shop.portfolio.service;

import com.shop.portfolio.model.User;

import java.util.Optional;

public interface SecurityService {

    String authentication(String email, String password);

    User registration(User user);

    Optional<User> getCurrentUser();

}
