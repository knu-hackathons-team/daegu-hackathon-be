package com.knu.daeguhackathon.subject.controller.dto;


import lombok.Builder;

import java.util.List;

public class SubjectResponse {

    @Builder
    public record Subjects(
            List<Info> subjects
    ){

    }

    @Builder
    public record Info(
            String name,
            String location,
            String code,
            double startHour,
            double finalHour
    ){

    }
}
