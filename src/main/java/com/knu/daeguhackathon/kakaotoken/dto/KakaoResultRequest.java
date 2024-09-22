package com.knu.daeguhackathon.kakaotoken.dto;
public record KakaoResultRequest(
    String dayName, String imageUrl, int estimatedTime, Double buildingDistance
) {

}
