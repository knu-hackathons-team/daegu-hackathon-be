package com.knu.daeguhackathon.member.dto;

import com.knu.daeguhackathon.kakaotoken.KakaoToken;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {

    private String email;
    private String name;
    private Double speed;
    private String nickName;

}
