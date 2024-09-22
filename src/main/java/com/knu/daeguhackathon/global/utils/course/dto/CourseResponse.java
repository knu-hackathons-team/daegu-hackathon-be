package com.knu.daeguhackathon.global.utils.course.dto;

import java.util.List;
import java.util.Map;
import lombok.Builder;

public class CourseResponse {
    @Builder
    public record Lists(
        List<Info> courses
    ){

    }

    @Builder
    public record Info(
        String name,
        String location,
        String code,
        Map<String, String> lectureTime
    ){

    }

}
