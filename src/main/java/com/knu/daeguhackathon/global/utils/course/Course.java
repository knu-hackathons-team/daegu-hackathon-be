package com.knu.daeguhackathon.global.utils.course;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String courseId;     // 강좌번호
    private String courseName;   // 교과목명
    private String type;         // 구분
    private String lectureTime;   // 강의시간
    private String classroom;     // 강의실


}
