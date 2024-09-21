package com.knu.daeguhackathon.subject.service;

import com.knu.daeguhackathon.building.Building;
import com.knu.daeguhackathon.building.repository.BuildingRepository;
import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.member.repository.MemberRepository;
import com.knu.daeguhackathon.subject.Subject;
import com.knu.daeguhackathon.subject.controller.dto.SubjectRequest;
import com.knu.daeguhackathon.subject.controller.dto.SubjectResponse;
import com.knu.daeguhackathon.subject.repository.SubjectRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final MemberRepository memberRepository;
    private final BuildingRepository buildingRepository;

    public void addSubject(Long loginMemberId, SubjectRequest.Add request) {
        Member loginMember = memberRepository.findById(loginMemberId).orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));
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
        Member loginMember = memberRepository.findById(loginMemberId).orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));
        Subject subject = subjectRepository.findById(subjectId)
            .orElseThrow(() -> new RuntimeException("해당 과목을 찾을 수 없습니다."));

        if (!subject.getMember().getId().equals(loginMember.getId())) {
            throw new RuntimeException("삭제 권한이 없습니다.");
        }

        subjectRepository.deleteById(subjectId);
    }

    public void deleteAllSubject(Long loginMemberId) {
        Member loginMember = memberRepository.findById(loginMemberId).orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));
        List<Subject> subjects = subjectRepository.findAllByMember(loginMember);

        if (subjects.isEmpty()) {
            throw new RuntimeException("삭제할 과목이 없습니다.");
        }

        subjectRepository.deleteAll(subjects);

    }

    public void updateSubject(Long loginMemberId, Long subjectId, SubjectRequest.Update request) {

        Member loginMember = memberRepository.findById(loginMemberId).orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));

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

    public SubjectResponse.Subjects getSubjectByName(SubjectRequest.Name request) {
        List<Subject> allSubjects = subjectRepository.findAllByCourseName(request.name());

        if (allSubjects.isEmpty()) {
            throw new RuntimeException("해당 과목을 찾을 수 없습니다.");
        }
        List<SubjectResponse.Info> subjectInfos = allSubjects.stream()
            .map(subject -> SubjectResponse.Info.builder()
                .name(subject.getCourseName())
                .location(subject.getBuilding().getBuildingName())
                .code(subject.getSubjectCode())
                .startHour(subject.getStartHour())
                .finalHour(subject.getFinalHour())
                .build())
            .toList();

        return SubjectResponse.Subjects.builder()
            .subjects(subjectInfos)
            .build();

    }
}
