package com.shop.portfolio.service.impl;

import com.shop.portfolio.model.Role;
import com.shop.portfolio.repository.RoleRepository;
import com.shop.portfolio.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> findRoleByTitle(String title) {
        log.trace("Service method called to view Role with title: {}", title);
        return roleRepository.findByTitle(title);
    }

}
