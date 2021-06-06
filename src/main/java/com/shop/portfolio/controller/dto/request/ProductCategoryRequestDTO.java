package com.shop.portfolio.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryRequestDTO {

    @NotEmpty(message = "title should not be empty")
    @Size(max = 45, message = "title must be less than 45 characters")
    private String title;

}
