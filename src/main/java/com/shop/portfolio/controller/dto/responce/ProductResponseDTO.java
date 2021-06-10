package com.shop.portfolio.controller.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Long productCategoryId;
    private Long userId;
    private Long productImageId;
}
