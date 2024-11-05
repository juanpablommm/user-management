package com.challenge.ecommerce.tps.user_management.users.api;

import com.challenge.ecommerce.tps.user_management.users.api.validators.ValidEmail;
import com.challenge.ecommerce.tps.user_management.users.api.validators.ValidPassword;
import com.challenge.ecommerce.tps.user_management.users.api.validators.ValidRoles;
import jakarta.validation.Valid;
import java.util.Set;

public record UserRequestDto(String names, String surnames, String username, @ValidPassword String password,
		@ValidEmail String email, Set<@Valid @ValidRoles String> roles) {
}
