package com.challenge.ecommerce.tps.user_management.authentication.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AuthResponseDTO {

    private String accessToken;
    private String token;
}