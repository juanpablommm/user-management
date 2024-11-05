package com.challenge.ecommerce.tps.user_management.users.api.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@#!.=%*?&+_])[A-Za-z\\d@$#!.=%*?&+_]{8,15}$";

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if (Objects.isNull(password))
			return false;
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
