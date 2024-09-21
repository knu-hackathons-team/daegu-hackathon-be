package com.knu.daeguhackathon.building.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public class BuildingResponse {

    @Builder
    public record Info(
            String buildingName,
            Double latitude,
            Double longitude
    ){

    }
}
