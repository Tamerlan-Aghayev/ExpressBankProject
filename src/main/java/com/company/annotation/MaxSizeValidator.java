package com.company.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MaxSizeValidator implements ConstraintValidator<MaxSize, String> {

    private int maxSize;

    @Override
    public void initialize(MaxSize constraintAnnotation) {
        this.maxSize = constraintAnnotation.maxSize();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || value.length() <= maxSize;
    }
}
