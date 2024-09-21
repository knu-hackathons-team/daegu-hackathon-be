package com.knu.daeguhackathon.subject;

import com.knu.daeguhackathon.building.Building;
import com.knu.daeguhackathon.global.BaseTimeEntity;
import com.knu.daeguhackathon.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String courseName;
    @NotNull
    private String subjectCode;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @NotNull
    @OneToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @NotNull
    private Double startHour;
    @NotNull
    private Double finalHour;

    public void updateSubjectInfo(String courseName, String subjectCode, Building building, double startHour, double finalHour){
        this.courseName = courseName;
        this.subjectCode = subjectCode;
        this.building = building;
        this.startHour = startHour;
        this.finalHour = finalHour;
    }
}
