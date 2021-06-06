package com.shop.portfolio.service.impl;

import com.shop.portfolio.model.ProductImage;
import com.shop.portfolio.repository.ProductImageRepository;
import com.shop.portfolio.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository imageRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductImage> findProductImageByPath(String path) {
        log.trace("Service method called to find Product Image with path: {}", path);
        return imageRepository.findProductImageByPath(path);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductImage> findDefaultImage() {
        log.trace("Service method called to find default Product Image");
        return imageRepository.findById(1L);
    }

}
