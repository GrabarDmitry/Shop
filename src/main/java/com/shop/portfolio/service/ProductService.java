package com.shop.portfolio.service;

import com.shop.portfolio.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> findAllProducts(Pageable pageable);

    Product findProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProductById(Long id);

}
