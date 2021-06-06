package com.shop.portfolio.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
public class ProductRequestDTO {

    @NotEmpty(message = "title should not be empty")
    @Size(max = 256, message = "title must be less than 256 characters")
    private String title;

    @NotEmpty(message = "description should not be empty")
    @Size(max = 256, message = "description must be less than 256 characters")
    private String description;

    @NotNull(message = "categoryId should not be empty")
    @Positive(message = "categoryId should be positive")
    private Long categoryId;

    @Size(max = 256, message = "imagePath must be less than 256 characters")
    private String imagePath;

}
