package com.shop.portfolio.controller.converter;

import com.shop.portfolio.controller.dto.request.ProductCreateDTO;
import com.shop.portfolio.controller.dto.responce.ProductDTO;
import com.shop.portfolio.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
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

//    public Product toEntity(ProductCreateDTO createDTO) {
//        log.trace("Convert CreateProductDTO: {}, to Product", createDTO);
//        return new Product(
//                createDTO.getTitle(),
//                createDTO.getDescription(),
//                null,
//
//                );
//    }

}
