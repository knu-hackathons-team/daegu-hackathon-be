package com.knu.daeguhackathon.distance.controller;

import com.knu.daeguhackathon.global.dto.GlobalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/distance")
public class DistanceController {

    //TODO 카카오톡메시지로 길찾기 결과 전송

    @GetMapping("/timetable")
    public GlobalResponse sendResultByTimeTable(){
        return GlobalResponse.builder().message("메시지가 전송되었습니다").build();
    }
    @GetMapping("/search")
    public GlobalResponse sendResultBySearch(){
        return GlobalResponse.builder().message("메시지가 전송되었습니다").build();
    }
}
