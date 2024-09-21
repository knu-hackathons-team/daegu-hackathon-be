package com.knu.daeguhackathon.searchlog.controller.dto;

import java.util.List;
import lombok.Builder;

public class SearchLogResponse {

    @Builder
    public record Logs(
        List<Info> logs
    ) {

    }

    @Builder
    public record Info(
        String startBuildingName,
        String endBuildingName
    ) {

    }
}
