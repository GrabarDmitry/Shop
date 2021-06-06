package com.shop.portfolio.controller.dto.request;

import com.shop.portfolio.util.validation.ProductCategoryExistWithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @NotEmpty(message = "title should not be empty")
    @Size(max = 256, message = "title must be less than 256 characters")
    private String title;

    @NotEmpty(message = "description should not be empty")
    @Size(max = 256, message = "description must be less than 256 characters")
    private String description;

    @NotNull(message = "categoryId should not be empty")
    @Positive(message = "categoryId should be positive")
    @ProductCategoryExistWithId(message = "product category with categoryId not found")
    private Long categoryId;

    @Size(max = 256, message = "imagePath must be less than 256 characters")
    private String imagePath;

}
