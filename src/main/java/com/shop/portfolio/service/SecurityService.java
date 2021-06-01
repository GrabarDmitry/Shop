package com.shop.portfolio.service;

import com.shop.portfolio.model.User;

public interface SecurityService {

    String authentication(String email, String password);

    String registration(User user);

    User getCurrentUser();

}
