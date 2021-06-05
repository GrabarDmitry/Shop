package com.shop.portfolio.controller;

import com.shop.portfolio.controller.converter.ProductDTOConverter;
import com.shop.portfolio.controller.dto.request.ProductRequestDTO;
import com.shop.portfolio.controller.dto.responce.ProductDTO;
import com.shop.portfolio.service.ProductService;
import com.shop.portfolio.util.PageableSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {"Product"})
@RestController
@Slf4j
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductDTOConverter converter;

    @ApiOperation(value = "View list of Product")
    @GetMapping
    @PageableSwagger
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @ApiIgnore
            @PageableDefault(
                    page = 0,
                    size = 20,
                    sort = "id",
                    direction = Sort.Direction.ASC) Pageable pageable) {
        log.trace("Controller method called to view all Products with params: {}", pageable);
        return new ResponseEntity<>(
                productService
                        .findAllProducts(pageable)
                        .map(converter::toDTO)
                , HttpStatus.OK);
    }

    @ApiOperation(value = "Get Product by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        log.trace("Controller method called to view Product with id: {}", id);
        return new ResponseEntity<>(
                converter.
                        toDTO(productService.findProductById(id)),
                HttpStatus.OK);
    }

    @ApiOperation(value = "Create new Product")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(
            @RequestBody ProductRequestDTO createDTO) {
        log.trace("Controller method called to create new Product: {}", createDTO);
        return new ResponseEntity<>(converter.
                toDTO(productService.
                        createProduct(converter.toEntity(createDTO))),
                HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Product by id")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductById(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO updateDTO
    ) {
        log.trace("Controller method called to update Product with id: {}", id);
        return new ResponseEntity<>(converter.
                toDTO(productService.
                        updateProduct(converter.toEntity(id, updateDTO))),
                HttpStatus.OK);
    }

}
