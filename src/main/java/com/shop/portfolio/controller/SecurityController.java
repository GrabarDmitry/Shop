package com.shop.portfolio.controller;

import com.shop.portfolio.controller.dto.request.AuthenticationRequestDTO;
import com.shop.portfolio.controller.dto.responce.AuthenticationResponseDTO;
import com.shop.portfolio.service.SecurityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @ApiOperation(value = "User authentication")
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponseDTO> authentication(@RequestBody AuthenticationRequestDTO dto) {
        log.trace("Controller method called to authentication user: {}", dto);
        return ResponseEntity.ok(
                new AuthenticationResponseDTO(securityService.
                        authentication(dto.getEmail(), dto.getPassword()))
        );
    }


}
