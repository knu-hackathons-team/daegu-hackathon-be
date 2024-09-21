package com.knu.daeguhackathon.subject.controller;

<<<<<<< HEAD
import com.knu.daeguhackathon.subject.controller.dto.SubjectRepsonse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import com.knu.daeguhackathon.global.dto.GlobalResponse;
import com.knu.daeguhackathon.subject.controller.dto.SubjectResponse;
import com.knu.daeguhackathon.subject.controller.dto.SubjectRequest;
import com.knu.daeguhackathon.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
>>>>>>> main

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("")
    public GlobalResponse addSubject(
            @RequestBody SubjectRequest.Add request
            ){
        //TODO addSubject()
        return GlobalResponse.builder().message("과목생성완료").build();

    }
    @DeleteMapping("/{subjectId}")
    public GlobalResponse deleteSubject(
            @RequestParam(name = "subjectId") Long subjectId
            )
    {
        //TODO deleteSubject()
        return GlobalResponse.builder().message("과목삭제완료").build();
    }
    @PatchMapping("/{subjectId}")
    public GlobalResponse updateSubject(
            @RequestParam(name = "subjectId") Long subjectId,
            @RequestBody SubjectRequest.Update request
    ){
        //TODO updateSubject()
        return GlobalResponse.builder().message("과목수정완료").build();
    }
    @DeleteMapping("")
    public GlobalResponse deleteAllubject(
    )
    {
        //TODO deleteAllSubject()
        return GlobalResponse.builder().message("전체과목삭제완료").build();
    }

    @GetMapping("/search")
    public SubjectResponse.Subjects getSubjectsByName(
            @RequestBody SubjectRequest.Name request
    ){
        return subjectService.getSubjectByName(request);

    }

    @GetMapping("")
