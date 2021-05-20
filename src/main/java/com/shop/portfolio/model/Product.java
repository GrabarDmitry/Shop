package com.shop.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity {

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productCategoryId")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
