package com.shop.portfolio.controller.converter;

import com.shop.portfolio.controller.dto.request.UserRequestDTO;
import com.shop.portfolio.controller.dto.response.UserResponseDTO;
import com.shop.portfolio.model.Cart;
import com.shop.portfolio.model.User;
import com.shop.portfolio.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDTOConverter {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserResponseDTO toDTO(User user) {
        log.trace("Convert User: {}, to UserResponseDTO", user);
        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getSurname(),
                user.getDateOfBirth()
        );
    }

    public User toEntityCreate(UserRequestDTO createDTO) {
        log.trace("Convert UserRequestDTO: {}, to User", createDTO);
        return new User(
                createDTO.getEmail(),
                createDTO.getName(),
                createDTO.getSurname(),
                createDTO.getDateOfBirth(),
                passwordEncoder.encode(createDTO.getPassword()),
                roleService.findRoleByTitle("USER").isPresent()
                        ? roleService.findRoleByTitle("USER").get()
                        : null,
                new Cart()
        );
    }

}
