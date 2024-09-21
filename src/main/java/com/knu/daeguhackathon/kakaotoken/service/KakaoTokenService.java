package com.knu.daeguhackathon.kakaotoken.service;

import com.knu.daeguhackathon.kakaotoken.KakaoToken;
import com.knu.daeguhackathon.kakaotoken.dto.KakaoTokenResponse;
import com.knu.daeguhackathon.kakaotoken.repository.KakaoTokenRepository;
import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoTokenService {

    private final KakaoTokenRepository kakaoTokenRepository;
    private final KakaoApiService kakaoApiService;
    private final MemberRepository memberRepository;

    public KakaoToken saveKakaoToken(String email, KakaoTokenResponse tokenInfo) {

        Member member = memberRepository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("이메일에 해당하는 Member가 없습니다")
        );

        KakaoToken kakaoToken = KakaoToken.builder()
            .member(member)
            .accessToken(tokenInfo.accessToken())
            .refreshToken(tokenInfo.refreshToken())
            .expires_in(tokenInfo.expiresIn())
            .issuedAt(LocalDateTime.now())
            .updated_at(LocalDateTime.now())
            .build();

        return kakaoTokenRepository.save(kakaoToken);
    }

    @Transactional
    public void refreshKakaoToken(KakaoToken existingToken) {
        Map<String, Object> refreshedTokenInfo = kakaoApiService.refreshAccessToken(
            existingToken.getRefreshToken());

        existingToken.setAccessToken((String) refreshedTokenInfo.get("access_token"));
        existingToken.setUpdated_at(LocalDateTime.now());
    }

    @Transactional
    public void checkAndRefreshToken(String token) {
        KakaoToken kakaoToken = kakaoTokenRepository.findByAccessToken(token)
            .orElseThrow(() -> new RuntimeException("토큰이 없습니다."));
        if (kakaoToken.getIssuedAt().plusSeconds(kakaoToken.getExpires_in())
            .isBefore(LocalDateTime.now())) {
            refreshKakaoToken(kakaoToken);
        }
    }

    @Transactional
    public KakaoToken getAccessTokenByMemberId(Long memberId) {
        KakaoToken kakaoToken = kakaoTokenRepository.findByMemberId(memberId)
            .orElseThrow(() -> new RuntimeException("member Id에 해당하는 카카오엑세스토큰이 없습니다"));
        checkAndRefreshToken(kakaoToken.getAccessToken());
        return kakaoToken;
    }
}
