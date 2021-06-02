package com.shop.portfolio.service.impl;

import com.shop.portfolio.dao.ProductCategoryDAO;
import com.shop.portfolio.exception.ResourceException;
import com.shop.portfolio.model.ProductCategory;
import com.shop.portfolio.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryDAO productCategoryDAO;

    @Transactional(readOnly = true)
    @Override
    public ProductCategory findProductCategoryById(Long id) {
        log.trace("Service method called to view Product Category with id: {}", id);
        return productCategoryDAO
                .findById(id)
                .orElseThrow(() -> {
                    throw new ResourceException("Product Category with Id: " + id + " not found");
                });
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ProductCategory> findProductCategory(Long id) {
        log.trace("Service method called to view Product Category with id: {}", id);
        return productCategoryDAO.findById(id);
    }


}
