package com.shop.portfolio.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductRequestDTO {
    private String title;
    private String description;
    private Long categoryId;
    private String imagePath;
}
