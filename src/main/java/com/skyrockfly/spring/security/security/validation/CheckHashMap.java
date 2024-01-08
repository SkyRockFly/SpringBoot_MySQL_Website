package com.skyrockfly.spring.security.security.validation;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckHashMapValidator.class)
public @interface CheckHashMap {
    public int min() default 0;
    public int max() default Integer.MAX_VALUE;
    public String message();

    public Class<?>[] groups() default {};

    public Class<? extends Payload> [] payload() default {};
}
