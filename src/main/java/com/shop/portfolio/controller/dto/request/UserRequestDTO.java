package com.shop.portfolio.controller.dto.request;

import com.shop.portfolio.util.validation.ProductCategoryExistWithId;
import com.shop.portfolio.util.validation.UserExistWithEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @Email(message = "email should be valid")
    @NotEmpty(message = "email should not be empty")
    @Size(max = 256, message = "email must be less than 256 characters")
    @UserExistWithEmail
    private String email;

    @NotEmpty(message = "name should not be empty")
    @Size(max = 256, message = "name must be less than 256 characters")
    private String name;

    @NotEmpty(message = "surname should not be empty")
    @Size(max = 256, message = "surname must be less than 256 characters")
    private String surname;

    @NotEmpty(message = "password should not be empty")
    @Size(max = 256, message = "password must be less than 256 characters")
    private String password;

    @NotNull(message = "dateOfBirth should not be empty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateOfBirth;

}
