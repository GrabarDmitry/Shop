package com.shop.portfolio.controller.converter;

import com.shop.portfolio.controller.dto.request.ProductCategoryRequestDTO;
import com.shop.portfolio.controller.dto.response.ProductCategoryResponseDTO;
import com.shop.portfolio.model.ProductCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductCategoryDTOConverter {

    public ProductCategoryResponseDTO toDTO(ProductCategory product) {
        log.trace("Convert ProductCategory: {}, to ProductCategoryDTO", product);
        return new ProductCategoryResponseDTO(
                product.getId(),
                product.getTitle()
        );
    }

    public ProductCategory toEntityCreate(ProductCategoryRequestDTO createDTO) {
        log.trace("Convert ProductCategoryRequestDTO: {}, to Product", createDTO);
        return new ProductCategory(
                createDTO.getTitle()
        );
    }

}
