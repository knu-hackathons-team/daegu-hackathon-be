package com.knu.daeguhackathon.subject.controller.dto;

import lombok.Builder;

public class SubjectRequest {

    @Builder
    public record Add(
        String name,
        String building,
        String code,
        double startHour,
        double finalHour
    ) {

    }

    @Builder
    public record Update(
        String name,
        String building,
        String code,
        double startHour,
        double finalHour
    ) {

    }

    @Builder
    public record Name(
        String name
    ) {

    }
}
