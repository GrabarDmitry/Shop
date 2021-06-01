package com.shop.portfolio.dao;

import com.shop.portfolio.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Long> {
}
