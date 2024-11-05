package com.challenge.ecommerce.tps.user_management.shared.api;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ValidatorNotEmptyField implements ConstraintValidator<ValidNotEmptyField, String> {

	@Override
	public boolean isValid(String field, ConstraintValidatorContext context) {
		return Objects.nonNull(field) && !field.trim().isEmpty();
	}
}
