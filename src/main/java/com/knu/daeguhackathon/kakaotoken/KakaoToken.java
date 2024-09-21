package com.knu.daeguhackathon.kakaotoken;

import com.knu.daeguhackathon.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoToken {

    @NotNull
    int expires_in;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @NotNull
    private String accessToken;
    @NotNull
    private String refreshToken;
    @NotNull
    private LocalDateTime issuedAt;
    @NotNull
    private LocalDateTime updated_at;
}
