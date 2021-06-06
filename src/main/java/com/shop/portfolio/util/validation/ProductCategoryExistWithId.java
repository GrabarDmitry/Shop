package com.shop.portfolio.util.validation;

import com.shop.portfolio.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ProductCategoryExistWithId.Validator.class)
public @interface ProductCategoryExistWithId {

    String message() default "{product category with id not found}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @RequiredArgsConstructor
    class Validator implements ConstraintValidator<ProductCategoryExistWithId, Long> {

        private final ProductCategoryService categoryService;

        @Override
        public void initialize(ProductCategoryExistWithId constraintAnnotation) {

        }

        @Override
        public boolean isValid(Long id, ConstraintValidatorContext context) {
            return id == null || categoryService.findProductCategory(id).isPresent();
        }
    }
}
