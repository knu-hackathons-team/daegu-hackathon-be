package com.knu.daeguhackathon.distance.controller.dto;

import lombok.Builder;

public class DistanceRequest {

    @Builder
    public record Info(
        String startBuildingName,
        String endBuildingName,
        int buildingDistance,
        int estimatedTime,
        String imageUrl

    ) {

    }
}
