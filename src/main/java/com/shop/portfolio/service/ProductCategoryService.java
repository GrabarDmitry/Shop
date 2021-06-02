package com.shop.portfolio.service;

import com.shop.portfolio.model.ProductCategory;

import java.util.Optional;

public interface ProductCategoryService {

    ProductCategory findProductCategoryById(Long id);

    Optional<ProductCategory> findProductCategory(Long id);

}
