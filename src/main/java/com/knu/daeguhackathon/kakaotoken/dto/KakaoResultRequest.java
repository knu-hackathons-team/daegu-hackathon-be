package com.knu.daeguhackathon.kakaotoken.dto;
public record KakaoResultRequest(
    String start, String end, int estimatedTime, Double buildingDistance
) {

}
