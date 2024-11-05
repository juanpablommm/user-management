package com.challenge.ecommerce.tps.user_management.authentication.api.create;

import com.challenge.ecommerce.tps.user_management.users.api.validators.ValidEmail;
import com.challenge.ecommerce.tps.user_management.users.api.validators.ValidPassword;

public record AuthCreateRequestDto(@ValidEmail String email, @ValidPassword String password) {
}
