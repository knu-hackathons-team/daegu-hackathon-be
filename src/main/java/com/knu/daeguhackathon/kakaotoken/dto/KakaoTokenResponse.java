package com.knu.daeguhackathon.kakaotoken.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public record KakaoTokenResponse(
    String accessToken, String refreshToken, Integer expiresIn

) {

}
