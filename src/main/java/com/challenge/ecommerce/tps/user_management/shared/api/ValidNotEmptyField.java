package com.challenge.ecommerce.tps.user_management.shared.api;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorNotEmptyField.class)
@Documented
public @interface ValidNotEmptyField {
	String message() default "Field cannot be null or empty";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}