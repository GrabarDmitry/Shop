package com.shop.portfolio.controller;

import com.shop.portfolio.controller.converter.ProductCategoryConverter;
import com.shop.portfolio.controller.dto.responce.ProductCategoryDTO;
import com.shop.portfolio.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Product Category"})
@RestController
@Slf4j
@RequestMapping("/api/productCategory")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryConverter categoryConverter;
    private final ProductCategoryService categoryService;

    @ApiOperation(value = "Get Product Category by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> getProductCategoryById(@PathVariable Long id) {
        log.trace("Controller method called to view Product Category with id: {}", id);
        return new ResponseEntity<>(
                categoryConverter.
                        toDTO(categoryService.findProductCategoryById(id)),
                HttpStatus.OK);
    }


}
