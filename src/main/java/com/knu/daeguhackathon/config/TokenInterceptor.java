package com.knu.daeguhackathon.config;

import com.knu.daeguhackathon.member.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {

    private final TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        String token = getTokenFromRequest(request);
        String email = validateTokenAndExtractEmail(token);

        request.setAttribute("email", email);
        return true;
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new RuntimeException("토큰이 없거나, 헤더 형식에 맞지 않습니다.");
        }
        return authorizationHeader.substring(7);
    }

    private String validateTokenAndExtractEmail(String token) {
        return tokenService.extractEmail(token);
    }
}
