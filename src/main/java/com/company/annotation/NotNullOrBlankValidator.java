package com.company.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNullOrBlankValidator implements ConstraintValidator<NotNullOrBlank, CharSequence> {

    @Override
    public void initialize(NotNullOrBlank constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return value != null && value.toString().trim().length() > 0;
    }
}
