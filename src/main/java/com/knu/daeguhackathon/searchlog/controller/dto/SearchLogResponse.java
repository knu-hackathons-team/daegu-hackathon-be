package com.knu.daeguhackathon.searchlog.controller.dto;

import lombok.Builder;

import java.util.List;

public class SearchLogResponse {
    @Builder
    public record Logs(
            List<Info> logs
    ){

    }
    @Builder
    public record Info(
            String startBuildingName,
            String endBuildingName
    ){

    }
}
