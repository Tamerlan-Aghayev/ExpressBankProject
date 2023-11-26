package com.company.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotNullOrBlankValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullOrBlank {
    String message() default "Field must not be null or blank";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

