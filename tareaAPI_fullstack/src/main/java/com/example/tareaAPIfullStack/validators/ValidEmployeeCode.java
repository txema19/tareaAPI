package com.example.tareaAPIfullStack.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.*;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PrefixValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidEmployeeCode {

    String message() default "The string must start with 'EMP-'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "EMP-";
}


