package com.knu.daeguhackathon.kakaotoken.dto;
public record KakaoResultRequest(
    String start, String end, Double estimatedTime, Double buildingDistance
) {

}
