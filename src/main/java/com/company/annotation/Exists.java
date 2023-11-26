package com.company.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {
    String message() default "Object must not be null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
