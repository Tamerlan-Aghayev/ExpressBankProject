package com.company.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositivePriceValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PositivePrice {
    String message() default "Value must be a positive number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

