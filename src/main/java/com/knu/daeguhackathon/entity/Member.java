package com.knu.daeguhackathon.entity;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

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
    private List<searchLog> searchLogs = new ArrayList<>();
}
