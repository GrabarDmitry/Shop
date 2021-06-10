package com.shop.portfolio.service;

import com.shop.portfolio.model.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findRoleByTitle(String title);
}