<<<<<<< HEAD
    public SubjectRepsonse.Subjects getSubjects() {
        return SubjectRepsonse.Subjects.builder()
            .subjects(
                List.of(
                    new SubjectRepsonse.Info("국어와 매체언어", "산격동 캠퍼스 인문대학101", "CLTR0001-001", 9.0,
                        13.0),
                    new SubjectRepsonse.Info("고급 프로그래밍", "산격동 캠퍼스 IT대학201", "COMP2001-002", 10.0,
                        12.0),
                    new SubjectRepsonse.Info("데이터베이스 개론", "산격동 캠퍼스 IT대학305", "COMP3001-003", 14.0,
                        16.0),
                    new SubjectRepsonse.Info("영어회화", "산격동 캠퍼스 어학센터202", "ENG1010-004", 11.0, 13.0),
                    new SubjectRepsonse.Info("물리학 실험", "산격동 캠퍼스 과학관B102", "PHYS2002-005", 8.0,
                        10.0),
                    new SubjectRepsonse.Info("미적분학", "산격동 캠퍼스 수학관105", "MATH1001-006", 9.0, 11.0),
                    new SubjectRepsonse.Info("화학 기초", "산격동 캠퍼스 과학관B203", "CHEM1001-007", 10.0,
                        12.0),
                    new SubjectRepsonse.Info("정치와 사회", "산격동 캠퍼스 사회과학대학301", "POLI2001-008", 13.0,
                        15.0),
                    new SubjectRepsonse.Info("심리학 입문", "산격동 캠퍼스 사회과학대학102", "PSYC1001-009", 11.0,
                        13.0),
                    new SubjectRepsonse.Info("기초 경제학", "산격동 캠퍼스 경제학부201", "ECON1001-010", 12.0,
                        14.0),
                    new SubjectRepsonse.Info("회계학 개론", "산격동 캠퍼스 경영대학103", "ACCT2001-011", 13.0,
                        15.0),
                    new SubjectRepsonse.Info("마케팅 전략", "산격동 캠퍼스 경영대학202", "MKTG3002-012", 9.0,
                        11.0),
                    new SubjectRepsonse.Info("역사와 문화", "산격동 캠퍼스 인문대학204", "HIST1001-013", 10.0,
                        12.0),
                    new SubjectRepsonse.Info("프랑스어 입문", "산격동 캠퍼스 어학센터203", "FREN1001-014", 14.0,
                        16.0),
                    new SubjectRepsonse.Info("중국어 기초", "산격동 캠퍼스 어학센터205", "CHIN1001-015", 9.0,
                        11.0),
                    new SubjectRepsonse.Info("스포츠와 건강", "산격동 캠퍼스 체육관B101", "SPRT1001-016", 8.0,
                        10.0),
                    new SubjectRepsonse.Info("미술사 개론", "산격동 캠퍼스 미술대학102", "ART1001-017", 13.0,
                        15.0),
                    new SubjectRepsonse.Info("작문과 발표", "산격동 캠퍼스 인문대학107", "WRIT1001-018", 11.0,
                        13.0),
                    new SubjectRepsonse.Info("심화 통계학", "산격동 캠퍼스 수학관202", "STAT2001-019", 9.0, 11.0),
                    new SubjectRepsonse.Info("철학의 이해", "산격동 캠퍼스 인문대학301", "PHIL1001-020", 10.0,
                        12.0)
=======
    public SubjectResponse.Subjects getSubjects(){
        return SubjectResponse.Subjects.builder()
                .subjects(
                        List.of(
                                new SubjectResponse.Info("국어와 매체언어", "산격동 캠퍼스 인문대학101", "CLTR0001-001", 9.0, 13.0),
                                new SubjectResponse.Info("고급 프로그래밍", "산격동 캠퍼스 IT대학201", "COMP2001-002", 10.0, 12.0),
                                new SubjectResponse.Info("데이터베이스 개론", "산격동 캠퍼스 IT대학305", "COMP3001-003", 14.0, 16.0),
                                new SubjectResponse.Info("영어회화", "산격동 캠퍼스 어학센터202", "ENG1010-004", 11.0, 13.0),
                                new SubjectResponse.Info("물리학 실험", "산격동 캠퍼스 과학관B102", "PHYS2002-005", 8.0, 10.0),
                                new SubjectResponse.Info("미적분학", "산격동 캠퍼스 수학관105", "MATH1001-006", 9.0, 11.0),
                                new SubjectResponse.Info("화학 기초", "산격동 캠퍼스 과학관B203", "CHEM1001-007", 10.0, 12.0),
                                new SubjectResponse.Info("정치와 사회", "산격동 캠퍼스 사회과학대학301", "POLI2001-008", 13.0, 15.0),
                                new SubjectResponse.Info("심리학 입문", "산격동 캠퍼스 사회과학대학102", "PSYC1001-009", 11.0, 13.0),
                                new SubjectResponse.Info("기초 경제학", "산격동 캠퍼스 경제학부201", "ECON1001-010", 12.0, 14.0),
                                new SubjectResponse.Info("회계학 개론", "산격동 캠퍼스 경영대학103", "ACCT2001-011", 13.0, 15.0),
                                new SubjectResponse.Info("마케팅 전략", "산격동 캠퍼스 경영대학202", "MKTG3002-012", 9.0, 11.0),
                                new SubjectResponse.Info("역사와 문화", "산격동 캠퍼스 인문대학204", "HIST1001-013", 10.0, 12.0),
                                new SubjectResponse.Info("프랑스어 입문", "산격동 캠퍼스 어학센터203", "FREN1001-014", 14.0, 16.0),
                                new SubjectResponse.Info("중국어 기초", "산격동 캠퍼스 어학센터205", "CHIN1001-015", 9.0, 11.0),
                                new SubjectResponse.Info("스포츠와 건강", "산격동 캠퍼스 체육관B101", "SPRT1001-016", 8.0, 10.0),
                                new SubjectResponse.Info("미술사 개론", "산격동 캠퍼스 미술대학102", "ART1001-017", 13.0, 15.0),
                                new SubjectResponse.Info("작문과 발표", "산격동 캠퍼스 인문대학107", "WRIT1001-018", 11.0, 13.0),
                                new SubjectResponse.Info("심화 통계학", "산격동 캠퍼스 수학관202", "STAT2001-019", 9.0, 11.0),
                                new SubjectResponse.Info("철학의 이해", "산격동 캠퍼스 인문대학301", "PHIL1001-020", 10.0, 12.0)
                        )
>>>>>>> main
                )
            )
            .build();
    }
}
