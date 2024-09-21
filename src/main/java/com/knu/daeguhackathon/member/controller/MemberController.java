package com.knu.daeguhackathon.member.controller;

import com.knu.daeguhackathon.config.KakaoProperties;
import com.knu.daeguhackathon.config.LoginMember;
import com.knu.daeguhackathon.kakaotoken.dto.KakaoTokenResponse;
import com.knu.daeguhackathon.kakaotoken.service.KakaoApiService;
import com.knu.daeguhackathon.kakaotoken.service.KakaoTokenService;
import com.knu.daeguhackathon.member.dto.MemberRequest;
import com.knu.daeguhackathon.member.dto.MemberResponse;
import com.knu.daeguhackathon.member.dto.MemberSpeed;
import com.knu.daeguhackathon.member.service.MemberService;
import com.knu.daeguhackathon.member.service.TokenService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final KakaoApiService kakaoApiService;
    private final KakaoTokenService kakaoTokenService;
    private final KakaoProperties kakaoProperties;
    private final TokenService tokenService;
    private final MemberService memberService;

    @GetMapping("/auth/oauth/kakao")
    public RedirectView redirectToAuthorization() {
        String url = kakaoApiService.getAuthorizationUrl();
        return new RedirectView(url);
    }

    @GetMapping("/auth/oauth/kakao/callback")
    public ResponseEntity<Void> kakaoCallback(@RequestParam("code") String code) {
        KakaoTokenResponse response = kakaoApiService.getAccessToken(code);
        String email = kakaoApiService.getUserInfo(response.accessToken()).kakaoAccount().email();

        if (!memberService.findUserByEmail(email)) {
            memberService.registerMember(email);
        }

        kakaoTokenService.saveKakaoToken(email, response);

        String jwt = tokenService.generateToken(email);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
            URI.create(kakaoProperties.getFrontRedirectUri() + "?tokenValue=" + jwt));

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @PostMapping("/member/detail")
    public ResponseEntity<Void> AddUserInfoDetail(@LoginMember Long memberId,
        @RequestBody MemberRequest memberRequest) {
        memberService.addMemberInfo(memberId, memberRequest.getName(),
            memberRequest.getSpeed(), memberRequest.getNickName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/member/info")
    public ResponseEntity<MemberResponse> getMemberInfo(@LoginMember Long memberId) {
        MemberResponse response = memberService.getMemberInfo(memberId);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/member/nickname")
    public ResponseEntity<Void> changeMemberNickName(@LoginMember Long memberId, @RequestParam("nickname")
    String memberNickName) {
        memberService.changeMemberNickName(memberId, memberNickName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/member/speed")
    public ResponseEntity<MemberSpeed> getMemberSpeed(@LoginMember Long memberId) {
        MemberSpeed response = memberService.getMemberSpeed(memberId);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/member/speed")
    public ResponseEntity<Void> changeMemberSpeed(@LoginMember Long memberId, @RequestParam("speed") Double memberSpeed) {
        memberService.changeMemberSpeed(memberId, memberSpeed);
        return ResponseEntity.ok().build();
    }
}
