package com.knu.daeguhackathon.subject.controller.dto;


import java.util.List;
import lombok.Builder;

public class SubjectRepsonse {

    @Builder
    public record Subjects(
        List<Info> subjects
    ) {

    }

    @Builder
    public record Info(
        String name,
        String location,
        String code,
        double startHour,
        double finalHour
    ) {

    }
}
