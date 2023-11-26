package com.company.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FixedSizeValidator implements ConstraintValidator<FixedSize, String> {
    private int min;
    private int max;

    @Override
    public void initialize(FixedSize constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.length() >= min && value.length() <= max;
    }
}
