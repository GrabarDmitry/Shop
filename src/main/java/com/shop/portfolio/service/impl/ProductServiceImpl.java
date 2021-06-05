package com.shop.portfolio.service.impl;

import com.shop.portfolio.repository.ProductRepository;
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

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAllProducts(Pageable pageable) {
        log.trace("Service method called to find all Products with params: {}", pageable);
        return productRepository.findAll(pageable);

    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(Long id) {
        log.trace("Service method called to find Product with id: {}", id);
        return productRepository.findById(id).
                orElseThrow(() -> {
                    log.warn("Product with Id: {} not found", id);
                    throw new ResourceException("Product with Id: " + id + " not found");
                });

    }

    @Override
    public Product createProduct(Product product) {
        log.info("Service method called to create Product: {}", product);
        return productRepository.save(product);

    }

    @Override
    public Product updateProduct(Product product) {
        log.info("Service method called to update Product with id: {}", product.getId());
        productRepository.findById(product.getId())
                .ifPresentOrElse(
                        u -> productRepository.saveAndFlush(product),
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
        productRepository.deleteById(id);
    }
}
