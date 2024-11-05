package com.challenge.ecommerce.tps.user_management.users.api.validators;

import com.challenge.ecommerce.tps.user_management.users.api.SystemRolesEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Objects;

public class RolesValidator implements ConstraintValidator<ValidRoles, String> {

	@Override
	public boolean isValid(String role, ConstraintValidatorContext context) {
		if (Objects.isNull(role))
			return false;
		return Arrays.stream(SystemRolesEnum.values())
				.anyMatch(enumValue -> enumValue.getRole().equalsIgnoreCase(role));
	}
}