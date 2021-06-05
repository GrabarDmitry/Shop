package com.shop.portfolio.service.impl;

import com.shop.portfolio.model.ProductImage;
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

    @Override
    public Optional<ProductImage> findProductImageByPath(String path) {
        return Optional.empty();
    }

}
