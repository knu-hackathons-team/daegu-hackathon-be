package com.knu.daeguhackathon.global.utils.course.dto;

import io.swagger.v3.oas.annotations.info.Info;
import lombok.Builder;

import java.util.List;
import java.util.Map;

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
