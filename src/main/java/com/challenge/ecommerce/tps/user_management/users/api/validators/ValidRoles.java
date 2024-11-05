package com.challenge.ecommerce.tps.user_management.users.api.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RolesValidator.class)
@Documented
public @interface ValidRoles {
	String message() default "Invalid Role or Null Data";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}