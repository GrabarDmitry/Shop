package com.shop.portfolio.service.impl;

import com.shop.portfolio.dao.ProductCategoryDAO;
import com.shop.portfolio.exception.ResourceException;
import com.shop.portfolio.model.ProductCategory;
import com.shop.portfolio.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryDAO productCategoryDAO;

    @Transactional(readOnly = true)
    @Override
    public ProductCategory findProductCategoryById(Long id) {
        return productCategoryDAO
                .findById(id)
                .orElseThrow(() -> {
                    throw new ResourceException("Product Category with Id: " + id + " not found");
                });
    }

}
