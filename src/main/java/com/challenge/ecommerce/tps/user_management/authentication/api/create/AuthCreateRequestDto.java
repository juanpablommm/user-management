package com.challenge.ecommerce.tps.user_management.authentication.api.create;

import com.challenge.ecommerce.tps.user_management.users.api.ValidEmail;
import com.challenge.ecommerce.tps.user_management.users.api.ValidPassword;

public record AuthCreateRequestDto(@ValidEmail String email, @ValidPassword String password) {
}
