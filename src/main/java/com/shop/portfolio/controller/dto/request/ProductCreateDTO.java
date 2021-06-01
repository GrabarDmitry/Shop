package com.shop.portfolio.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductCreateDTO {
    private Long id;
    private String title;
    private String description;
    private Long categoryId;
}
