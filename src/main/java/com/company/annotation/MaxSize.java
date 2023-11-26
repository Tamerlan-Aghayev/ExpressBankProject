package com.company.annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MaxSizeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxSize {
    String message() default "String size exceeds the allowed limit";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int maxSize() default 255;
}

