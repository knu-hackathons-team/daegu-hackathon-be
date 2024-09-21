package com.knu.daeguhackathon.member.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {

    private String email;
    private String name;
    private LocalDateTime createdTime;
    private int speed;
    private String nickName;
}
