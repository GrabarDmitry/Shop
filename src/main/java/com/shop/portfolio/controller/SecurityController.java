package com.shop.portfolio.controller;

import com.shop.portfolio.controller.converter.UserDTOConverter;
import com.shop.portfolio.controller.dto.request.AuthenticationRequestDTO;
import com.shop.portfolio.controller.dto.request.UserRequestDTO;
import com.shop.portfolio.controller.dto.responce.AuthenticationResponseDTO;
import com.shop.portfolio.controller.dto.responce.UserResponseDTO;
import com.shop.portfolio.service.SecurityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Security"})
@RestController
@RequiredArgsConstructor
@Slf4j
public class SecurityController {

    private final SecurityService securityService;
    private final UserDTOConverter userDTOConverter;

    @ApiOperation(value = "User authentication")
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponseDTO> authentication(@RequestBody AuthenticationRequestDTO dto) {
        log.trace("Controller method called to authentication user: {}", dto);
        return new ResponseEntity<>(
                new AuthenticationResponseDTO(securityService.
                        authentication(dto.getEmail(), dto.getPassword())),
                HttpStatus.OK
        );
    }

    @ApiOperation(value = "User registration")
    @PostMapping("/registration")
    public ResponseEntity<UserResponseDTO> registration(@RequestBody UserRequestDTO dto) {
        log.trace("Controller method called to registration user: {}", dto);
        return new ResponseEntity<>(
                userDTOConverter.toDTO(securityService.
                        registration(userDTOConverter.toEntityCreate(dto))),
                HttpStatus.CREATED
        );
    }

}
