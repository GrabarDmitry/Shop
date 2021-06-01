package com.shop.portfolio.service.impl;

import com.shop.portfolio.dao.ProductDAO;
import com.shop.portfolio.model.Product;
import com.shop.portfolio.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        log.info("Service method called to find all Products with params: {}", pageable);
        return productDAO.findAll(pageable);

    }

    @Override
    public Product findProductById(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        log.info("Service method called to create Product: {}", product);
        return productDAO.save(product);

    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }
}
