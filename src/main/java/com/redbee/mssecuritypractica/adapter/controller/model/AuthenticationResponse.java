package com.redbee.mssecuritypractica.adapter.controller.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AuthenticationResponse {

    private String accessToken;
    private Integer expiresIn;
    private String refreshToken;
    private Integer refreshExpiresIn;
    private String tokenType;

//    public static AuthenticationResponse fromDomain(Authentication domain){
//        return AuthenticationResponse
//                .builder()
//                .accessToken(domain.getAccessToken())
//                .expiresIn(domain.getExpiresIn())
//                .refreshToken(domain.getRefreshToken())
//                .refreshExpiresIn(domain.getRefreshExpiresIn())
//                .tokenType(domain.getTokenType())
//                .build();
//    }
}
