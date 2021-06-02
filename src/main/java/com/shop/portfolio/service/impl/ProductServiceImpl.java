package com.shop.portfolio.service.impl;

import com.shop.portfolio.dao.ProductDAO;
import com.shop.portfolio.exception.ResourceException;
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
    @Transactional(readOnly = true)
    public Page<Product> findAllProducts(Pageable pageable) {
        log.trace("Service method called to find all Products with params: {}", pageable);
        return productDAO.findAll(pageable);

    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(Long id) {
        log.trace("Service method called to find Product with id: {}", id);
        return productDAO.findById(id).
                orElseThrow(() -> {
                    log.warn("Product with Id: {} not found", id);
                    throw new ResourceException("Product with Id: " + id + " not found");
                });

    }

    @Override
    public Product createProduct(Product product) {
        log.info("Service method called to create Product: {}", product);
        return productDAO.save(product);

    }

    @Override
    public Product updateProduct(Product product) {
        log.info("Service method called to update Product with id: {}", product.getId());
        productDAO.findById(product.getId())
                .ifPresentOrElse(
                        u -> productDAO.saveAndFlush(product),
                        () -> {
                            log.error("Product with Id: {} not found", product.getId());
                            throw new ResourceException("Product with Id: " + product.getId() + " not found");
                        }
                );

        return product;

    }

    @Override
    public void deleteProductById(Long id) {
        log.info("Service method called to delete Product with id: {}", id);
        productDAO.deleteById(id);
    }
}
