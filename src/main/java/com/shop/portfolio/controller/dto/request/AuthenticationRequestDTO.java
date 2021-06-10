package com.shop.portfolio.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {

    @Email(message = "email should be valid")
    @NotEmpty(message = "email should not be empty")
    @Size(max = 256, message = "email must be less than 256 characters")
    private String email;

    @NotEmpty(message = "password should not be empty")
    @Size(max = 256, message = "password must be less than 256 characters")
    private String password;
}
