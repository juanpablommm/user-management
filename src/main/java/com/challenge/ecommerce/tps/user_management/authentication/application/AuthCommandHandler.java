package com.challenge.ecommerce.tps.user_management.authentication.application;

import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.AbstractMap;

public class AuthCommandHandler {

    public AbstractMap.SimpleEntry<String, String> handler(String email){
        System.out.println("generate jww and refresh token.... " );
        return new AbstractMap.SimpleEntry<>("test", "test");
    }
}
