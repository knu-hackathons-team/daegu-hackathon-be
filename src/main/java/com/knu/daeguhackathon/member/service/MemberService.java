package com.knu.daeguhackathon.member.service;

import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TokenService tokenService;

    public Member getMemberByToken(String token) {
        String email = tokenService.extractEmail(token);
        return memberRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("유효하지 않은 토큰입니다."));
    }

    public void registerMember(String email, String name) {
        memberRepository.findByEmail(email)
            .ifPresentOrElse(member -> {
                throw new RuntimeException("이미 존재하는 email입니다.");
            }, () -> {
                Member newMember = Member.builder().email(email).name(name).createdTime(
                    LocalDateTime.now()).build();
                memberRepository.save(newMember);
            });
    }

    @Transactional
    public void addMemberInfo(Long memberId, int speed, String nickname) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("id에 해당하는 member가 없습니다."));
        member.setDetail(speed, nickname);
    }

}
