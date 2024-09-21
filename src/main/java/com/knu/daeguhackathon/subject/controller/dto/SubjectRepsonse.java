package com.knu.daeguhackathon.subject.controller.dto;


import com.knu.daeguhackathon.subject.Subject;
import lombok.Builder;

import java.util.List;

public class SubjectRepsonse {

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
