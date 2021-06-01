package com.shop.portfolio.controller.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String userEmail;
}
