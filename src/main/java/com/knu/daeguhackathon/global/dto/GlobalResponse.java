package com.knu.daeguhackathon.global.dto;

import lombok.Builder;

@Builder
public record GlobalResponse(
    String message
) {

}
