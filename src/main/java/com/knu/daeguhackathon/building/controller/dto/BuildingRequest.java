package com.knu.daeguhackathon.building.controller.dto;

import lombok.Builder;

public class BuildingRequest {

    @Builder
    public record Name(
        String name
    ) {

    }
}
