package com.knu.daeguhackathon.building.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

public class BuildingResponse {
    @Builder
    public record Buildings(
            List<Info> buildings
    ){

    }


    @Builder
    public record Info(
            String buildingName,
            Double latitude,
            Double longitude
    ){

    }
}
