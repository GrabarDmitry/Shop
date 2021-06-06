package com.shop.portfolio.service;

import com.shop.portfolio.model.ProductImage;

import java.util.Optional;

public interface ProductImageService {

    Optional<ProductImage> findProductImageByPath(String path);

    Optional<ProductImage> findDefaultImage();

}
