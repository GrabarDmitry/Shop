package com.shop.portfolio.controller.converter;

import com.shop.portfolio.controller.dto.responce.ProductCategoryDTO;
import com.shop.portfolio.model.ProductCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductCategoryConverter {

    public ProductCategoryDTO toDTO(ProductCategory product) {
        log.trace("Convert ProductCategory: {}, to ProductCategoryDTO", product);
        return new ProductCategoryDTO(
                product.getId(),
                product.getTitle()
        );
    }

}
