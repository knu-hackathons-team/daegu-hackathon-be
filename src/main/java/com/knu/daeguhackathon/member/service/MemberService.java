package com.knu.daeguhackathon.member.service;

import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.member.dto.MemberResponse;
import com.knu.daeguhackathon.member.dto.MemberSpeed;
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

    public void registerMember(String email) {
        memberRepository.findByEmail(email)
            .ifPresentOrElse(member -> {
                throw new RuntimeException("이미 존재하는 email입니다.");
            }, () -> {
                Member newMember = Member.builder().email(email).createdTime(
                    LocalDateTime.now()).build();
                memberRepository.save(newMember);
            });
    }

    @Transactional
    public void addMemberInfo(Long memberId, String name, Double speed, String nickname) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("id에 해당하는 member가 없습니다."));
        member.setDetail(name, speed, nickname);
    }

    public boolean findUserByEmail(String email) {
        return memberRepository.findByEmail(email).isPresent();
    }

    public MemberResponse getMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
            () -> new RuntimeException("id에 해당하는 멤버가 없습니다.")
        );

        return MemberResponse.builder()
            .name(member.getName())
            .nickName(member.getName())
            .email(member.getEmail())
            .createdTime(member.getCreatedTime())
            .build();
    }

    @Transactional
    public void changeMemberNickName(Long memberId, String nickName) {
        Member member = memberRepository.findById(memberId).orElseThrow(
            () -> new RuntimeException("id에 해당하는 멤버가 없습니다.")
        );
        member.setNickName(nickName);
    }

    @Transactional
    public void changeMemberSpeed(Long memberId, Double speed) {
        Member member = memberRepository.findById(memberId).orElseThrow(
            () -> new RuntimeException("id에 해당하는 멤버가 없습니다.")
        );
        member.setSpeed(speed);
    }

    public MemberSpeed getMemberSpeed(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
            () -> new RuntimeException("id에 해당하는 멤버가 없습니다.")
        );
        return new MemberSpeed(member.getSpeed());
    }

}
