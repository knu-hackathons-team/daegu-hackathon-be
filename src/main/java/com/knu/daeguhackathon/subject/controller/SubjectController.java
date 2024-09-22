package com.knu.daeguhackathon.subject.controller;

import com.knu.daeguhackathon.config.LoginMember;
import com.knu.daeguhackathon.global.dto.GlobalResponse;
import com.knu.daeguhackathon.subject.controller.dto.SubjectRequest;
import com.knu.daeguhackathon.subject.controller.dto.SubjectResponse;
import com.knu.daeguhackathon.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("")
    public GlobalResponse addSubject(
        @RequestBody SubjectRequest.Add request,
        @LoginMember Long memberId
    ) {
        subjectService.addSubject(memberId, request);
        return GlobalResponse.builder().message("과목생성완료").build();

    }

    @DeleteMapping("/{subjectId}")
    public GlobalResponse deleteSubject(
        @RequestParam(name = "subjectId") Long subjectId,
        @LoginMember Long memberId
    ) {
        subjectService.deleteSubject(memberId, subjectId);
        return GlobalResponse.builder().message("과목삭제완료").build();
    }

    @PatchMapping("/{subjectId}")
    public GlobalResponse updateSubject(
        @RequestParam(name = "subjectId") Long subjectId,
        @RequestBody SubjectRequest.Update request,
        @LoginMember Long memberId
    ) {
        subjectService.updateSubject(memberId, subjectId, request);
        return GlobalResponse.builder().message("과목수정완료").build();
    }

    @DeleteMapping("")
    public GlobalResponse deleteAllubject(
        @LoginMember Long memberId
    ) {
        subjectService.deleteAllSubject(memberId);
        return GlobalResponse.builder().message("전체과목삭제완료").build();
    }

    @GetMapping("/search")
    public SubjectResponse.Subjects getSubjectsByName(
        @RequestParam("name") String name
    ) {
        return subjectService.getSubjectByName(name);

    }

    @GetMapping("")
    public SubjectResponse.SubjectList getSubjects() {
        return subjectService.getSubjectList();
    }
}
