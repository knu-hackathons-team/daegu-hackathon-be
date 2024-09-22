package com.knu.daeguhackathon.subject.service;

import com.knu.daeguhackathon.building.Building;
import com.knu.daeguhackathon.building.repository.BuildingRepository;
import com.knu.daeguhackathon.global.utils.course.Course;
import com.knu.daeguhackathon.global.utils.course.dto.CourseResponse;
import com.knu.daeguhackathon.global.utils.course.repository.CourseRepository;
import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.member.repository.MemberRepository;
import com.knu.daeguhackathon.subject.Subject;
import com.knu.daeguhackathon.subject.controller.dto.SubjectRequest;
import com.knu.daeguhackathon.subject.controller.dto.SubjectResponse;
import com.knu.daeguhackathon.subject.repository.SubjectRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final MemberRepository memberRepository;
    private final BuildingRepository buildingRepository;
    private final CourseRepository courseRepository;

    public void addSubject(Long loginMemberId, SubjectRequest.Add request) {
        Member loginMember = memberRepository.findById(loginMemberId)
            .orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));
        Member member = memberRepository.findById(loginMember.getId())
            .orElseThrow(() -> new RuntimeException("해당 사용자를 찾을 수 없습니다."));

        Building building = buildingRepository.findByBuildingName(request.building())
            .orElseThrow(() -> new RuntimeException("해당 빌딩을 찾을 수 없습니다."));

        Subject newSubject = Subject.builder()
            .courseName(request.name())
            .member(member)
            .building(building)
            .startHour(request.startHour())
            .finalHour(request.finalHour())
            .build();

        subjectRepository.save(newSubject);
    }

    public void deleteSubject(Long loginMemberId, Long subjectId) {
        Member loginMember = memberRepository.findById(loginMemberId)
            .orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));
        Subject subject = subjectRepository.findById(subjectId)
            .orElseThrow(() -> new RuntimeException("해당 과목을 찾을 수 없습니다."));

        if (!subject.getMember().getId().equals(loginMember.getId())) {
            throw new RuntimeException("삭제 권한이 없습니다.");
        }

        subjectRepository.deleteById(subjectId);
    }

    public void deleteAllSubject(Long loginMemberId) {
        Member loginMember = memberRepository.findById(loginMemberId)
            .orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));
        List<Subject> subjects = subjectRepository.findAllByMember(loginMember);

        if (subjects.isEmpty()) {
            throw new RuntimeException("삭제할 과목이 없습니다.");
        }

        subjectRepository.deleteAll(subjects);

    }

    public void updateSubject(Long loginMemberId, Long subjectId, SubjectRequest.Update request) {

        Member loginMember = memberRepository.findById(loginMemberId)
            .orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));

        Subject subject = subjectRepository.findById(subjectId)
            .orElseThrow(() -> new RuntimeException("해당 과목을 찾을 수 없습니다."));

        if (!subject.getMember().getId().equals(loginMember.getId())) {
            throw new RuntimeException("수정 권한이 없습니다.");
        }

        Building building = buildingRepository.findByBuildingName(request.building())
            .orElseThrow(() -> new RuntimeException("해당 빌딩을 찾을 수 없습니다."));

        subject.updateSubjectInfo(request.name(), request.code(), building, request.startHour(),
            request.finalHour());

        subjectRepository.save(subject);
    }

    public CourseResponse.Lists getSubjectByName(String name) {
        List<Course> allSubjects = courseRepository.findAllByCourseNameContaining(name);

        if (allSubjects.isEmpty()) {
            throw new RuntimeException("해당 과목을 찾을 수 없습니다.");
        }
        List<CourseResponse.Info> subjectInfos = allSubjects.stream()
            .map(course -> CourseResponse.Info.builder()
                .name(course .getCourseName())
                .location(course .getClassroom())
                .code(course.getCourseId())
                .lectureTime(parseLectureTime(course.getLectureTime()))
                .build())
            .toList();

        return CourseResponse.Lists.builder()
            .courses(subjectInfos)
            .build();

    }

    public SubjectResponse.SubjectList getSubjectList() {
        List<Course> courseList = courseRepository.findAll();

        List<SubjectResponse.ListInfo> subjectList = courseList.stream().map(
            course -> SubjectResponse.ListInfo.builder()
                .name(course.getCourseName())
                .location(course.getClassroom())
                .code(course.getCourseId())
                .lectureTime(parseLectureTime(course.getLectureTime()))
                .build()

        ).toList();
        return SubjectResponse.SubjectList.builder()
            .subjects(subjectList)
            .build();
    }

    private Map<String, String> parseLectureTime(String rawLectureTime) {
        Map<String, String> lectureTimeMap = new HashMap<>();

        String[] dayTimePairs = rawLectureTime.split("\n");

        for (String dayTimePair : dayTimePairs) {
            String[] parts = dayTimePair.split(" ", 2);
            if (parts.length == 2) {
                String day = parts[0];
                String times = parts[1];

                lectureTimeMap.merge(day, times,
                    (existingTimes, newTimes) -> existingTimes + ", " + newTimes);
            }
        }

        return lectureTimeMap;
    }
}
