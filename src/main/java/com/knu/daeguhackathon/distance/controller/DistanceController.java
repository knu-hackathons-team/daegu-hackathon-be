package com.knu.daeguhackathon.distance.controller;

import com.knu.daeguhackathon.distance.controller.dto.DistanceRequest;
import com.knu.daeguhackathon.distance.service.DistanceService;
import com.knu.daeguhackathon.global.dto.GlobalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/distance")
public class DistanceController {

    private final DistanceService distanceService;

    @PostMapping("/timetable")
    public GlobalResponse sendResultByTimeTable(
        @RequestBody DistanceRequest.Info request
    ) {
        //TODO saveDistance()

        return GlobalResponse.builder().message("ok").build();
    }

    @PostMapping("/search")
    public GlobalResponse sendResultBySearch(
        @RequestBody DistanceRequest.Info request
    ) {
        //TODO saveDistance()
        return GlobalResponse.builder().message("ok").build();
    }

}
