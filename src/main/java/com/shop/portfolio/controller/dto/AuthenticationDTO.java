package com.shop.portfolio.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class AuthenticationDTO {
    private String email;
    private String password;
}