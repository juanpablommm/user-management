package com.challenge.ecommerce.tps.user_management.authentication.api;

import com.challenge.ecommerce.tps.user_management.users.api.ValidEmail;
import com.challenge.ecommerce.tps.user_management.users.api.ValidPassword;

public record AuthRequestDto(@ValidEmail String email, @ValidPassword String password) {
}
