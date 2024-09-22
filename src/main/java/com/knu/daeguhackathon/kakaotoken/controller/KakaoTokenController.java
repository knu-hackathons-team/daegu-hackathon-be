package com.knu.daeguhackathon.kakaotoken.controller;

import com.knu.daeguhackathon.config.LoginMember;
import com.knu.daeguhackathon.kakaotoken.dto.KakaoResultRequest;
import com.knu.daeguhackathon.kakaotoken.service.KakaoMessageService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KakaoTokenController {

    private final KakaoMessageService kakaoMessageService;

    @PostMapping("/api/timetable/kakao")
    public ResponseEntity<Void> sendTimetableKakaoMessage(@LoginMember Long memberId,
        @RequestBody KakaoResultRequest request) {
        kakaoMessageService.sendResultMessage(memberId, request.dayName(), request.imageUrl(),
            request.estimatedTime(), request.buildingDistance());
        return ResponseEntity.ok().build();
    }

}
