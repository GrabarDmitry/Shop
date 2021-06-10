package com.shop.portfolio.controller;

import com.shop.portfolio.controller.converter.ProductCategoryDTOConverter;
import com.shop.portfolio.controller.dto.request.ProductCategoryRequestDTO;
import com.shop.portfolio.controller.dto.response.ProductCategoryResponseDTO;
import com.shop.portfolio.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Product Category"})
@RestController
@Slf4j
@RequestMapping("/api/productCategory")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryDTOConverter categoryConverter;
    private final ProductCategoryService categoryService;

    @ApiOperation(value = "Get Product Category by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDTO> getProductCategoryById(@PathVariable Long id) {
        log.trace("Controller method called to view Product Category with id: {}", id);
        return new ResponseEntity<>(
                categoryConverter.
                        toDTO(categoryService.findProductCategoryById(id)),
                HttpStatus.OK);
    }

    @ApiOperation(value = "Create new Product Category")
    @PostMapping
    public ResponseEntity<ProductCategoryResponseDTO> createProductCategory(
            @RequestBody @Valid ProductCategoryRequestDTO createDTO
    ) {
        log.trace("Controller method called to create new Product Category: {}", createDTO);
        return new ResponseEntity<>(categoryConverter.
                toDTO(categoryService.
                        createProductCategory(categoryConverter.toEntityCreate(createDTO))),
                HttpStatus.CREATED);
    }

}
