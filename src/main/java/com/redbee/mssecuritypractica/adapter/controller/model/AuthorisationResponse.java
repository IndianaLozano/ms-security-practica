package com.redbee.mssecuritypractica.adapter.controller.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.redbee.mssecuritypractica.domain.Authorization;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorisationResponse {

    private String accessToken;
    private Integer expiresIn;
    private String refreshToken;
    private Integer refreshExpiresIn;
    private String tokenType;

    public static AuthorisationResponse fromDomain(Authorization domain){
        return AuthorisationResponse
                .builder()
                .accessToken(domain.getAccessToken())
                .expiresIn(domain.getExpiresIn())
                .refreshToken(domain.getRefreshToken())
                .refreshExpiresIn(domain.getRefreshExpiresIn())
                .tokenType(domain.getTokenType())
                .build();
    }
}
