package com.knu.daeguhackathon.building.controller.dto;

import java.util.List;
import lombok.Builder;

public class BuildingResponse {

    @Builder
    public record Buildings(
        List<Info> buildings
    ) {

    }


    @Builder
    public record Info(
        String buildingName,
        Double latitude,
        Double longitude
    ) {

    }
}
