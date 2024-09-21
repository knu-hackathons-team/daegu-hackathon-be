package com.knu.daeguhackathon.member;

import com.knu.daeguhackathon.global.BaseTimeEntity;
import com.knu.daeguhackathon.searchlog.SearchLog;
import com.knu.daeguhackathon.kakaotoken.KakaoToken;
import com.knu.daeguhackathon.subject.Subject;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String name;
    @NotNull
    private LocalDateTime createdTime;
    private Double speed;
    private String nickName;
    @NotNull
    @OneToOne
    private KakaoToken kakaoToken;
    @NotNull
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Subject> subjects = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<SearchLog> SearchLogs = new ArrayList<>();
}
