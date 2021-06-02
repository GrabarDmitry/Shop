package com.shop.portfolio.controller.converter;

import com.shop.portfolio.controller.dto.request.ProductCreateDTO;
import com.shop.portfolio.controller.dto.responce.ProductDTO;
import com.shop.portfolio.model.Product;
import com.shop.portfolio.service.ProductCategoryService;
import com.shop.portfolio.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductDTOConverter {

    private final ProductCategoryService categoryService;
    private final SecurityService securityService;

    public ProductDTO toDTO(Product product) {
        log.trace("Convert Product: {}, to ProductDTO", product);
        return new ProductDTO(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getProductCategory() != null
                        ? product.getProductCategory().getId() :
                        null,
                product.getUser() != null
                        ? product.getUser().getId() :
                        null
        );
    }

    public Product toEntity(ProductCreateDTO createDTO) {
        log.trace("Convert CreateProductDTO: {}, to Product", createDTO);
        return new Product(
                createDTO.getTitle(),
                createDTO.getDescription(),
                null,
                createDTO.getCategoryId() != null
                        ? categoryService.findProductCategory(createDTO.getCategoryId()).get()
                        : null,
                securityService.getCurrentUser().get()
        );
    }

}
