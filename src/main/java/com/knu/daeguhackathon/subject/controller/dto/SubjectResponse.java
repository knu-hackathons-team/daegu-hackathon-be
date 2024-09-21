package com.knu.daeguhackathon.subject.controller.dto;


import java.util.List;
import java.util.Map;

import lombok.Builder;

public class SubjectResponse {

    @Builder
    public record Subjects(
        List<SubjectResponse.Info> subjects
    ) {

    }

    @Builder
    public record Info(
        String name,
        String location,
        String code,
        double startHour,
        double finalHour,

        Map<String, String> lectureTime
    ) {

    }
    @Builder
    public record SubjectList(
            List<SubjectResponse.ListInfo> subjects
    ) {

    }
    @Builder
    public record ListInfo(
            String name,
            String location,
            String code,
            Map<String, String> lectureTime
    ) {

    }
}
