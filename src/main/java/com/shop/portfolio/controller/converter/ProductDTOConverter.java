package com.shop.portfolio.controller.converter;

import com.shop.portfolio.controller.dto.ProductDTO;
import com.shop.portfolio.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class ProductDTOConverter {

    public ProductDTO toDTO(Product product) {
        log.trace("Convert Product: {}, to ProductDTO", product);
        return new ProductDTO(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getProductCategory() != null
                        ? product.getProductCategory().getTitle() :
                        null
        );
    }

}
