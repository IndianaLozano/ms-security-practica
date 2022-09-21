package com.redbee.mssecuritypractica.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Value
@Builder
public class Authorization {

    String accessToken;
    Integer expiresIn;
    String refreshToken;
    Integer refreshExpiresIn;
    String tokenType;
}
