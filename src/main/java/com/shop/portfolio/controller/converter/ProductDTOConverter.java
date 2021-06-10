package com.shop.portfolio.controller.converter;

import com.shop.portfolio.controller.dto.request.ProductRequestDTO;
import com.shop.portfolio.controller.dto.responce.ProductResponseDTO;
import com.shop.portfolio.model.Product;
import com.shop.portfolio.model.ProductImage;
import com.shop.portfolio.service.ProductCategoryService;
import com.shop.portfolio.service.ProductImageService;
import com.shop.portfolio.service.ProductService;
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
    private final ProductService productService;
    private final ProductImageService imageService;

    public ProductResponseDTO toDTO(Product product) {
        log.trace("Convert Product: {}, to ProductDTO", product);
        return new ProductResponseDTO(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getProductCategory() != null
                        ? product.getProductCategory().getId()
                        : null,
                product.getUser() != null
                        ? product.getUser().getId()
                        : null,
                product.getProductImage() != null
                        ? product.getProductImage().getId()
                        : null
        );
    }

    public Product toEntityCreate(ProductRequestDTO createDTO) {
        log.trace("Convert ProductCreateDTO: {}, to Product", createDTO);
        return new Product(
                createDTO.getTitle(),
                createDTO.getDescription(),
                null,
                createDTO.getCategoryId() != null
                        ? categoryService.findProductCategory(createDTO.getCategoryId()).get()
                        : null,
                securityService.getCurrentUser().get(),
                createDTO.getImagePath() != null
                        ? imageService.findProductImageByPath(createDTO.getImagePath()).isPresent()
                        ? imageService.findProductImageByPath(createDTO.getImagePath()).get()
                        : new ProductImage(createDTO.getImagePath())
                        : imageService.findDefaultImage().get()
        );
    }

    public Product toEntityUpdate(Long id, ProductRequestDTO updateDTO) {
        log.trace("Convert ProductUpdateDTO: {}, to Product", updateDTO);
        Product product = productService.findProductById(id);
        product.setTitle(updateDTO.getTitle());
        product.setDescription(updateDTO.getDescription());
        product.setProductCategory(
                updateDTO.getCategoryId() != null
                        ? categoryService.findProductCategory(updateDTO.getCategoryId()).get()
                        : null);
        product.setProductImage(
                updateDTO.getImagePath() != null
                        ? imageService.findProductImageByPath(updateDTO.getImagePath()).isPresent()
                        ? imageService.findProductImageByPath(updateDTO.getImagePath()).get()
                        : new ProductImage(updateDTO.getImagePath())
                        : imageService.findDefaultImage().get()
        );
        return product;
    }

}
