package com.knu.daeguhackathon.searchlog;

import com.knu.daeguhackathon.global.BaseTimeEntity;
import com.knu.daeguhackathon.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchLog extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private String startBuildingName;
    private String endBuildingName;
    private String imageUrl;
    private int estimatedTime;
    private Double buildingDistance;
    private String dayName;
}

