package com.knu.daeguhackathon.distance.controller.dto;

import lombok.Builder;

public class DistanceRequest {

    @Builder
    public record Info(
        String startBuildingName,
        String endBuildingName,
        Double buildingDistance,
        int estimatedTime,
        String imageUrl,
        String dayName

    ) {

    }
}
